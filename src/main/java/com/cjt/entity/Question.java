package com.cjt.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "题目不能为空")
    private String question;

    @NotBlank(message = "选项A不能为空")
    private String answerA;

    @NotBlank(message = "选项B不能为空")
    private String answerB;

    @NotBlank(message = "选项C不能为空")
    private String answerC;

    @NotBlank(message = "选项D不能为空")
    private String answerD;

    @NotBlank(message = "正确答案不能为空")
    private String rightAnswer;

    @NotBlank(message = "题目类型不能为空")
    private String questionType;

}
