package com.polysaas.mongo.entity;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class Users implements Serializable{
    /** serialVersionUID*/
    private static final long serialVersionUID = 7851645531395404455L;
    private String id;
    private String username;
    private String password;
    private Integer age;
    private Integer[] score;
    private String realname;
    
    
    
    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public Users() {
    }
    public Users(String id, String username, String password, Integer age, Integer[] score) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.score = score;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer[] getScore() {
        return score;
    }
    public void setScore(Integer[] score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Users [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", score=" + Arrays.toString(score) + "]";
    }
}
