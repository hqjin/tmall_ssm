package com.hqjin.tmall.comparator;

import com.hqjin.tmall.pojo.Product;

import java.util.Comparator;

public class ProductSaleCountComparator implements Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getSaleCount()-o1.getSaleCount();
    }
}
