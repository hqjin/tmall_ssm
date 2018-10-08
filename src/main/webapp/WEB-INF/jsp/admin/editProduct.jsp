<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/7
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
    $(function () {
        $("#editForm").submit(function () {
            if(!checkEmpty("name","产品名称"))
                return false;
    //        if(!checkEmpty("subTitle","小标题"))
    //            return false;
            //犯错：originalPrice的拼写错误
            if(!checkNumber("originalPrice","原价格"))
                return false;
            //犯错：promoterPrice拼写错误
            if(!checkNumber("promoterPrice","优惠价格"))
                return false;
            if(!checkInt("stock","库存"))
                return false;
            return true;
        });
    });
</script>
<html>
<head>
    <title>编辑产品</title>
</head>
<body>
    <div class="workingArea">
        <ol class="breadcrumb">
            <li><a href="admin_category_list">产品分类</a> </li>
            <li><a href="admin_product_list?cid=${p.category.id}">${p.category.name}</a> </li>
            <li class="active">${p.name}</li>
            <li class="active>">编辑产品</li>
        </ol>
        <div class="panel panel-warning editDiv">
            <div class="panel-heading">编辑产品</div>
            <div class="panel-body">
                <form method="post" id="editForm" action="admin_product_update">
                    <table class="editTable">
                        <tr>
                            <td>产品名称</td>
                            <td><input id="name" name="name" type="text" value="${p.name}"
                                        class="form-control"></td>
                        </tr>
                        <tr>
                            <td>产品小标题</td>
                            <td><input id="subTitle" name="subTitle" type="text"
                                       value="${p.subTitle}" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>产品原价格</td>
                            <td><input id="originalPrice" name="originalPrice" type="text"
                                       value="${p.originalPrice}" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>产品优惠价格</td>
                            <td><input id="promoterPrice" name="promoterPrice" type="text"
                                        value="${p.promoterPrice}" class="from-control"></td>
                        </tr>
                        <tr>
                            <td>库存</td>
                            <td><input id="stock" name="stock" value="${p.stock}" type="text"
                                        class="form-control"></td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <!--除了提交几个Product的基本属性，在这里还会“偷偷”提交id和cid的值-->
                                <input type="hidden" name="id" value="${p.id}">
                                <input type="hidden" name="cid" value="${p.category.id}">
                                <button type="submit" class="btn btn-success">提 交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
