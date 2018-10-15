<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/15
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<div class="aliPayPageDiv">
    <div class="aliPayPageLogo">
        <img class="pull-left" src="img/site/simpleLogo.png">
        <div style="clear:both"></div>
    </div>
    <div>
        <span class="confirmMoneyText">扫一扫付款</span>
        <span class="confirmMoney">
            <!--param就是从uri中获取的参数-->
            ￥<fmt:formatNumber type="number" value="${param.total}" minFractionDigits="2"></fmt:formatNumber>
        </span>
    </div>
    <div>
        <img class="aliPayImg" src="img/site/alipay2wei.png">
    </div>
    <div>
        <a href="forepayed?oid=${param.oid}&total=${param.total}"><button class="confirmPay">确认付款</button> </a>
    </div>
</div>
