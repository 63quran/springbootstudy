package com.example.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.dao.PersonEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonMapper extends BaseMapper<PersonEntity> {

    List<PersonEntity> listPerson();

    int insertPerson(PersonEntity personEntity);
}
