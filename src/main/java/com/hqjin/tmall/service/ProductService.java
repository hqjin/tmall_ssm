package com.hqjin.tmall.service;

import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.Product;

import java.util.List;

public interface ProductService {
    void add(Product product);
    void delete(int id);
    void update(Product product);
    List<Product> list(int cid);
    Product get(int id);
    void setFirstProductImage(Product p);
    void fill(Category category);
    void fill(List<Category> categories);
    void fillByRow(List<Category> categories);
    //增加为产品设置销量和评价数量的方法
    void setSaleAndReviewNumber(Product p);
    void setSaleAndReviewNumber(List<Product> ps);
    List<Product> search(String keyword);
}
