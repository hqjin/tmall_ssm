package com.hqjin.tmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.Product;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.service.ProductService;
import com.hqjin.tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @RequestMapping("admin_product_add")
    public String add(Model model,Product product){
        product.setCreateDate(new Date());
        productService.add(product);
        return "redirect:admin_product_list?cid="+product.getCid();
    }
    @RequestMapping("admin_product_delete")
    public String delete(int id){
        productService.delete(id);
        return "redirect:admin_product_list?cid="+productService.get(id).getCid();
    }
    @RequestMapping("admin_product_edit")
    //点击了edit按钮后，由id号得出property实例，并设置Category，加入Model中，再在服务端跳转至编辑页面
    public String edit(Model model,int id){
        Product p=productService.get(id);
        p.setCategory(categoryService.get(p.getCid()));
        model.addAttribute("p",p);
        return "admin/editProduct";
    }
    @RequestMapping("admin_product_update")
    //在editProduct中提交表单后，进入该代码。
    public String update(Product p){
        productService.update(p);
        return "redirect:admin_product_list?cid="+p.getCid();
    }
    @RequestMapping("admin_product_list")
    public String list(int cid,Model model,Page page){
        Category c=categoryService.get(cid);
        PageHelper.offsetPage(page.getStart(),page.getCount());
        List<Product> ps=productService.list(cid);
        int total=(int)new PageInfo<>(ps).getTotal();
        page.setTotal(total);
        page.setParam("&cid="+c.getId());

        model.addAttribute("c",c);
        model.addAttribute("ps",ps);
        model.addAttribute("page",page);

        return "admin/listProduct";
    }
}
