package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.CategoryMapper;
import com.hqjin.tmall.mapper.ProductMapper;
import com.hqjin.tmall.pojo.Product;
import com.hqjin.tmall.pojo.ProductExample;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Override
    public void add(Product product){
        productMapper.insert(product);
    }
    @Override
    public void delete(int id){
        productMapper.deleteByPrimaryKey(id);
    }
    @Override
    public void update(Product product){
        productMapper.updateByPrimaryKeySelective(product);
    }
    public void setCategory(Product product){
        product.setCategory(categoryService.get(product.getCid()));
    }
    @Override
    public Product get(int id){
        Product result=productMapper.selectByPrimaryKey(id);
        setCategory(result);
        return result;
    }
    public void setCategory(List<Product> ps){
        for(Product p:ps){
            setCategory(p);
        }
    }
    @Override
    public List<Product> list(int cid){
        ProductExample example=new ProductExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        List<Product> result=productMapper.selectByExample(example);
        setCategory(result);
        return result;
    }

}
