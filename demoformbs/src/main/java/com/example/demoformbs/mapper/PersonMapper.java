package com.example.demoformbs.mapper;

import com.example.demoformbs.model.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PersonMapper{

    public List<Person> selectPersonById2(@Param("id") Integer id);
    public List<SelectPersonById> selectPersonById3(@Param("id") Integer id);

}