package com.cop.model;

import javax.persistence.*;

@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    @Column(unique = true)
    private String userId;

    private String type;
    private String password;

    public UserModel() {
    }

    public UserModel(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public UserModel(String name, String userId, String type) {
        this.name = name;
        this.userId = userId;
        this.type = type;
    }

    public UserModel(String name, String userId, String type, String password) {
        this.name = name;
        this.userId = userId;
        this.type = type;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
