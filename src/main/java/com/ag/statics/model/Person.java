package com.ag.statics.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -6866944495392153631L;
    private Integer id;
    private String name;
    private String img;
    private String sex;
    private String birthday;
    private String birthplace;
    private String summmary;
}
