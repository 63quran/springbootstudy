package com.example.contrroller;

import com.example.SnowflakeUtil;
import com.example.dao.PersonEntity;
import com.example.dao.mapper.PersonMapper;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonListController {

    @Autowired
    private PersonMapper personMapper;

    @RequestMapping("/list")
    @ResponseBody
    public List<PersonEntity> listPerson(){

        return personMapper.listPerson();
    }



    @RequestMapping("/insert")
    @ResponseBody
    public int insertPerson(@RequestBody PersonEntity personEntity){

        SnowflakeUtil snowflakeUtil = new SnowflakeUtil();
        long workerId = snowflakeUtil.nextId();
        String id = workerId + "";
        personEntity.setId(id);
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        personEntity.setCreateTime(createTime);
        return personMapper.insertPerson(personEntity);
    }
}
