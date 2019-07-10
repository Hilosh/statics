package com.ag.statics.dao;

import com.ag.statics.model.Person;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PersonMapper {

    Person selectById(Integer id);

}
