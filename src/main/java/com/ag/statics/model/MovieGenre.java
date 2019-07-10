package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieGenre implements Serializable {
    private static final long serialVersionUID = 6174276779095147018L;
    private Integer id;
    private Integer movie_id;
    private Integer genre_id;
}
