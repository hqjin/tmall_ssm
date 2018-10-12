<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<!--根据用户是否登录，决定是否显示退出按钮，或者登录注册按钮，以及购物车中的商品数量-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<nav class="top">
    <a href="${contextPath}">
        <span class="glyphicon glyphicon-home redColor" style="color:#C40000;margin:0px"></span>
        天猫首页
    </a>
    <span>喵，欢迎来天猫</span>
    <c:if test="${!empty user}">
        <a href="loginPage">${user.name}</a>
        <a href="forelogout">退出</a>
    </c:if>
    <c:if test="${empty user}">
        <a href="loginPage">请登录</a>
        <a href="registerPage">免费注册</a>
    </c:if>
    <span class="pull-right">
        <a href="forebought">我的订单</a>
        <a href="forecart">
            <span class="glyphicon glyphicon-shopping-cart redColor"/>
            购物车<strong>${cartTotalItemNumber}</strong>件
        </a>
    </span>
</nav>
