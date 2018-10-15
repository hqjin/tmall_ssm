package com.hqjin.tmall.interceptor;

import com.hqjin.tmall.pojo.Category;
import com.hqjin.tmall.pojo.OrderItem;
import com.hqjin.tmall.pojo.User;
import com.hqjin.tmall.service.CategoryService;
import com.hqjin.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class OtherInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderItemService orderItemService;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
         /**这里是获取分类集合信息，用于放在搜索栏下面*/
        HttpSession session=request.getSession();
        List<Category> cs=categoryService.list();
        session.setAttribute("cs",cs);
         /**这里是获取当前的contextPath:tmall_ssm,
         用与放在左上角那个变形金刚，点击之后才能够跳转到首页，否则点击之后也仅仅停留在当前页面*/
         String contextPath=session.getServletContext().getContextPath();
         session.setAttribute("contextPath",contextPath);
         /**这里是获取购物车中一共有多少数量*/
         User user=(User) session.getAttribute("user");
         int cartTotalItemNumber=0;
         if(user!=null){
             List<OrderItem> ois=orderItemService.listByUser(user.getId());
             for(OrderItem oi:ois){
                 //?需要保证该orderItem未被生成订单？
                 if(oi.getOid()==null){
                     cartTotalItemNumber+=oi.getNumber();
                 }
             }
         }
         session.setAttribute("cartTotalItemNumber",cartTotalItemNumber);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
