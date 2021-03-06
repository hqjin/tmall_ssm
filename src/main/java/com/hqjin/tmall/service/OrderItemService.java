package com.hqjin.tmall.service;

import com.hqjin.tmall.pojo.Order;
import com.hqjin.tmall.pojo.OrderItem;

import java.util.List;

public interface OrderItemService {
    void add(OrderItem orderItem);
    void delete(int id);
    void update(OrderItem orderItem);
    OrderItem get(int id);
    List<OrderItem> list();
    void fill(Order order);
    void fill(List<Order> orders);
    //增加根据产品获取销售量的方法
    int getSaleCount(int pid);
    List<OrderItem> listByUser(int uid);
}
