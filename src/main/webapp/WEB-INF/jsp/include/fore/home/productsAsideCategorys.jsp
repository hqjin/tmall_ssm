<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<!--productsAsideCategorys.jsp 进行了三层遍历
1. 先取出每个分类
2. 然后取出每个分类的productsByRow集合
3. 根据productsByRow集合，取出每个产品，把产品的subTitle信息里的第一个单词取出来显示。-->
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<!--这个是用于随机挑选一个产品作为推荐产品，来进行高亮显示。
严格的说，应该是后台设置那个产品是推荐产品，不过这里偷懒了，
直接在前端按照20%的概率，随机挑选了一个产品-->
<script>
    $(function () {
        $("div.productsAsideCategorys div.row a").each(function () {
            var v=Math.round(Math.random()*6);
            if(v==1)
                $(this).css("color","#87CEFA");
        });
    });
</script>
<c:forEach items="${cs}" var="c">
    <div cid="${c.id}" class="productsAsideCategorys">
        <c:forEach items="${c.productsByRow}" var="ps">
            <div class="show1 row">
                <!--犯错：漏了一个对ps的遍历循环-->
                <!--由于数据库数据有删减，产品列出来后，一行没有超过八个的（即不用换行）-->
                <c:forEach items="${ps}" var="p">
                    <c:if test="${!empty p.subTitle}">
                        <a href="foreproduct?pid=${p.id}">
                            <c:forEach items="${fn:split(p.subTitle,' ')}" var="title" varStatus="st">
                                <c:if test="${st.index==0}">
                                    ${title}
                                </c:if>
                            </c:forEach>
                        </a>
                    </c:if>
                </c:forEach>
                <!--犯错：分行时漏了这个分行的样式-->
                <div class="seperator"></div>
            </div>
        </c:forEach>
    </div>
</c:forEach>
