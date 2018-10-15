package com.hqjin.tmall.service.impl;

import com.hqjin.tmall.mapper.ReviewMapper;
import com.hqjin.tmall.pojo.Review;
import com.hqjin.tmall.pojo.ReviewExample;
import com.hqjin.tmall.pojo.User;
import com.hqjin.tmall.service.ReviewService;
import com.hqjin.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    ReviewMapper reviewMapper;
    @Autowired
    UserService userService;
    @Override
    public void add(Review review) {
        reviewMapper.insert(review);
    }

    @Override
    public void delete(int id) {
        reviewMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Review get(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Review> list(int pid) {
        ReviewExample example=new ReviewExample();
        example.createCriteria().andPidEqualTo(pid);
        example.setOrderByClause("id desc");
        List<Review> rs=reviewMapper.selectByExample(example);
        return rs;
    }

    @Override
    public int getCount(int pid) {
        return list(pid).size();
    }
    public void setUser(Review review){
        int uid=review.getUid();
        User user=userService.get(uid);
        review.setUser(user);
    }
    public void setUser(List<Review> rs){
        for(Review r:rs){
            setUser(r);
        }
    }
}
