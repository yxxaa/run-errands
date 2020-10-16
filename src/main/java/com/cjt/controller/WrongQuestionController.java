package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjt.commo.bean.MyPage;
import com.cjt.commo.lang.Result;
import com.cjt.entity.Question;
import com.cjt.entity.WrongQuestion;
import com.cjt.service.QuestionService;
import com.cjt.service.WrongQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
@Api(value = "错题信息", description = "错题操作 API", protocols = "http")
@RestController
@RequestMapping("/wrong-question")
public class WrongQuestionController {
    @Autowired
    WrongQuestionService wrongQuestionService;
    @Autowired
    QuestionService questionService;

    @ApiOperation(value = "获得全部数据")
    @GetMapping(value = "/get")
    public Result get(){
        List<WrongQuestion> list = wrongQuestionService.list(new QueryWrapper<WrongQuestion>());
        return Result.success(list);
    }
    @ApiOperation(value = "添加错题")
    @PostMapping(value = "/add")
    public Result add(@Validated @RequestBody WrongQuestion wrongQuestion){
        wrongQuestionService.save(wrongQuestion);
        return Result.success(null);
    }

    @ApiOperation(value = "删除错题")
    @GetMapping(value = "/delete")
    public Result delete(@RequestParam Integer id){
        if (id==null){
            return Result.fail("id不能为空");
        }
        wrongQuestionService.removeById(id);
        return Result.success(null);
    }
    @ApiOperation(value = "更新错题")
    @PostMapping(value = "/update")
    public Result update(@RequestBody WrongQuestion wrongQuestion){
        if (wrongQuestion.getId()==null){
            return Result.fail("id不能为空");
        }
        wrongQuestionService.updateById(wrongQuestion);
        return Result.success(null);
    }
    @ApiOperation(value = "获得错题")
    @GetMapping(value = "/get_wrong")
    public Result getWrong(@RequestParam String type){
        List<Question> wrongQuestion = questionService.getWrong(type);
        MyPage myPage = new MyPage(wrongQuestion, wrongQuestion.size(), wrongQuestion.size(), 1);
        return Result.success(myPage);
    }


}
