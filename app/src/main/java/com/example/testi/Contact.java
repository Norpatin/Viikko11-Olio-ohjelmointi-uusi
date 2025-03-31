package com.example.testi;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;
    private String contactGroup;
    private int id;



    public Contact(String firstName, String surName, String number, String contactGroup) {
        this.firstName = firstName;
        this.lastName = surName;
        this.number = number;
        this.contactGroup = contactGroup;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public String getFullName() {  //HUOM!!! tehtävän annossa ei String eikä void
        String FullName = firstName + " " + lastName;
        return FullName;
    }

    public int getId() {
        return id;
    }
}
