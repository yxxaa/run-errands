package com.cjt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cjt.commo.bean.MyPage;
import com.cjt.commo.dto.QuestionSearchDto;
import com.cjt.entity.Order;
import com.cjt.entity.Question;
import com.cjt.mapper.QuestionMapper;
import com.cjt.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class RunErrandsApplicationTests {
    @Autowired
    OrderService orderService;
    @Resource
    QuestionMapper questionMapper;
    @Test
    void contextLoads() {
    }
    @Test
    public void test1() {
        Page page = new Page(1,5);
        IPage pageData = orderService.page(page,new QueryWrapper<Order>().orderByDesc("id"));
        MyPage myPage = new MyPage(pageData.getRecords(),pageData.getTotal(),pageData.getSize(),pageData.getCurrent());

        ArrayList<String> df = new ArrayList<>();
        df.add("dsfsdf");
        df.add("dsfsdf");

        Date date =new Date();
        System.out.println(date.toString());
        String aa = "";

        IPage pageData2 = orderService.page(page, new QueryWrapper<Order>().eq("id",1)
                .eq("order_name",1)
                .between("commodity_price",100,200));
        System.out.println("test1");

        final List<String> list = new ArrayList<>();
        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(), list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(list,args);
            }
        });
        proxyInstance.add("sdifj");
        System.out.println(list);


        QuestionSearchDto questionSearchDto = new QuestionSearchDto();
        //questionSearchDto.setWrongTimes1(1);
        List<Question> search = questionMapper.search(questionSearchDto);
        List<Question> wrong = questionMapper.getWrong("2");
        System.out.println("Sdf");
    }

}
