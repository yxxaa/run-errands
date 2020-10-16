package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cjt.commo.bean.MyPage;
import com.cjt.commo.dto.QuestionSearchDto;
import com.cjt.commo.lang.Result;
import com.cjt.entity.Question;
import com.cjt.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
@Api(value = "题库", description = "题库操作 API", protocols = "http")
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;


    @ApiOperation(value = "按种类获取题目")
    @GetMapping(value = "")
    public Result getQuestion(@RequestParam(defaultValue = "cLanguage") String type,
                              @RequestParam(defaultValue = "1") Integer currentPage){
        QuestionSearchDto questionSearchDto = new QuestionSearchDto();
        questionSearchDto.setType(type);
        questionSearchDto.setStart((currentPage-1)*5);
        questionSearchDto.setEnd(currentPage*5);
        List<Question> questionList = questionService.search(questionSearchDto);

        int total = questionService.count(new QueryWrapper<Question>().eq("question_type", type));
        MyPage myPage = new MyPage(questionList,total,5,currentPage);

        return Result.success(myPage);
    }

    @ApiOperation(value = "添加题目")
    @PostMapping(value = "/add")
    public Result addQuestion(@Validated @RequestBody Question question){
        questionService.save(question);
        return Result.success(null);
    }

    @ApiOperation(value = "删除题目")
    @GetMapping(value = "/delete")
    public Result deleteQuestion(@RequestParam Integer id){
        if (id==null){
            return Result.fail("id不能为空");
        }
        questionService.removeById(id);
        return Result.success(null);
    }

    @ApiOperation(value = "更新题目")
    @PostMapping(value = "/update")
    public Result update(@RequestBody Question question){
        if (question.getId()==null){
            return Result.fail("id不能为空");
        }
        questionService.updateById(question);
        return Result.success(null);
    }

    @ApiOperation(value = "搜索题目")
    @GetMapping(value = "/search")
    public Result search(QuestionSearchDto questionSearchDto){
//        int currentPage = questionSearchDto.getCurrentPage();
//
//        questionSearchDto.setStart((currentPage-1)*5);
//        questionSearchDto.setEnd(currentPage*5);


        List<Question> questionList = questionService.search(questionSearchDto);

//        MyPage myPage = new MyPage(questionList,questionService.count(),5,currentPage);

        return Result.success(questionList);
    }



}
