package ru.job4j.incapsulate;

public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
   //     Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();

        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select"));
            menu.select(key);
        }   while(!"y".equals(this.input.ask("Exit? y")));
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI(input, tracker).init();
    }
}

