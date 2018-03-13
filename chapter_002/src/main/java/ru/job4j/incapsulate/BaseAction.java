package ru.job4j.incapsulate;

public class BaseAction implements UserAction {
    private final int key;
    private final String name;
    public BaseAction(String name, int key) {
        this.name = name;
        this.key = key;
    }
    @Override
    public int key() {
        return this.key;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(String.format("Name: %s| Desc: %s| Id: %s",
                    item.getName(), item.getDescription(), item.getId()));
        }
     }
    @Override
    public String info() {
        return String.format("%s : %s", this.key, this.name);
    }
}
