package com.theironyard;

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

    @Column(nullable = false)
    String name;
}
