package ru.job4j.incapsulate;

public class ValidateInput extends ConsoleInput {
   private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }
    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            } catch(MenuOutException moe) {
                System.out.println("Please select key from menu.");
            }
        }while (invalid);
        return value;
    }
}
