package com.theironyard.entities;

import javax.persistence.*;

/**
 * Created by ericweidman on 3/9/16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    String name;

    @Column(nullable = false)
    String passowrdHash;


    public User() {

    }

    public String getPassowrdHash(){
        return passowrdHash;
    }

    public User(String name, String passwordHash) {
        this.name = name;
        this.passowrdHash = passwordHash;



    }
}
