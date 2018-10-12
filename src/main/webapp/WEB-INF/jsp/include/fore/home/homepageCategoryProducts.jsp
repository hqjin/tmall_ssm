<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 21:05
  To change this template use File | Settings | File Templates.
--%>
<!--homepageCategoryProducts.jsp 进行了2次遍历
1. 遍历所有的分类，取出每个分类对象
2. 遍历分类对象的products集合，取出每个产品，然后显示该产品的标题，图片，价格等信息-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!--如下代码是用来限制页面总共显示多少个分类的，是测试使用的，正式业务上用不到，请忽略掉-->
<c:if test="${empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="100"/>
</c:if>
<c:if test="${!empty param.categorycount}">
    <c:set var="categorycount" scope="page" value="${param.categorycount}" />
</c:if>
<div class="homepageCategoryProducts">
    <c:forEach items="${cs}" var="c" varStatus="st">
        <c:if test="${st.count<=categorycount}">
            <div class="eachHomepageCategoryProducts">
                <div class="left-makr"></div>
                <span class="categoryTitle">${c.name}</span>
                <br>
                <c:forEach items="${c.products}" var="p" varStatus="st">
                    <c:if test="${st.count<=5}">
                        <div class="productItem">
                            <a href="foreproduct?pid=${p.id}">
                                <img src="img/productSingle_middle/${p.firstProductImage.id}.jpg"></a>
                            <a href="foreproduct?pid=${p.id}" class="productItemDescLink">
                                <span class="productItemDesc">[热销]${fn.substring(p.name,0,20)}</span>
                            </a>
                            <span class="productPrice">
                                <fmt:formatNumber type="number" minFractionDigits="2" value="${p.promotePrice}"/>
                            </span>
                        </div>
                    </c:if>
                </c:forEach>
                <div style="clear: both"/>
            </div>
        </c:if>
    </c:forEach>
    <img class="endpng" id="endpng" src="img/site/end.png"/>
</div>
