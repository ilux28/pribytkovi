package ru.job4j.multitreading.searchText;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@ThreadSafe
public class ParallelSearch {
    private final String root;
    private final String text;
    private final List<String> exts;

    @GuardedBy("this")
    private final Queue<String> files = new LinkedList<>();
    @GuardedBy("this")
    private final List<String> paths = new LinkedList<>();

    public ParallelSearch(String root, String text, List<String> exts) {
        this.root = root;
        this.text = text;
        this.exts = exts;

    }
    boolean finish = false;
    public void init() throws InterruptedException {

        Thread search = new Thread() {
            @Override
            public void run() {
                try {
                    Files.walkFileTree(Paths.get(root), new MyFileVisitor());
                } catch (IOException e) {
                    e.printStackTrace();
                } finish = true;
            }
        };
        Thread read = new Thread() {
            @Override
            public synchronized void run() {
                while (!finish) {
                    if (!files.isEmpty()) {
                        for (String tmp : files) {
                            if (tmp.contains(text)) {
                                paths.add(tmp);
                                break;
                            }
                        }
                    }
                }
            }
        };
    }
}
