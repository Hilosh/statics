package com.ag.statics.dao;

import com.ag.statics.model.CountryQuantity;
import com.ag.statics.model.GenreQuantity;
import com.ag.statics.model.Movie;
import com.ag.statics.model.MovieGenre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
@Mapper
public interface MovieMapper {

    List<Movie> select();

    Integer selectCountByCountry(@Param(value = "country") String country);

    List<String> selectCountries();

    Integer insertCountryQuantity(List<CountryQuantity> countryQuantities);

    List<CountryQuantity> selectCountryQuantity();

    Integer selectCountByGenre(@Param("genre") String genre);

    List<String> selectGenres();

    Integer insertGenreQuantity(List<GenreQuantity> genreQuantities);

    Integer insertMovieGenre(List<MovieGenre> movieGenres);

    List<Movie> selectMovieByGenre(@Param("genre") String genre);

    List<GenreQuantity> selectGenreQuantity();

    Movie selectMovieById(@Param("id") Integer id);

    List<Integer> selectActor(Integer id);

    List<Integer> selectDirector(Integer id);

    List<Integer> selectAuthor(Integer id);

    Integer updateId(@Param("id") Integer id,@Param("actor_one") Integer actor_one,@Param("actor_two") Integer actor_two,
                     @Param("director") Integer director,@Param("author") Integer author);

    List<Movie> selectMovieByName(@Param("name") String name);
}
