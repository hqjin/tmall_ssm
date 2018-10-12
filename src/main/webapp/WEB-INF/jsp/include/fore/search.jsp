<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<!--从request的属性"cs" 中获取到分类集合，并取第5个到第8个，一共4个来显示-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<a href="${contextPage}">
    <img src="img/site/logo.gif" class="logo" id="logo">
</a>
<form method="post" action="foresearch">
    <div class="searchDiv">
        <input name="keyword" type="text" placeholder="时尚男鞋 太阳镜">
        <button type="submit" class="searchButton">搜索</button>
        <div class="searchBelow">
            <c:forEach items="${cs}" var="c" varStatus="st">
                <c:if test="${st.count}>=5 and ${st.count}<=8">
                    <span>
                        <a href="forecategory?cid=${c.id}">
                            ${c.name}
                        </a>
                        <c:if test="${st.count}!=8">
                            <span>|</span>
                        </c:if>
                    </span>
                </c:if>
            </c:forEach>
        </div>
    </div>
</form>
