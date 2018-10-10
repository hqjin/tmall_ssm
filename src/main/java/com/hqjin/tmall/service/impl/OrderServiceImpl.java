package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.OrderMapper;
import com.hqjin.tmall.pojo.Order;
import com.hqjin.tmall.pojo.OrderExample;
import com.hqjin.tmall.service.OrderService;
import com.hqjin.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    @Override
    public void add(Order order){
        orderMapper.insert(order);
    }
    @Override
    public void delete(int id){
        orderMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(Order order){
        orderMapper.updateByPrimaryKeySelective(order);
    }
    @Override
    public Order get(int id){
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Order> list() {
        OrderExample example=new OrderExample();
        example.setOrderByClause("id desc");
        List<Order> result=orderMapper.selectByExample(example);
        setUser(result);
        return result;
    }
    public void setUser(List<Order> os){
        for(Order o:os){
            o.setUser(userService.get(o.getUid()));
        }
    }
}
