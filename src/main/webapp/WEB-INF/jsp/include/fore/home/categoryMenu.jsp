<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="categoryMenu">
    <c:forEach items="${cs}" var="c" varStatus="st">
        <div class="eachCategory" cid="${c.id}">
            <span class="glyphicon glyphicon-link"> </span>
            <a href="forecategory?cid=${c.id}">${c.name}</a>
        </div>
    </c:forEach>
</div>
