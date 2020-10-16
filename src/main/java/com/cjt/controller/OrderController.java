package com.cjt.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cjt.commo.dto.OrderDto;
import com.cjt.commo.lang.Result;
import com.cjt.entity.Order;
import com.cjt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yxx
 * @since 2020-09-07
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;


    @GetMapping(value = "orders")
    public Result getOrder(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage,5);
        IPage pageData = orderService.page(page,new QueryWrapper<Order>().orderByDesc("order_time"));

        return Result.success(pageData);
    }
    @GetMapping(value = "search")
    public Result search(OrderDto orderDto) throws ParseException {

        if (StringUtils.isNotEmpty(orderDto.getOrderTime2())){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(orderDto.getOrderTime2());
            Calendar calendar = Calendar.getInstance(); //得到日历
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH,+1);
            orderDto.setOrderTime2(dateFormat.format(calendar.getTime()));
        }

        Page page = new Page(orderDto.getCurrentPage(),5);

        IPage pageData = orderService.page(page, new QueryWrapper<Order>()
                .eq(orderDto.getOrderId()!=null,"id",orderDto.getOrderId())
                .between("commodity_price", orderDto.getCommodityPrice1(), orderDto.getCommodityPrice2())
                .eq(StringUtils.isNotEmpty(orderDto.getContacts()), "contacts", orderDto.getContacts())
                .eq(StringUtils.isNotEmpty(orderDto.getContactsPhone()),"contacts_phone", orderDto.getContactsPhone())
                .between("expenses", orderDto.getExpenses1(), orderDto.getExpenses2())
                .eq(StringUtils.isNotEmpty(orderDto.getOrderName()), "order_name", orderDto.getOrderName())
                .eq(StringUtils.isNotEmpty(orderDto.getOrderReceivingName()), "order_receiving_name", orderDto.getOrderReceivingName())
                .ge(StringUtils.isNotEmpty(orderDto.getOrderTime1()), "order_time",orderDto.getOrderTime1())
                .le(StringUtils.isNotEmpty(orderDto.getOrderTime2()),"order_time",orderDto.getOrderTime2())
                .eq(orderDto.getPaymentMethod()!=null,"payment_method",orderDto.getPaymentMethod())
                .orderByDesc("order_time"));

        return Result.success(pageData);

    }

}
