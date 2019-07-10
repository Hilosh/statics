package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class GenreQuantity implements Serializable {

    private static final long serialVersionUID = -6488417948574701939L;
    private Integer id;
    private String genre;
    private Integer quantity;
}
