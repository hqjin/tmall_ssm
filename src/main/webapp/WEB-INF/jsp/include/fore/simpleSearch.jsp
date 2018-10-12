<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/11
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div>
    <a href="${contextPath}">
        <img src="img/site/simpleLogo.png" class="simpleLogo" id="simpleLogo">
    </a>
    <form action="foresearch" method="post">
        <div class="simpleSearchDiv pull-right">
            <input name="keyword" type="text" placeholder="原汁机 平衡车">
            <button type="submit" class="searchButton">搜天猫</button>
            <div class="searchBelow">
                <c:forEach items="${cs}" var="c" varStatus="st">
                    <c:if test="${st.count>=8 and st.count<=11}">
                        <span>
                            <a href="forecategory?cid=${c.id}">${c.name}</a>
                            <c:if test="${st.count!=11}">
                                <span>|</span>
                            </c:if>
                        </span>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </form>
    <div style="clear: both"></div>
</div>
