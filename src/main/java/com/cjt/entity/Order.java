package com.cjt.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxx
 * @since 2020-09-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("m_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer orderId;

    private String orderName;

    private String orderReceivingName;

    private String commodity;

    private String voucher;

    private BigDecimal commodityPrice;

    private BigDecimal expenses;

    private String deliveryPlace;

    private String contacts;

    private String contactsPhone;

    private Integer paymentMethod;

    private LocalDateTime orderTime;

    private LocalDateTime orderReceivingTime;

    private LocalDateTime receivingTime;


}
