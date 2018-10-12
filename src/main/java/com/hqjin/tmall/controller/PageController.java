package com.hqjin.tmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class PageController {
    //原来在这里已经指定了registerPage和registerSuccess的跳转位置（通过tomcat的运行日志才想起来）
    @RequestMapping("registerPage")
    public String registerPage(){
        return "fore/register";
    }
    @RequestMapping("registerSuccessPage")
    public String registerSuccessPage(){
        return "fore/registerSuccess";
    }
    @RequestMapping("loginPage")
    public String loginPage(){
        return "fore/login";
    }
    @RequestMapping("forealipay")
    public String alipay(){
        return "fore/alipay";
    }
}
