package ru.job4j.incapsulate;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FINDID = "4";
    private static final String FINDNAME = "5";
    private static final String EXIT = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }
    public void init(){
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("ведите пункт пеню");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showAll();
            } else if (EDIT.equals(answer)) {
                this.edit();
            } else if (DELETE.equals(answer)) {
                this.delete();
            } else if (FINDID.equals(answer)) {
                this.findId();
            } else if (FINDNAME.equals(answer)){
                this.findName();
            } else if(EXIT.equals(answer)) {
                exit = true;
            }
        }
    }
    private void createItem() {
        System.out.println("-----------Добавление новой заявки-------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------Новая заявка с getId : " + item.getId() + "----------");
    }
    private void showAll() {
        for (Item item : this.tracker.getAll()) {
            System.out.println(item.getId() + " " + item.getName() + " " + item.getDescription());
        }
    }
    private void edit() {
        System.out.println("---------------Редактирование новой заявки---------------");
        String name = this.input.ask("Введите имя на которое хотите заменить : ");
        String desc = this.input.ask("Введите описание на которое хотите поменять :");
        String id = this.input.ask("Введите Id заявки которую хотите заменить");
        Item item = new Item(name, desc);
        this.tracker.replace(id, item);
    }
    private void delete() {
        System.out.println("----------------------Удаление заявки по ID------------------------");
        String id = this.input.ask("Введите ID заявки которую хотите удалить :");
        this.tracker.delete(id);
    }
    private void findId() {
        System.out.println("-------------Поиск заявки по id-----------");
        String id = this.input.ask("Введите ID заявки которую хотите найти");
        Item item = new Item();
        item = this.tracker.findById(id);
        System.out.println("Имя найденной заявки " + item.name);
    }
    private void findName() {
        System.out.println("-------------Поиск заявки по name-----------");
        String name = this.input.ask("Введите имя заявки которую хотите найти");
        Item[] item = this.tracker.findByName(name);
        System.out.println("Имена найденных заявок " + item);
    }
    private void showMenu(){
        System.out.println("Меню.");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ID");
        System.out.println("5. Найти заявку по имени");
        System.out.println("6. Выйти");
    }
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
