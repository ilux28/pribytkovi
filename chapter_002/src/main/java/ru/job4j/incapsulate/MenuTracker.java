package ru.job4j.incapsulate;



public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[6];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
        this.actions[0] = this. new AddItem();
        this.actions[1] = new MenuTracker.ShowItem();
        this.actions[2] = new EditItem();
        this.actions[3] = new DeleteItem();
        this.actions[4] = new FindItemById();
        this.actions[5] = new FindItemByName();
     }
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    public class AddItem implements UserAction {

        public int key() {
            return 0;
        }

        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Plese, enter the task's name: ");
            String desk = input.ask("Plese, enter the task's desc: ");
            tracker.add(new Task(name, desk));
        }

        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item");
        }
    }
    public static class ShowItem implements UserAction {
            public int key() {
                return 1;
            }

            public void execute(Input input, Tracker tracker) {
               for (Item item : tracker.getAll()) {
                   System.out.println(
                           String.format("%s. %s", item.getId(), item.getName())
                   );
               }
            }

            public String info() {
                return String.format("%s. %s", this.key(), "Show all items");
            }
    }
    public class EditItem implements UserAction {

        public int key() {
            return 2;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Plese, enter the task's id: ");
            String name = input.ask("Plese, enter the task's name: ");
            String desc = input.ask("Please, enter the tack's desc: ");
            Task task = new Task(name, desc);
            task.setId(id);
            tracker.edit(task);
            }
        public String info() {
            return String.format("%s. %s", this.key(), "Edit the new item.");
        }
    }
    public class DeleteItem implements UserAction {
        public int key() {
            return 3;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Plese, enter the task's id: ");
            tracker.delete(id);
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Deleted item with switched id.");
        }
    }
    public class FindItemById implements UserAction {
        public int key() {
            return 4;
        }
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Plese, enter the task's id: ");
            System.out.println(tracker.findById(id).getName());
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Search item with switched id.");
        }
    }
    public class FindItemByName implements UserAction {
        public int key() {
            return 5;
        }
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Plese, enter the task's name: ");
            System.out.println(tracker.findByName(name).get(0).getId());
        }
        public String info() {
            return String.format("%s. %s", this.key(), "Search item with switched name.");
        }
    }
}
