package com.ag.statics.service.Impl;

import com.ag.statics.dao.CommentQuantityMapper;
import com.ag.statics.model.CommentQuantity;
import com.ag.statics.service.CommentQuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentQuantityServiceImpl implements CommentQuantityService {

    @Autowired
    private CommentQuantityMapper commentQuantityMapper;

    @Cacheable(value = "commentquan", key = "'comment'+#movie_id")
    @Override
    public CommentQuantity selectQuantity(Integer movie_id) {
        return commentQuantityMapper.selectQuantity(movie_id);
    }
}
