package com.hqjin.tmall.service.impl;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.mapper.CategoryMapper;
import com.hqjin.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> list(){
        return categoryMapper.list();
    }
}
