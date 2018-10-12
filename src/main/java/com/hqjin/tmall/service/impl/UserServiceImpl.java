package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.UserMapper;
import com.hqjin.tmall.pojo.User;
import com.hqjin.tmall.pojo.UserExample;
import com.hqjin.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public void add(User u){
        userMapper.insert(u);
    }
    @Override
    public void delete(int id){
        userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public User get(int id){
        return userMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<User> list(){
        UserExample example=new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }
    @Override
    public void update(User u){
        userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public boolean isExist(String name) {
        UserExample example=new UserExample();
        example.createCriteria().andNameEqualTo(name);
        List<User> us=userMapper.selectByExample(example);
        if(us.isEmpty())return false;
        return true;
    }

    @Override
    public User getUser(String name, String password) {
        UserExample example=new UserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<User> us=userMapper.selectByExample(example);
        if(us.isEmpty())return null;
        else return us.get(0);
    }
}
