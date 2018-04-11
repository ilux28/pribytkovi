package ru.job4j.multitreading.programStop;

public class CharCount implements Runnable {
    String line;
    public CharCount(String  line) {
        this.line = line;
    }
    @Override
    public void run() {
        int j = 0;
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) != ' ') {
                j++;
            }
        }
        System.out.println(j);
    }
}
