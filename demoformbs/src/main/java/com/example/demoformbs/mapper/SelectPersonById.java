package com.example.demoformbs.mapper;

import org.springframework.stereotype.Component;

@Component
public class SelectPersonById{

    private Integer id;
    private String name;
    private Integer age;
    private String code;
    //省略setter和getter方法
    @Override
    public String toString() {
        return "Person [id=" +id+",name=" +name+ ",age=" +age+ ",code=" +code+ "]";
    }

}