<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/7
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<script>
    $(function () {
        $("#addForm").submit(function () {
            if(!checkEmpty("name","产品名称"))
                return false;
        //    if(!checkEmpty("subTitle","小标题"))
        //        return false;
            if(!checkNumber("originalPrice","原价格"))
                return false;
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
    <title>产品管理</title>
</head>
<body>
    <div class="workingArea">
        <ol class="breadcrumb">
            <li><a href="admin_category_list">所有分类</a> </li>
            <li><a href="admin_product_list?cid=${c.id}">${c.name}</a> </li>
            <li class="active">产品管理</li>
        </ol>
        <div class="listDataTableDiv">
            <table class="table table-hover table-condensed table-striped table-bordered">
                <thead>
                <tr class="success">
                    <th>ID</th>
                    <th>图片</th>
                    <th>产品名称</th>
                    <th>产品小标题</th>
                    <th width="53px">原价格</th>
                    <th width="80px">优惠价格</th>
                    <th width="80px">库存数量</th>
                    <th width="80px">图片管理</th>
                    <th width="80px">设置属性</th>
                    <th width="42px">编辑</th>
                    <th width="42px">删除</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${ps}" var="p">
                    <tr>
                        <td>${p.id}</td>
                        <td>
                            <!--若product实例中，含有“第一张图片”这个属性，则加以显示-->
                            <c:if test="${!empty p.firstProductImage}">
                                <img width="40px" src="img/productSingle/${p.firstProductImage.id}.jpg">
                            </c:if>
                        </td>
                        <td>${p.name}</td>
                        <td>${p.subTitle}</td>
                        <td>${p.originalPrice}</td>
                        <td>${p.promoterPrice}</td>
                        <td>${p.stock}</td>
                        <td><a href="admin_productImage_list?pid=${p.id}">
                            <span class="glyphicon glyphicon-picture"></span>
                        </a> </td>
                        <td><a href="admin_propertyValue_edit?pid=${p.id}">
                            <span class="glyphicon glyphicon-th-list"></span>
                        </a> </td>
                        <td><a href="admin_product_edit?id=${p.id}">
                            <span class="glyphicon glyphicon-edit"></span>
                        </a> </td>
                        <td><a deleteLink="true" href="admin_product_delete?id=${p.id}">
                            <span class="glyphicon glyphicon-trash"></span>
                        </a> </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="pageDiv">
            <%@include file="../include/admin/adminPage.jsp"%>
        </div>
        <div class="panel panel-warning addDiv">
            <div class="panel-heading">新增产品</div>
            <div class="panel-body">
                <form method="post" id="addForm" action="admin_product_add">
                    <table class="addTable">
                        <tr>
                            <td>产品名称</td>
                            <td><input id="name" name="name" type="text" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>产品小标题</td>
                            <td><input id="subTitle" name="subTitle" type="text" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>原价格</td>
                            <td><input id="originalPrice" name="originalPrice"
                                       value="99.98" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>优惠价格</td>
                            <td><input id="promoterPrice" name="promoterPrice"
                                        value="19.98" class="form-control"></td>
                        </tr>
                        <tr>
                            <td>库存</td>
                            <td><input id="stock" name="stock"
                                       value="99" type="text" class="form-control"></td>
                        </tr>
                        <tr class="submitTR">
                            <td colspan="2" align="center">
                                <!--除了提交Product的几个基本属性外，还会偷偷提交cid给product_add函数的product形参-->
                                <input type="hidden" name="cid" value="${c.id}">
                                <button type="submit" class="btn btn-success">提 交</button>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</body>
<%@include file="../include/admin/adminFooter.jsp"%>
</html>
