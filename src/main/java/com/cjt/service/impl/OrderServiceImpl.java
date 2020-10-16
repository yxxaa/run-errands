package com.cjt.service.impl;

import com.cjt.entity.Order;
import com.cjt.mapper.OrderMapper;
import com.cjt.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yxx
 * @since 2020-09-07
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
