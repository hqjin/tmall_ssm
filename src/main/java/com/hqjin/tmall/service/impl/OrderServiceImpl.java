package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.OrderMapper;
import com.hqjin.tmall.pojo.Order;
import com.hqjin.tmall.pojo.OrderExample;
import com.hqjin.tmall.pojo.OrderItem;
import com.hqjin.tmall.service.OrderService;
import com.hqjin.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemServiceImpl orderItemService;
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public float add(Order o, List<OrderItem> ois) {
        float totalPrice=0;
        add(o);
        if(false)throw new RuntimeException();
        for(OrderItem oi:ois){
            oi.setOid(o.getId());
            orderItemService.update(oi);
            totalPrice+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return totalPrice;
    }

    @Override
    public List<Order> list(int uid, String excluedeStatus) {
        OrderExample example=new OrderExample();
        example.createCriteria().andUidEqualTo(uid).andStatusNotEqualTo(excluedeStatus);
        example.setOrderByClause("id desc");
        List<Order> os=orderMapper.selectByExample(example);
        return os;
    }
}
