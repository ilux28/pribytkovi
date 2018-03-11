package ru.job4j.incapsulate;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, int[] range) {
        int value = -1;
        boolean invalid = true;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch(NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            }
        }while (invalid);
        return value;
    }
}
