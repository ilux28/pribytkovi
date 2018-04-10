package ru.job4j.multitreading.wordCount;

public class CharCount extends Thread {
    String line = new String();

    public CharCount(String line) {
        this.line = line;
    }
    @Override
    public void run() {
        int j = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                j++;
            }
        }
        System.out.println(j);
        Thread.currentThread().interrupt();
    }
}
