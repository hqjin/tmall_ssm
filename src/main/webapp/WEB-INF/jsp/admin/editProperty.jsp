<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/6
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>编辑属性</title>
</head>
<body>
    <div class="workingArea">
        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a></li>
            <li><a href="admin_property_list?cid=${p.category.id}">${p.category.name}</a> </li>
            <li class="active">编辑属性</li>
        </ol>
        <div class="panel panel-warning editDiv">
            <div class="panel-heading">编辑属性</div>
            <div class="panel-body">
                <!--犯错：action的内容的开头又多了一个“/”,使页面跳转至根页面而错误-->
                <form method="post" id="addForm" action="admin_property_update">
                    <table class="editTable">
                        <tr>
                            <td>属性名称</td>
                            <!--value属性定义了默认的输入值-->
                            <td><input id="name" name="name" type="text"
                                       value="${p.name}" class="form-control" </td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <!--向property_update隐式提供了id和cid-->
                                <input type="hidden" name="id" value="${p.id}">
                                <input type="hidden" name="cid" value="${p.category.id}">
                                <button type="submit" class="btn btn-success">提交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
