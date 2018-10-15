package com.hqjin.tmall.comparator;

import com.hqjin.tmall.pojo.Product;

import java.util.Comparator;

public class ProductReviewComparator implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getReviewCount()-o1.getReviewCount();
    }
}
