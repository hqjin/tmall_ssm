<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/15
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="buyPageDiv">
    <form action="forecreateOrder" method="post">
        <div class="buyFlow">
            <img class="pull-left" src="img/site/simpleLogo.png">
            <img class="pull-right" src="img/site/buyflow.png">
            <div style="clear:both"></div>
        </div>
        <div class="address">
            <div class="address">输入收货地址</div>
            <div>
                <table class="addressTable">
                    <tr>
                        <td class="firstColumn">详细地址<span class="redStar">*</span> </td>
                        <td><textarea name="address" placeholder="建议您详细填写收货地址如街道门牌号"></textarea> </td>
                    </tr>
                    <tr>
                        <td>邮政编码</td>
                        <td><input name="post" type="text" placeholder="若不知道，请填写000000"></td>
                    </tr>
                    <tr>
                        <td>收货人姓名<span class="redStar">*</span> </td>
                        <td><input name="receiver" type="text" placeholder="字符不超过25个字符"></td>
                    </tr>
                    <tr>
                        <td>手机号码</td>
                        <td><input name="mobile" type="text" placeholder="请输入11位手机号"></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="productList">
            <div class="productListTip">确认订单信息</div>
            <table class="productListTable">
                <thead>
                <tr>
                    <th colspan="2" class="productListTableFirstColumn">
                        <img class="tmallbuy" src="img/site/tmallbuy.png">
                        <a href="#nowhere" class="marketLink">店铺：天猫店铺</a>
                        <a href="#nowhere" class="wangwangLink"><span class="wangwangGif"></span> </a>
                    </th>
                    <th>单价</th>
                    <th>数量</th>
                    <th>小计</th>
                    <th>配送方式</th>
                </tr>
                <tr class="rowborder">
                    <td colspan="2"></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                </thead>
                <tbody class="productListTableTbody">
                    <c:forEach items="${ois}" var="oi" varStatus="st">
                        <tr class="orderItemTR">
                            <td class="orderItemFirstTD"><img class="orderItemImg"
                            src="img/productSingle_middle/${oi.product.firstProductImage.id}.jpg"></td>
                            <td class="orderItemProductInfo">
                                <a href="foreproduct?pid=${oi.product.id}" class="orderItemProductLink">
                                    ${oi.product.name}
                                </a>
                                <img src="img/site/creditcard.png" title="支持信用卡支付">
                                <img src="img/site/7day.png" title="支持七天无理由">
                                <img src="img/site/promise.png" title="承诺如实描述">
                            </td>
                            <td>
                                <span class="orderItemProductPrice">￥
                                    <fmt:formatNumber type="number" value="${oi.product.promotePrice}" var="2">
                                    </fmt:formatNumber> </span>
                            </td>
                            <td>
                                <span class="orderItemProductNumber">${oi.number}</span>
                            </td>
                            <td>
                                <span class="orderItemUnitSum">￥
                                    <fmt:formatNumber minFractionDigits="2" value="${oi.number*oi.product.promotePrice}" type="number">
                                    </fmt:formatNumber> </span>
                            </td>
                            <c:if test="${st.count==1}">
                                <td rowspan="5" class="orderItemLastTD">
                                    <label class="orderItemDeliveryLabel">
                                        <input type="radio" checked="checked" value="">
                                        普通配送
                                    </label>
                                    <select class="orderItemDeliverySelect" class="form-control">
                                        <option>快递 免邮</option>
                                    </select>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="orderItemSumDiv">
                <div class="pull-left">
                    <span class="leaveMessageText">给卖家留言：</span>
                    <span>
                        <img class="leaveMessageImg" src="img/site/leaveMessage.png">
                    </span>
                    <span class="leaveMessageTextareaSpan">
                        <textarea name="userMessage" class="leaveMessageTextarea"></textarea>
                        <div>
                            <span>还可以输入200个字符</span>
                        </div>
                    </span>
                </div>
                <span class="pull-right">店铺合计：￥
                    <!--当点击的是“立即购买”时，传进来的oiid只有一个-->
                    <fmt:formatNumber value="${total}" minFractionDigits="2" type="number">
                </fmt:formatNumber> </span>
            </div>
        </div>
        <div class="orderItemTotalSumDiv">
            <div class="pull-right">
                <span>实付款：</span>
                <span class="orderItemTotalSumSpan">￥
                    <fmt:formatNumber type="number" minFractionDigits="2" value="${total}">
                </fmt:formatNumber> </span>
            </div>
        </div>
        <div class="submitOrderDiv">
            <button type="submit" class="submitOrderButton">提交订单</button>
        </div>
    </form>
</div>
