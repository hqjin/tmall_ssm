<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/14
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" value="100" scope="page"></c:set>
</c:if>
<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" value="${param.categorycount}" scope="page"></c:set>
</c:if>
<div class="categoryProducts">
    <c:forEach items="${c.products}" var="p" varStatus="stc">
        <c:if test="${stc.count<=categorycount}">
            <div class="productUnit" price="${p.promotePrice}">
                <div class="productUnitFrame">
                    <a href="foreproduct?pid=${p.id}">
                        <img class="productImage" src="img/productSingle_middle/${p.firstProductImage.id}.jpg">
                    </a>
                    <span class="productPrice">￥<fmt:formatNumber type="number" minFractionDigits="2" value="${p.promotePrice}"></fmt:formatNumber> </span>
                    <a class="productLink" href="foreproduct?pid=${p.id}">${fn:substring(p.name,0 ,50 )}</a>
                    <a href="foreproduct?pid=${p.id}" class="tmallLink">天猫专卖</a>
                    <div class="show1 productInfo">
                        <span class="monthDeal">月成交<span class="monthDealNumber">${p.saleCount}笔</span> </span>
                        <span class="productReview">评价<span class="productReviewNumber">${p.reviewCount}</span> </span>
                        <span class="wangwang">
                            <a class="wangwangLink" href="#nowhere">
                                <img src="img/site/wangwang.png">
                            </a>
                        </span>
                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
    <div style="clear:both"></div>
</div>
