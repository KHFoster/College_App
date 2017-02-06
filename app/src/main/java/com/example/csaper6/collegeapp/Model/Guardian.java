package com.example.csaper6.collegeapp.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Guardian extends Person{
    private int age;
    private String occupation;

    public Guardian(int age, String occupation) {
        this.age = 88;
        this.occupation = "Homie";
    }

    public Guardian(String firstName, String lastName, int age, String occupation) {
        super(firstName, lastName);
        this.age = age;
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
