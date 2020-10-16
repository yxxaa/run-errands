package com.cjt.commo.bean;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yxx
 * @Date: 2020/9/8 11:21
 * @Description: *
 */
@Data
public class MyPage<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
    private List<OrderItem> orders;

    private boolean isSearchCount;

    public MyPage(List<T> records, long total, long size, long current) {
        this.records = records;
        this.total = total;
        this.size = size;
        this.current = current;
        this.orders = new ArrayList();
        this.isSearchCount = true;
    }
}
