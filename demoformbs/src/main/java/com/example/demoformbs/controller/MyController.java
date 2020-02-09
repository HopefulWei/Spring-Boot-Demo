package com.example.demoformbs.controller;
import com.example.demoformbs.mapper.PersonMapper;
import com.example.demoformbs.mapper.SelectPersonById;
import com.example.demoformbs.model.IDCard;
import com.example.demoformbs.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demoformbs.mapper.IDCardMapper;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class MyController {
    @Resource
    IDCardMapper IDCardMapper;

    @Resource
    PersonMapper PersonMapper;

    @RequestMapping("/MyBts")
    public String toMyBts() {
        List<IDCard> list=IDCardMapper.selectCodeById(1);
        // IDCardMapper.insert(9,"hello1");
        // IDCardMapper.delete(4);
        // IDCardMapper.update(1, "1234");
        for(IDCard num:list){
            System.out.println(num.toString());
        }

        List<Person> personTwo = PersonMapper.selectPersonById2(1);

        List<SelectPersonById> selectPersonById =PersonMapper.selectPersonById3(1);

        for(Person num:personTwo){
            System.out.println(num.toString());
        }

        for(SelectPersonById num:selectPersonById){
            System.out.println(num.toString());
        }





        return "MyBts";
    }


}