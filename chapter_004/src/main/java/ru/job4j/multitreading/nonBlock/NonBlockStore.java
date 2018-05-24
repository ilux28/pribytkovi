package ru.job4j.multitreading.nonBlock;

import jdk.nashorn.internal.ir.Optimistic;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockStore {
    private ConcurrentHashMap<Integer, Task> concurrentHashMap = new ConcurrentHashMap<>();

    public NonBlockStore(ConcurrentHashMap<Integer, Task> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }
    public void add(Task task) {
        task.setVersion();
        for (ConcurrentHashMap.Entry<Integer, Task> item : concurrentHashMap.entrySet()) {
            if (task.getId() == item.getValue().getId()) {
                if (task.getVersion() != item.getValue().getVersion())
                    concurrentHashMap.put(task.getId(), task);
            }

        }
        concurrentHashMap.put(task.getId(), task);
        task.setVersion();
    }
    public void update(int id, Task task) {
        concurrentHashMap.put(id, task);
    }
    public Task delete(int id) {
        return concurrentHashMap.remove(id);
    }
}
