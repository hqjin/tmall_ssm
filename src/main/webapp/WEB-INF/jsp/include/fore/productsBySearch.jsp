<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/14
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="searchProducts">
    <c:forEach items="${ps}" var="p">
        <div class="productUnit" price="${p.promotePrice}">
            <a href="foreproduct?pid=${p.id}">
                <img class="productImage" src="img/productSingle/${p.firstProductImage.id}.jpg">
            </a>
            <span class="productPrice">￥<fmt:formatNumber type="number" minFractionDigits="2" value="${p.promotePrice}"></fmt:formatNumber> </span>
            <a href="foreproduct?pid=${p.id}" class="productLink">${fn:substring(p.name,0 ,50 )}</a>
            <a href="foreproduct?pid=${p.id}" class="tmallLink">天猫专卖</a>
            <div class="productInfo">
                <span class="monthDeal">月成交<span class="productDealNumber">${p.saleCount}笔</span> </span>
                <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span> </span>
                <span class="wangwang"><img src="img/site/wangwang.png"> </span>
            </div>
        </div>
    </c:forEach>
    <c:if test="${empty ps}">
        <div class="noMatch">没有满足条件的产品</div>
    </c:if>
    <div style="clear:both"></div>
</div>
