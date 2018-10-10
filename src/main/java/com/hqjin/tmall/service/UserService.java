package com.hqjin.tmall.service;

import com.hqjin.tmall.pojo.User;

import java.util.List;

public interface UserService {
    void add(User u);
    void delete(int id);
    User get(int id);
    void update(User u);
    List<User> list();
}
