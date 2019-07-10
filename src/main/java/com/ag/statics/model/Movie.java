package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Movie implements Serializable {
    private static final long serialVersionUID = 5524870828148082459L;
    private Integer id;
    private String name;
    private Integer year;
    private float rating;
    private Integer ratingsum;
    private String img;
    private String tags;
    private String summary;
    private String genre;
    private String country;
    private Integer actor_one;
    private Integer actor_two;
    private Integer director;
    private Integer author;
}
