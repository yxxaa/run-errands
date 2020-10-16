package com.cjt.commo.bean;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author: yxx
 * @Date: 2020/9/26 9:29
 * @Description: *
 */
@Data
public class QuestionSearchResult {
    private Integer id;

    private String question;

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String rightAnswer;

    private String questionType;

    private Integer wrongTime;

}
