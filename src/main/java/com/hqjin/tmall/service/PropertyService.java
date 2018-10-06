package com.hqjin.tmall.service;

import com.hqjin.tmall.pojo.Property;

import java.util.List;

public interface PropertyService {
    List list(int cid);
    void add(Property property);
    void delete(int id);
    void update(Property c);
    Property get(int id);
}
