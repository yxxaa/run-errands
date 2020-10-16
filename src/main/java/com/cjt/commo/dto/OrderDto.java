package com.cjt.commo.dto;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @Author: yxx
 * @Date: 2020/9/8 15:03
 * @Description: *
 */
@Data
public class OrderDto {
    private Integer orderId;
    private Double commodityPrice1 = 0D;
    private Double commodityPrice2 = 10000D;
    private String contacts;
    private String contactsPhone;
    private Double expenses1 = 0D;
    private Double expenses2 = 10000D;
    private String orderName;
    private String orderReceivingName;
    private String orderTime1;
    private String orderTime2;
    private Integer paymentMethod;
    private Integer currentPage=1;

}
