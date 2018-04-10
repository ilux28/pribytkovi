package ru.job4j.multitreading.wordCount;

public class WordCount extends Thread {
    String line = new String();

    public WordCount(String line) {
        this.line = line;
    }
    @Override
    public void run() {
        int j = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                  j++;
            }
        }
        System.out.println(j);
    }
    public static void main(String[] args) {
        String x = "Кошка бросила котят, пусь лазают как хотят";
        WordCount y = new WordCount(x);
        CharCount z = new CharCount(x);
        System.out.println(" The programs was started!");
        z.start();
        y.start();
        if (z.isAlive()) { // если побочный поток CharCount еще жив
            try {
                z.join(); // подождать его
                y.join();
            } catch (InterruptedException e) {}
        }
        System.out.println(" The programs was finished!");
    }
}
