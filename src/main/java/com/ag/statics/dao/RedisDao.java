package com.ag.statics.dao;

import com.ag.statics.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class RedisDao {
    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;
    //添加缓存数据
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = template.opsForValue();
        ops.set(key, value, 10, TimeUnit.MINUTES);// 10分钟后过期
    }

    public void setKey(String key, Movie movie) {
        ValueOperations<String, Movie> ops = template.opsForValue();
        ops.set(key, movie, 10, TimeUnit.MINUTES);
    }

    //查询缓存数据
    public Object getValue(String key) {
        ValueOperations<String, Object> ops = this.template.opsForValue();
        return ops.get(key);
    }

    //删除缓存数据
    public void removeValue(String key) {
        template.delete(key);
    }

}
