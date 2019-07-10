package com.ag.statics.controller;

import com.ag.statics.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@CrossOrigin
@Api(tags = "艺人接口")
@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @ApiOperation(value = "通过id查询艺人")
    @ApiImplicitParam(value = "艺人id",name = "id",dataType = "int")
    @RequestMapping(value = "/selectPersonById",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String selectPersonById(HttpServletRequest request)throws IOException{
        Integer id = Integer.parseInt(request.getParameter("id"));
        return JSONObject.fromObject(personService.selectById(id)).toString();
    }
}
