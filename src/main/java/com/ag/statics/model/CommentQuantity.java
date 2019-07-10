package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommentQuantity implements Serializable {

    private static final long serialVersionUID = 6383740289530431154L;
    private Integer id;
    private Integer movie_id;
    private Integer quantity;
}
