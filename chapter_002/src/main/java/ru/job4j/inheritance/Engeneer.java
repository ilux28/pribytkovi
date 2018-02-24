package ru.job4j.inheritance;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Engeneer extends Profession {
    String name;
    public Engeneer(String name) {
        this.name = name;
    }
    public void build() {
        Engeneer eng = new Engeneer("Александр");
        String engn = eng.getName();
        House ho = new House("Большой");
        String hon = ho.getName();
        System.out.println("Инженер " + eng + " строит дом " + ho);
    }
}
