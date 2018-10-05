package com.hqjin.tmall.mapper;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.util.Page;

import java.util.List;
public interface CategoryMapper {
    List<Category> list();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
}
