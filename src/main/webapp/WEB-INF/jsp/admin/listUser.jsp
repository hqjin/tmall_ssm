<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/9
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
</script>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
    <div class="workingArea">
        <h1 class="label label-info">用户管理</h1>
        <br>
        <br>
        <div class="listDataTableDiv">
            <table class="table table-bordered table-hover table-bordered table-striped table-condensed">
                <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>用户名称</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${us}" var="u">
                    <tr >
                        <td>${u.id}</td>
                        <td>${u.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="pageDiv">
            <%@include file="../include/admin/adminPage.jsp"%>
        </div>
    </div>
</body>
<%@include file="../include/admin/adminFooter.jsp"%>
</html>
