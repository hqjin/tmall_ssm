<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/13
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<title>模仿天猫官网</title>
<div class="categoryPictureInProductPageDiv">
    <img class="categoryPictureInProductPage" src="img/category/${p.category.id}.jpg">
</div>
<div class="productPageDiv">
    <%@include file="imgAndInfo.jsp"%>
    <%@include file="productReview.jsp"%>
    <%@include file="productDetail.jsp"%>
</div>
