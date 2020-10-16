package com.cjt.service;

import com.cjt.commo.dto.QuestionSearchDto;
import com.cjt.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
public interface QuestionService extends IService<Question> {
    List<Question> search(QuestionSearchDto questionSearchDto);

    List<Question> getWrong(String type);
}
