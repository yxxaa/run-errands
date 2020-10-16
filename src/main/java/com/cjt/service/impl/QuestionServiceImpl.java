package com.cjt.service.impl;

import com.cjt.commo.dto.QuestionSearchDto;
import com.cjt.entity.Question;
import com.cjt.mapper.QuestionMapper;
import com.cjt.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxx
 * @since 2020-09-26
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Resource
    QuestionMapper questionMapper;

    @Override
    public List<Question> search(QuestionSearchDto questionSearchDto) {

        return questionMapper.search(questionSearchDto);
    }

    @Override
    public List<Question> getWrong(String type) {

        return questionMapper.getWrong(type);
    }
}
