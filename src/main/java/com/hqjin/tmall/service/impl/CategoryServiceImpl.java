package com.hqjin.tmall.service.impl;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.mapper.CategoryMapper;
import com.hqjin.tmall.pojo.CategoryExample;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list(){
        CategoryExample example=new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }
    @Override
    public void add(Category category){
        categoryMapper.insert(category);
    }
    @Override
    public void delete(int id){
        categoryMapper.deleteByPrimaryKey(id);
    }
    @Override
    public Category get(int id){
        return categoryMapper.selectByPrimaryKey(id);
    }
    @Override
    public void update(Category category){
        categoryMapper.updateByPrimaryKeySelective(category);//不懂？？
    }
}