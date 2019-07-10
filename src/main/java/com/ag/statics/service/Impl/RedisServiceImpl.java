package com.ag.statics.service.Impl;

import com.ag.statics.dao.RedisDao;
import com.ag.statics.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisDao redisDao = new RedisDao();

    @Override
    public void setKey(String key, String value) {
        redisDao.setKey(key, value);
    }

    @Override
    public Object getValue(String key) {
        return redisDao.getValue(key);
    }

    @Override
    public void removeKey(String key) {
        redisDao.removeValue(key);
    }

}
