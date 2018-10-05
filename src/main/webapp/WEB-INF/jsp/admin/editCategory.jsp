<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/5
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>编辑分类</title>
</head>
<body>
    <script>
        $(function () {
            $("#editForm").submit(function () {
                if(!checkEmpty("name","分类名称"))
                    return false;
                return true;
            });
        });
    </script>
    <div class="workingArea">
        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a> </li>
            <li class="active">编辑分类</li>
        </ol>
        <div class="panel panel-warning editDiv">
            <div class="panel-heading">编辑分类</div>
            <div class="panel-body">
                <!--犯错：admin_category_update的前方不能加“/”，这会导致跳转至根目录下的admin_category_update,
                而非tmall_ssm/admin_category_update-->
                <form method="post" id="editForm" enctype="multipart/form-data" action="admin_category_update">
                    <table class="editTable">
                        <tr>
                            <td>分类名称</td>
                            <td><input id="name" name="name" type="text"
                                       class="form-control" value="${c.name}"> </td>
                        </tr>
                        <tr>
                            <td>分类图片</td>
                            <td><input id="categoryPic" name="image" type="file" accept="image/*"> </td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <input type="hidden" name="id" value="${c.id}">
                                <button type="submit" class="btn-success btn">提 交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
