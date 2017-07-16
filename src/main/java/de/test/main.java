package de.test;


/**
 * Created by VaniR on 16.07.2017.
 * Project: path_db
 */
public class main {
    public static void main(String[] args) {
        Student student = new Student();

        Address adresse = new Address();
        adresse.setCity("Hamburg");
        adresse.setStreet("Hallo");
        student.setAddress(adresse);
        student.setFirstName("Klaus");
        System.out.println(student.toString() + " | " + adresse.toString());
    }
}
