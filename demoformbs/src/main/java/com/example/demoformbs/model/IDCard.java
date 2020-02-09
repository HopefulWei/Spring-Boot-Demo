package com.example.demoformbs.model;

import java.io.Serializable;


public class IDCard implements Serializable {

    private static final long serialVersionUID = 1L;  // 实现序列化接口必需要用到的版本控制，可以在版本升级时反序列化仍保持对象的唯一性。
    private int id;
    private String code;

    public IDCard(int id, String code) {
        super();
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code=code;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "ID" + this.id + ",Code " + this.code;
    }

}