package com.ag.statics;

import com.ag.statics.dao.CommentQuantityMapper;
import com.ag.statics.dao.MovieMapper;
import com.ag.statics.dao.RedisDao;
import com.ag.statics.model.CountryQuantity;
import com.ag.statics.model.GenreQuantity;
import com.ag.statics.model.Movie;
import com.ag.statics.model.MovieGenre;
import com.ag.statics.service.MovieService;
import com.google.common.collect.Lists;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StaticsApplicationTests {

	@Autowired
	MovieMapper movieMapper;
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private CommentQuantityMapper commentQuantityMapper;
	@Autowired
	private MovieService service;
	@Test
	public void contextLoads() {
//		List<MovieGenre> list = new ArrayList<>();
//		List<GenreQuantity> genreQuantities = movieMapper.selectGenreQuantity();
//		for (GenreQuantity genreQuantity:genreQuantities){
//			List<Movie> movies = movieMapper.selectMovieByGenre(genreQuantity.getGenre());
//			for (Movie movie:movies){
//				MovieGenre movieGenre = new MovieGenre();
//				movieGenre.setMovie_id(movie.getId());
//				movieGenre.setGenre_id(genreQuantity.getId());
//				list.add(movieGenre);
//			}
//		}
//
//		List<List<MovieGenre>> batch = new ArrayList<>();
//		batch = Lists.partition(list,10000);
//		System.out.println(list.size());
//		for (List<MovieGenre> movieGenres:batch)
//		{
//			movieMapper.insertMovieGenre(movieGenres);
//
	}

}
