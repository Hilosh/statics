package com.ag.statics.controller;

import ch.qos.logback.core.joran.conditional.ThenOrElseActionBase;
import com.ag.statics.dao.MovieMapper;
import com.ag.statics.model.Movie;
import com.ag.statics.model.MovieVo;
import com.ag.statics.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin
@Api(tags = "电影")
@Slf4j
public class MovieController {

    @Autowired
    public MovieService movieService;

    Logger logger = LoggerFactory.getLogger(getClass());
    @ApiOperation(value = "查询所有电影")
    @RequestMapping(value = "/selectTopten",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectTopten(HttpServletRequest request,HttpServletResponse response){
        List<Movie> movies = movieService.selectTopten();
        JSONArray jsonArray = JSONArray.fromObject(movies);
        return jsonArray.toString();
    }
    @ApiOperation(value = "查询城市及对应电影数目")
    @RequestMapping(value = "/selectquantity",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selecctquantity(HttpServletRequest request,HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        return JSONArray.fromObject(movieService.selectQuantity()).toString();
    }

    @ApiOperation(value = "查询电影，通过id")
    @ApiImplicitParam(value = "电影id",name = "id",dataType = "int")
    @RequestMapping(value = "selectMovieById",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectMovieById(HttpServletRequest request,HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        logger.info("查询电影，通过id");
        Movie movie = movieService.selectMovieById(Integer.parseInt(request.getParameter("id")));
        return JSONObject.fromObject(movie).toString();
    }

    @ApiOperation(value = "查询前100相似电影")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "电影id", name = "movie_id", dataType = "int"),
            @ApiImplicitParam(value = "演员一", name = "actor_one", dataType = "int"),
            @ApiImplicitParam(value = "演员二", name = "actor_two", dataType = "int"),
            @ApiImplicitParam(value = "导演", name = "director", dataType = "int"),
            @ApiImplicitParam(value = "作者", name = "author", dataType = "int"),
            @ApiImplicitParam(value = "热度", name = "ratingsum", dataType = "int"),
            @ApiImplicitParam(value = "评分", name = "rating", dataType = "int"),
            @ApiImplicitParam(value = "年份", name = "year", dataType = "int"),
            @ApiImplicitParam(value = "类型", name = "genre", dataType = "int"),
            @ApiImplicitParam(value = "城市", name = "country", dataType = "int")
    })

    @RequestMapping(value = "/selectMovieTop", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String selectMovieTop(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("movie_id"));
        Movie movie = movieService.selectMovieById(id);
        if (movie == null){
            return JSONObject.fromObject(movie).toString();
        };
        int actor_one = Integer.parseInt(request.getParameter("actor_one"));
        int actor_two = Integer.parseInt(request.getParameter("actor_two"));
        int director= Integer.parseInt(request.getParameter("director"));
        int author = Integer.parseInt(request.getParameter("author"));
        int ratingsum = Integer.parseInt(request.getParameter("ratingsum"));
        int rating = Integer.parseInt(request.getParameter("rating"));
        int year = Integer.parseInt(request.getParameter("year"));
        int genre = Integer.parseInt(request.getParameter("genre"));
        int country = Integer.parseInt(request.getParameter("country"));
        List<MovieVo> movieVos = movieService.getRelationTopTen(movie, actor_one, actor_two, director, author, ratingsum, rating, year, genre, country);
        return JSONArray.fromObject(movieVos).toString();
    }

    @ApiOperation(value = "根据电影名查询电影，模糊查询")
    @ApiImplicitParam(value = "电影名", name = "name", dataType = "stirng")
    @RequestMapping(value = "/selectMovieByName", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectMovieByName(HttpServletRequest request,HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        return JSONArray.fromObject(movieService.selectMovieByName(name)).toString();
    }

}
