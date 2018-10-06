package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.PropertyMapper;
import com.hqjin.tmall.pojo.Property;
import com.hqjin.tmall.pojo.PropertyExample;
import com.hqjin.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService{
    @Autowired
    PropertyMapper propertyMapper;
    @Override
    public void add(Property property){
        propertyMapper.insert(property);
    }
    @Override
    public void delete(int id){
        propertyMapper.deleteByPrimaryKey(id);
    }
    @Override
    public List list(int cid){
        PropertyExample example=new PropertyExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }
    @Override
    public Property get(int id){
        return propertyMapper.selectByPrimaryKey(id);//为什么不是Selective的？select方法没有Selective的形式。
    }
    @Override
    public void update(Property property){
        propertyMapper.updateByPrimaryKeySelective(property);//为什么是Selective的？
                                                            // Selective:会先判断cid是否已存在，存在时才进行更新-
    }

}
