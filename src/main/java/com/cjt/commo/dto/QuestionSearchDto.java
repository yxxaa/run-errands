package com.cjt.commo.dto;

import lombok.Data;

/**
 * @Author: yxx
 * @Date: 2020/9/26 9:07
 * @Description: *
 */
@Data
public class QuestionSearchDto {
    private String question;

    private String type;

    private Integer wrongTimes1;

    private Integer wrongTimes2;

    private Integer currentPage = 1;

    private Integer start = 0;

    private Integer end = 5;
}
