<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<!--轮播部分，都是静态的页面，没有用到服务端数据-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div id="carousel-of-product" class="carousel-of-product carousel slide1" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-of-product" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-of-product" data-slide-to="1"></li>
        <li data-target="#carousel-of-product" data-slide-to="2"></li>
        <li data-target="#carousel-of-product" data-slide-to="3"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="img/lunbo/1.jpg" class="carousel carouselImage"/>
        </div>
        <div class="item">
            <img src="img/lunbo/2.jpg" class="carouselImage"/>
        </div>
        <div class="item">
            <img src="img/lunbo/3.jpg" class="carouselImage"/>
        </div>
        <div class="item">
            <img src="img/lunbo/4.jpg" class="carouselImage"/>
        </div>
    </div>
</div>
