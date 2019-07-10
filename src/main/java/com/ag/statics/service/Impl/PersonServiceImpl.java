package com.ag.statics.service.Impl;

import com.ag.statics.dao.PersonMapper;
import com.ag.statics.model.Person;
import com.ag.statics.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl  implements PersonService {

    @Autowired
    private PersonMapper personMapper;

    @Cacheable(value = "person",key = "'person'+#id")
    @Override
    public Person selectById(Integer id) {
        return personMapper.selectById(id);
    }
}
