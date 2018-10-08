package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.PropertyMapper;
import com.hqjin.tmall.mapper.PropertyValueMapper;
import com.hqjin.tmall.pojo.*;
import com.hqjin.tmall.service.ProductService;
import com.hqjin.tmall.service.PropertyService;
import com.hqjin.tmall.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.LightweightFrame;

import java.util.*;

@Service
public class PropertyValueServiceImpl implements PropertyValueService{
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    PropertyService propertyService;
    @Autowired
    ProductService productService;
    @Override
    public PropertyValue get(int ptid,int pid){
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs=propertyValueMapper.selectByExample(example);
        if(pvs.isEmpty())return  null;
        else return pvs.get(0);
    }
    @Override
    public List<PropertyValue> list(int pid){
        PropertyValueExample example=new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> pvs= propertyValueMapper.selectByExample(example);
        //给propertyValue设定Property属性值
        for(PropertyValue pv:pvs){
            pv.setProperty(propertyService.get(pv.getPtid()));
        }
        return pvs;
    }
    //没有add方法，只能通过init来自动增加。
    @Override
    public void init(Product p){
        List<Property> pts=propertyService.list(p.getCid());
        for(Property pt:pts){
            PropertyValue pv=get(pt.getId(),p.getId());
            if(pv==null){
                pv=new PropertyValue();
                pv.setPid(p.getId());
                pv.setPtid(pt.getId());
                //?为何不在init时设置Property属性,而是在list中进行?
                pv.setProperty(pt);
                propertyValueMapper.insert(pv);
            }
        }
    }
    @Override
    public void update(PropertyValue pv){
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }
}
