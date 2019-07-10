package com.ag.statics.service;

import com.ag.statics.model.CountryQuantity;
import com.ag.statics.model.Movie;
import com.ag.statics.model.MovieVo;

import java.util.List;

public interface MovieService {
    List<Movie> selectTopten();

    /**
     * 根据城市查询电影数目
     */
    Integer selectCountByCountry(String country);

    /**
     * 获取城市-数目列表
     */
    List<CountryQuantity> selectQuantity();

    /**
     * 获取电影
     */
    Movie selectMovieById(Integer id);

    /**
     * 获取相关度前100的电影
     */
    List<MovieVo> getRelationTopTen(Movie movie, int actor_one, int actor_two, int director, int author, int ratingsum,
                                    int rating, int year, int genre, int country);

    /**
     * 通过电影名查询电影
     */
    List<Movie> selectMovieByName(String name);

}
