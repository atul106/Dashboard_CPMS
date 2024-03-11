package com.dashboard.entities;

import jakarta.persistence.*;

@Entity
@Table(name="cpms")
public class Cpms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String Firstname;
    private String LastName;
    private String Files;
    private String txn;
    private String City;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFiles() {
        return Files;
    }

    public void setFiles(String files) {
        Files = files;
    }

    public String getTxn() {
        return txn;
    }

    public void setTxn(String txn) {
        this.txn = txn;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
