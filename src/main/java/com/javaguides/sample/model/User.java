package com.javaguides.sample.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login")
public class User {
    @Id
    // @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String username;
    @Column(name="pwd")
    private String userpwd;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpwd() {
        return userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    }
