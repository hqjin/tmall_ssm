<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/8
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<html>
<head>
    <title>编辑产品属性</title>
</head>
<body>
    <script>
        $(function () {
            //监听input下的pvValue类的键盘输入操作
            $("input.pvValue").keyup(function () {
                var value=$(this).val();
                var page="admin_propertyValue_update";
                var pvid=$(this).attr("pvid");
                var parentSpan=$(this).parent("span");
                parentSpan.css("border","1px solid yellow");
                //犯错：post前边漏了“.”
                //借助JQuery的ajax函数 $.post，把id和值，提交到admin_propertyValue_update
                $.post(
                    //一填入信息，马上post提交表单，page为Request地址；包括PropertValue的value和id两个参数
                    page,
                    {"value":value,"id":pvid},
                    function (result) {
                        //当Controller返回success字串，则进行相应显示
                        if("success"==result)
                            parentSpan("border","1px solid green");
                        else
                            parentSpan("border","1px solid red");
                    }
                );
            });
        });
    </script>
<div class="workingArea">
    <ol class="breadcrumb">
        <li><a href="admin_category_list">所有分类</a></li>
        <li><a href="admin_product_list?cid=${p.cid}">${p.category.name}</a></li>
        <li class="active">${p.name}</li>
        <li class="active">编辑产品属性</li>
    </ol>

    <div class="editPVDiv">
        <c:forEach items="${pvs}" var="pv">
            <div class="eachPV">
                <span class="pvName">${pv.property.name}</span>
                <span class="pvValue"><input class="pvValue" type="text"
                                             pvid="${pv.id}" value="${pv.value}"></span>
            </div>
        </c:forEach>
        <div style="clear:both"></div>
    </div>
</div>
</body>
</html>
