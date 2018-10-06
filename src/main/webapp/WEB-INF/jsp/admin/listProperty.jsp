<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/6
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
    //一直监听id="name"的输入框，submit时不能为空
    $(function () {
        $("#addForm").submit(function () {
            if(checkEmpty("name","属性名称"))
                return true;
            return false;
        });
    });
</script>
<html>
<head>
    <title>属性管理</title>
</head>
<body>
    <div class="workingArea">
        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a></li>
            <li><a href="admin_property_list?cid=${c.id}">${c.name}</a> </li>
            <li class="active">属性管理</li>
        </ol>
        <div class="listDataTableDiv">
            <table class="table table-bordered table-condensed table-striped table-hover">
                <thead>
                    <tr class="success">
                        <th>ID</th>
                        <th>属性名称</th>
                        <th>编辑</th>
                        <th>删除</th>
                    </tr>
                </thead>
                <tbody>
                <%//犯错：var的值直接是“p”，而非表达式“${p}”%>
                    <c:forEach items="${ps}" var="p">
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td><a href="admin_property_edit?id=${p.id}">
                            <span class="glyphicon-edit glyphicon"></span></a> </td>
                        <td><a href="admin_property_delete?id=${p.id}">
                            <span class="glyphicon glyphicon-trash"></span></a> </td>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="pageDiv">
            <%@include file="../include/admin/adminPage.jsp"%>
        </div>
        <div class="panel panel-warning addDiv">
            <div class="panel-heading">新增属性</div>
            <div class="panel-body">
                <form method="post" id="addForm" action="admin_property_add">
                    <table class="addTable">
                        <tr>
                            <td>属性名称</td>
                            <!--？表单递交到PropertyController后，是如何被转化成Property实例的？-->
                            <td><input id="name" name="name" type="text" class="form-control"></td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <!--提交表单时，向Property对象中“偷偷（hidden）”夹带了category的ID值。-->
                                <input type="hidden" name="cid" value="${c.id}">
                                <!--犯错：把type的内容错打成了button，导致提交按钮失效-->
                                <button type="submit" class="btn btn-success">提交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
<%@include file="../include/admin/adminFooter.jsp"%>
</body>
</html>
