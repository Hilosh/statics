package com.ag.statics.service;

public interface RedisService {
    void setKey(String key,String value);

    Object getValue(String key);

    void removeKey(String key);
}
