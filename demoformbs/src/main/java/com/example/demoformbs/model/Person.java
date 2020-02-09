package com.example.demoformbs.model;

import java.io.Serializable;


public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int age;
    private int idcard_id;
    private IDCard idCard;

    public Person(int id, String name,int age, int idcard_id) {
        super();
        this.id = id;
        this.name = name;
        this.age=age;
        this.idcard_id=idcard_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getIdcard_id() {
        return idcard_id;
    }

    public void setIdcard_id(int idcard_id) {
        this.idcard_id=idcard_id;
    }

    public IDCard getIdcard() {
        return idCard;
    }

    public void setIdcard(IDCard idcard) {
        this.idCard=idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID" + this.id + ",Name " + this.name + ",age " + this.age + ",IDCard_id " + this.idcard_id;
    }

}