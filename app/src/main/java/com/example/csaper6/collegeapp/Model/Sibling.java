package com.example.csaper6.collegeapp.Model;

/**
 * Created by csaper6 on 12/9/16.
 */
public class Sibling extends Person{
    private int age;
    private String relationship;



    public Sibling(int age, String relationship) {
        super();
        this.age = age;
        this.relationship = relationship;
    }

    public Sibling(String firstName, String lastName, int age, String relationship) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.relationship = relationship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
