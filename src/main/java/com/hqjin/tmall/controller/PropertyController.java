package com.hqjin.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.Property;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.service.PropertyService;
import com.hqjin.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class PropertyController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;
    @RequestMapping("admin_property_add")
    //？从listProperty传递而来的表单，仅有name=“name”，它是如何转化成Property形参的？？
    public String add(Model model, Property property){
        propertyService.add(property);
        //add之后，客户端url带上cid参数跳转到property_list
        return "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_delete")
    //id参数附带在url中
    public String delete(int id){
        Property property=propertyService.get(id);
        propertyService.delete(id);
        return "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_update")
    public String update(Property property){
        propertyService.update(property);
        return "redirect:admin_property_list?cid="+property.getCid();
    }
    @RequestMapping("admin_property_edit")
    //点击edit按钮，把id号处理成property实例后，再切换到edit页面。
    public String edit(Model model,int id){
        Property property=propertyService.get(id);
        //为什么这里还要设定Propert的Category？在property_add的步骤中，
        // property中只夹带了cid和name，在此处又补充了cid对用的category
        property.setCategory(categoryService.get(property.getCid()));
        model.addAttribute("p",property);
        //没有redirect，是指服务端跳转，客户端的url不改变
        return "admin/editProperty";
    }
    @RequestMapping("admin_property_list")
    public String list(int cid,Model model,Page page){
        Category c=categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Property> ps=propertyService.list(cid);
        int total=(int) new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());

        model.addAttribute("c",c);
        model.addAttribute("ps",ps);
        model.addAttribute("page",page);
        return "admin/listProperty";
    }
}
