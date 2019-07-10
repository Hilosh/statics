package com.ag.statics.controller;

import com.ag.statics.model.CommentQuantity;
import com.ag.statics.service.CommentQuantityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RestController
@RequestMapping("/commentquantity")
@CrossOrigin
@Api(tags = "评论接口")
public class CommentQuantityController {
    @Autowired
    private CommentQuantityService commentQuantityService;

    @RequestMapping(value = "/selectQuantity",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "查询电影评价数")
    @ApiImplicitParam(name = "movie_id", value = "电影id", dataType = "int")
    public String selectQuantity(HttpServletRequest request, HttpServletResponse response)throws IOException{
        request.setCharacterEncoding("UTF-8");
        Integer movie_id = Integer.parseInt(request.getParameter("movie_id"));
        JSONObject jsonObject = JSONObject.fromObject(commentQuantityService.selectQuantity(movie_id));
        return jsonObject.toString();
    }
}
