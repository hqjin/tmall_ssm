package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.OrderItemMapper;
import com.hqjin.tmall.pojo.*;
import com.hqjin.tmall.service.OrderItemService;
import com.hqjin.tmall.service.ProductService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.x509.OIDMap;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{
    @Autowired
    OrderItemMapper orderItemMapper;
    @Autowired
    ProductService productService;
    @Override
    public void add(OrderItem orderItem){
        orderItemMapper.insert(orderItem);
    }
    @Override
    public void delete(int id){
        orderItemMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(OrderItem orderItem){
        orderItemMapper.updateByPrimaryKeySelective(orderItem);
    }
    @Override
    public OrderItem get(int id){
        OrderItem oi=orderItemMapper.selectByPrimaryKey(id);
        setProduct(oi);
        return oi;
    }
    @Override
    public List<OrderItem> list(){
        OrderItemExample example=new OrderItemExample();
        example.setOrderByClause("id desc");
        return orderItemMapper.selectByExample(example);
    }
    /**
     1. 根据订单id查询出其对应的所有订单项
     2. 通过setProduct为所有的订单项设置Product属性
     3. 遍历所有的订单项，然后计算出该订单的总金额和总数量
     4. 最后再把订单项设置在订单的orderItems属性上。*/
    @Override
    public void fill(Order order){
        int oid=order.getId();
        OrderItemExample example=new OrderItemExample();
        example.createCriteria().andOidEqualTo(oid);
        example.setOrderByClause("id desc");
        List<OrderItem> ois=orderItemMapper.selectByExample(example);

        setProduct(ois);
        float total=0;
        int number=0;
        for(OrderItem oi:ois){
            total+=oi.getNumber()*(oi.getProduct().getPromotePrice());
            number+=oi.getNumber();
        }
        order.setTotal(total);
        order.setTotalNumber(number);
        order.setOrderItems(ois);
    }
    @Override
    public void fill(List<Order> orders){
        for(Order order:orders){
            fill(order);
        }
    }

    public void setProduct(List<OrderItem> ois){
        for(OrderItem oi:ois){
            setProduct(oi);
        }
    }
    public void setProduct(OrderItem oi){
        Product p=productService.get(oi.getPid());
        oi.setProduct(p);
    }

    //仅仅是模拟：根据所有用户订单项中的某产品的数量，来确定其销售量
    @Override
    public int getSaleCount(int pid) {
        OrderItemExample example=new OrderItemExample();
        example.createCriteria().andPidEqualTo(pid);
        List<OrderItem> ois=orderItemMapper.selectByExample(example);
        int result=0;
        for(OrderItem oi:ois){
            result+=oi.getNumber();
        }
        return result;
    }

    @Override
    public List<OrderItem> listByUser(int uid) {
        OrderItemExample example=new OrderItemExample();
        example.createCriteria().andUidEqualTo(uid).andOidIsNull();
        example.setOrderByClause("id desc");
        List<OrderItem> ois=orderItemMapper.selectByExample(example);
        //一个orderItem只对应一个产品
        setProduct(ois);
        return ois;
    }
}
