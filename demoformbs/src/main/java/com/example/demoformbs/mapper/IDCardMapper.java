package com.example.demoformbs.mapper;

import com.example.demoformbs.model.IDCard;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
public interface IDCardMapper{

    public List<IDCard> selectCodeById(int id);

    public void update(int id, String code);

    public void delete(int id);

    public void insert(int id, String code);


}