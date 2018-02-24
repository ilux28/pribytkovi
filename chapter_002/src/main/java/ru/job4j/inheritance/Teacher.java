package ru.job4j.inheritance;
/**
 * @author ilux28
 * @sience $id$
 * @version 0.1
 */
public class Teacher extends Doctor {
    public Teacher(){
        this.profession = "Teacher";
    }
    public Teacher(String name) {
        this.name = name;
        this.profession = "Teacher";
    }
    public String getName() {
        return this.name;
    }
    public void teachStudent() {
        Teacher tch = new Teacher("Иван");
        String tchn = tch.getName();
        Student stu = new Student("Алеша");
        String stun = stu.getName();
        System.out.println("Учитель " + tchn + " учит студента " + stun);
    }
}
