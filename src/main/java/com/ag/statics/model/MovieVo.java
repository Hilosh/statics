package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class MovieVo implements Serializable {

    private static final long serialVersionUID = 6227488787649839810L;
    private Integer id;
    private String name;
    private String img;
    private String country;
    private double relative;
}
