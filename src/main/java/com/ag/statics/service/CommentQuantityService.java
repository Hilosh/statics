package com.ag.statics.service;

import com.ag.statics.model.CommentQuantity;

public interface CommentQuantityService {

    CommentQuantity selectQuantity(Integer movie_id);
}
