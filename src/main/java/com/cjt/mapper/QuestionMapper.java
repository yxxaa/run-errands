package com.cjt.mapper;

import com.cjt.commo.dto.QuestionSearchDto;
import com.cjt.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> search(QuestionSearchDto questionSearchDto);

    List<Question> getWrong(String type);

}
