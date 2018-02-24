package ru.job4j.inheritance;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Doctor extends Profession {
    public Doctor() {
        this.profession = "Doctor";
    }
    public Doctor(String name) {
        this.name = name;
        this.profession = "Doctor";
    }
    public void heal(Patient patient) {
        Patient pat = new Patient("Оркадий");
        String patn = pat.getName();
        Doctor doc = new Doctor("Гаврила");
        String docn = doc.getName();
        System.out.println("Доктор " + docn + " лечит " + patn);
    }

}
