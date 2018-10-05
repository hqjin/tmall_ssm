<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/4
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<!--contentType中，";"后面连一个空格也不能多或少-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
    $(function () {
        $("#addForm").submit(function () {
            if(!checkEmpty("name","分类名称"))
                return false;
            if(!checkEmpty("categoryPic","分类图片"))
                return false;
            return true;
        });
    });
</script>
<html>
<head>
    <title>分类管理</title>
</head>
<body>
    <div class="workingArea">
        <table class="table table-bordered table-hover table-striped table-condensed">
            <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>图片</th>
                    <th>分类名称</th>
                    <th>属性管理</th>
                    <th>产品管理</th>
                    <th>编辑</th>
                    <th>删除</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cs}" var="c">
                    <tr>
                        <td>${c.id}</td>
                        <td><img src="img/category/${c.id}.jpg" height="40px"></td>
                        <td>${c.name}</td>
                        <td><a href="admin_property_list?cid=${c.id}">
                            <span class="glyphicon glyphicon-th-list"> </span> </a> </td>
                        <td><a href="admin_product_list?cid=${c.id}">
                            <span class="glyphicon glyphicon-shopping-cart"></span></a> </td>
                        <td><a href="admin_category_edit?cid=${c.id}">
                            <span class="glyphicon glyphicon-edit"></span> </a> </td>
                        <td><a deleteLink="true" href="admin_category_delete?cid=${c.id}">
                            <span class="glyphicon glyphicon-trash"></span> </a> </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="pageDiv">
        <%//@include file="../include/admin/adminPage.jsp"//暂时先不分页%>
    </div>
    <div class="panel panel-warning addDiv">
        <div class="panel-heading">新增分类 </div>
        <div class="panel-body">
            <form method="post" id="addForm" action="admin_category_add" enctype="multipart/form-data">
                <table class="addTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input id="name" name="name" class="form-control" type="text"></td>
                    </tr>
                    <tr>
                        <td>分类图片</td>
                        <td><input id="categoryPic" name="image" type="file" accept="image/*"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提交</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>
<%@include file="../include/admin/adminFooter.jsp"%>
