package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.CategoryMapper;
import com.hqjin.tmall.mapper.ProductMapper;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.Product;
import com.hqjin.tmall.pojo.ProductExample;
import com.hqjin.tmall.pojo.ProductImage;
import com.hqjin.tmall.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductImageService productImageService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    ReviewService reviewService;
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
        //犯错：忘记在查询处给product实例对象设定first image。
        setFirstProductImage(result);
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
        //犯错：忘记在此处给所有product实例对象设定first image。
        setFirstProductImage(result);
        return result;
    }
    @Override
    public void setFirstProductImage(Product p){
        List<ProductImage> pis=productImageService.list(p.getId(),ProductImageService.type_single);
        if(!pis.isEmpty()){
            ProductImage pi=pis.get(0);
            p.setFirstProductImage(pi);
        }
    }
    public void setFirstProductImage(List<Product> ps){
        for(Product p:ps){
            setFirstProductImage(p);
        }
    }
    //为分类填充产品集合
    @Override
    public void fill(Category category){
        category.setProducts(list(category.getId()));
    }
    //为多个分类填充产品集合

    @Override
    public void fill(List<Category> categories) {
        for(Category c:categories){
            fill(c);
        }
    }
    //为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
    @Override
    public void fillByRow(List<Category> categories) {
        int productNumberEachRow=8;
        for(Category c:categories){
            List<Product> products=c.getProducts();
            List<List<Product>> productsByRow=new ArrayList<>();
            for(int i=0;i<products.size();i+=productNumberEachRow){
                int end=(i+productNumberEachRow)<products.size()?(i+productNumberEachRow):products.size();
                List<Product> tmp=products.subList(i,end);
                productsByRow.add(tmp);
            }
            c.setProductsByRow(productsByRow);
        }
    }

    @Override
    public void setSaleAndReviewNumber(List<Product> ps) {
        for(Product p:ps){
            setSaleAndReviewNumber(p);
        }
    }

    @Override
    public void setSaleAndReviewNumber(Product p) {
        p.setSaleCount(orderItemService.getSaleCount(p.getId()));
        p.setReviewCount(reviewService.getCount(p.getId()));
    }

    @Override
    public List<Product> search(String keyword) {
        ProductExample example=new ProductExample();
        //犯错：少了两个百分号
        example.createCriteria().andNameLike("%"+keyword+"%");
        example.setOrderByClause("id desc");
        List<Product> ps=productMapper.selectByExample(example);
        setSaleAndReviewNumber(ps);
        setFirstProductImage(ps);
        setCategory(ps);
        return ps;
    }
}
