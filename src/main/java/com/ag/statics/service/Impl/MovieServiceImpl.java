package com.ag.statics.service.Impl;

import com.ag.statics.dao.MovieMapper;
import com.ag.statics.model.CountryQuantity;
import com.ag.statics.model.Movie;
import com.ag.statics.model.MovieVo;
import com.ag.statics.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Movie> selectTopten() {
        return movieMapper.select();
    }

    @Cacheable(value = "country",key = "'countrycount'+#country")
    @Override
    public Integer selectCountByCountry(String country) {
        return movieMapper.selectCountByCountry(country);
    }

    @Cacheable(value = "countryquan",key = "'countryquantity'")
    @Override
    public List<CountryQuantity> selectQuantity() {
        return movieMapper.selectCountryQuantity();
    }

    @Cacheable(value = "sMI",key = "'movie'+#id")
    @Override
    public Movie selectMovieById(Integer id) {
        return movieMapper.selectMovieById(id);
    }


    @Cacheable(value = "MovieVo",key = "'getRelation'+#movie.getId()+#actor_one+#actor_two+#director+#author+#ratingsum+#rating+#year+#genre+#country")
    @Override
    public List<MovieVo> getRelationTopTen(Movie movie, int actor_one, int actor_two, int director, int author,
                                         int ratingsum, int rating, int year, int genre, int country) {
        List<MovieVo> list = new ArrayList<>();
        List<Movie> movies;
        movies = movieMapper.select();
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.info("InnoDB");
//        int mao = movie.getActor_one();
//        int mat = movie.getActor_two();
//        int mdt = movie.getDirector();
//        int mau = movie.getAuthor();
//        Integer ao;
//        Integer at;
//        Integer dt;
//        Integer au;
        Collections.shuffle(movies);
        for (Movie m:movies){
//            ao = m.getActor_one();
//            at = m.getActor_two();
//            dt = m.getDirector();
//            au = m.getAuthor();
            double c = 0;
            if(actor_one == 1 && movie.getActor_one() != null){
                if ((m.getActor_one() != null) && (movie.getActor_one().intValue() == m.getActor_one().intValue())){
                    c+=2;
                }
                else if ((m.getActor_two() !=null) && (movie.getActor_one().intValue() == m.getActor_two().intValue())){
                    c+=2;
                }
            }
            if (actor_two == 1 && movie.getActor_two() != null){
                if ((m.getActor_one() != null) && (movie.getActor_two().intValue() == m.getActor_one().intValue())){
                    c+=2;
                }
                else if ((m.getActor_two() !=null) && (movie.getActor_two().intValue() == m.getActor_two().intValue())){
                    c+=2;
                }
            }
            if (director == 1 && movie.getDirector() != null){
                if ((m.getDirector() != null) && (movie.getDirector().intValue() == m.getDirector().intValue())){
                    c+=2;
                }
            }
            if (author == 1 && movie.getAuthor() != 0){
                if ((m.getAuthor() != null) && (movie.getAuthor().intValue() == m.getAuthor().intValue())){
                    c+=2;
                }
            }
            if (ratingsum == 1){
                double y = Math.abs(m.getRatingsum()-movie.getRatingsum());
                double x = -(y)/m.getRatingsum();
                c += Math.exp(x);
            }
            if (rating == 1){
                c += Math.exp(-(Math.abs(m.getRating()-movie.getRating()))/m.getRating());
            }
            if (year == 1){
                if(m.getYear() == movie.getYear()){
                    c++;
                }
            }
            if (genre == 1){
                c+=stringCompareUtils(movie.getGenre(), m.getGenre());
            }
            if (country == 1){
                c+=stringCompareUtils(movie.getCountry(), m.getCountry());
            }
            //...
            MovieVo movieVo = new MovieVo();
            movieVo.setId(m.getId());
            movieVo.setName(m.getName());
            movieVo.setImg(m.getImg());
            movieVo.setRelative(c);
            movieVo.setCountry(m.getCountry());
            if (m.getId().intValue() == movie.getId().intValue()){
                list.add(0, movieVo);
            }
            else {
                list.add(movieVo);
            }
        }
        Collections.sort(list, new Comparator<MovieVo>() {
            @Override
            public int compare(MovieVo o1, MovieVo o2) {
                if (o1.getRelative() > o2.getRelative()){
                    return -1;
                }
                if (o1.getRelative() < o2.getRelative()){
                    return 1;
                }
                return 0;
            }
        });
        return new ArrayList<>(list.subList(0,100));
    }

    @Cacheable(value = "movie",key = "'moviename'+#name")
    @Override
    public List<Movie> selectMovieByName(String name) {
        return movieMapper.selectMovieByName(name);
    }


    private double stringCompareUtils(String s1, String s2){
        String[] ss1 = s1.split("/");
        String[] ss2 = s2.split("/");
        Set<String> container = new HashSet<>();
        for (String temp1: ss1){
            container.add(temp1);
        }
        int temp = container.size();
        for (String temp2: ss2){
            container.add(temp2);
        }
        return (ss1.length + ss2.length - container.size())/container.size();
    }

}
