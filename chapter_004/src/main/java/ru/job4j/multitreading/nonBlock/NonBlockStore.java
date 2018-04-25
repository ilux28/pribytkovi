package ru.job4j.multitreading.nonBlock;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockStore {
    private ConcurrentHashMap<Integer, Task> concurrentHashMap = new ConcurrentHashMap<>();

    public NonBlockStore(ConcurrentHashMap<Integer, Task> concurrentHashMap) {
        this.concurrentHashMap = concurrentHashMap;
    }
    public void add(Task task) {

        if (task.getVersion() == 0)
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
