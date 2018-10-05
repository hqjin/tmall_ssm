package com.hqjin.tmall.controller;

import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("admin_category_list")
    public String list(Model model){
        List<Category> cs=categoryService.list();
        model.addAttribute("cs",cs);
        return "admin/listCategory";
    }
}
