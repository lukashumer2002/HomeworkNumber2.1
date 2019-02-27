package com.example.lhumer16_woche20;

public class Person {

    int id;
    String firstname;
    String lastname;
    String title;
    String email;
    String mastatus;
    String credidCard;

    public Person(int id, String firstname, String lastname, String title,String email, String mastatus, String credidCard)
    {
        this.id=id;this.firstname=firstname;this.lastname=lastname;this.title=title;this.email=email;this.mastatus=mastatus;this.credidCard=credidCard;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMastatus() {
        return mastatus;
    }

    public void setMastatus(String mastatus) {
        this.mastatus = mastatus;
    }

    public String getCredidCard() {
        return credidCard;
    }

    public void setCredidCard(String credidCard) {
        this.credidCard = credidCard;
    }
}
