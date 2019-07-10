package com.ag.statics.dao;

import com.ag.statics.model.CommentQuantity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
public interface CommentQuantityMapper {
    
    CommentQuantity selectQuantity(@Param("movie_id") Integer movie_id);
    
}
