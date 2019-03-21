package com.hqjin.tmall.comparator;

import com.hqjin.tmall.pojo.Product;

import java.util.Comparator;

//把 销量x评价 高的放前面
public class ProductAllComparator implements Comparator<Product> {
    //降序排序，返回o2-o1
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()*o2.getReviewCount()-o1.getSaleCount()*o1.getReviewCount();
    }
}
