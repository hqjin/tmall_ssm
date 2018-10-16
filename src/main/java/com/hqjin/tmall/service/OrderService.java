package com.hqjin.tmall.service;

import com.hqjin.tmall.pojo.Order;
import com.hqjin.tmall.pojo.OrderItem;

import java.util.List;

public interface OrderService {
    String waitPay="waitPay";
    String waitDelivery="waitDelivery";
    String waitConfirm="waitConfirm";
    String waitReview="waitReview";
    String finish="finish";
    String delete="delete";
    void add(Order order);
    void delete(int id);
    void update(Order order);
    Order get(int id);
    List<Order> list();
    float add(Order o, List<OrderItem> ois);
    List<Order> list(int uid,String excluedeStatus);
}
