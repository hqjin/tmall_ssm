package com.hqjin.tmall.controller;

import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.User;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.service.ProductService;
import com.hqjin.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.HtmlUtils;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class foreController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    /**
     * 1. 查询所有分类
     2. 为这些分类填充产品集合
     3. 为这些分类填充推荐产品集合
     4. 服务端跳转到home.jsp
     */
    @RequestMapping("forehome")
    public String list(Model model){
        List<Category> cs=categoryService.list();
        productService.fill(cs);
        productService.fillByRow(cs);
        model.addAttribute("cs",cs);
        System.out.println(cs);
        return "fore/home";
    }
    /**1. 通过参数User获取浏览器提交的账号密码
     2. 通过HtmlUtils.htmlEscape(name);把账号里的特殊符号进行转义
     3. 判断用户名是否存在
     3.1 如果已经存在，就服务端跳转到reigster.jsp，并且带上错误提示信息
     3.2 如果不存在，则加入到数据库中，并服务端跳转到registerSuccess.jsp页面*/
    @RequestMapping("foreregister")
    public String register(Model model,User user){
        user.setName(HtmlUtils.htmlEscape(user.getName()));
        if(userService.isExist(user.getName())){
            String m="用户名已存在";
            model.addAttribute("msg",m);
            //这句话的用处是当用户存在，服务端跳转到register.jsp的时候不带上参数user,
            //否则当注册失败的时候，会在原本是“请登录”的超链位置显示刚才注册的名称
            model.addAttribute("user",null);
            return "fore/register";
        }
        else {
            userService.add(user);
            //？不是服务端跳转？？
            return "redirect:registerSuccessPage";
        }
    }
    /**1. 获取账号密码
     2. 把账号通过HtmlUtils.htmlEscape进行转义
     3. 根据账号和密码获取User对象
     3.1 如果对象为空，则服务端跳转回login.jsp，也带上错误信息，并且使用 loginPage.jsp 中的办法显示错误信息
     3.2 如果对象存在，则把对象保存在session中，并客户端跳转到首页"forehome"*/
    @RequestMapping("forelogin")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password,
                        Model model, HttpSession session){
        name=HtmlUtils.htmlEscape(name);
        User u=userService.getUser(name,password);
        if(u==null){
            String msg="账号密码错误";
            model.addAttribute("msg",msg);
            return "fore/login";
        }
        else{
            session.setAttribute("user",u);
            return "redirect:forehome";
        }
    }
}
