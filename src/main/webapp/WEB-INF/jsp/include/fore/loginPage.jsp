<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/12
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.loginErrorMessageDiv").show();
        </c:if>
        $("form.loginForm").submit(function () {
            if($("#name").val().length==0||$("#password").val().length==0){
                $("span.errorMessage").html("请输入账号密码");
                $("div.loginErrorMessageDiv").show();
                return false;
            }
            return true;
        });
        $("form.loginForm input").keyup(function () {
            $("div.loginErrorMessageDiv").hide();
        });
        var left=window.innerWidth/2+162;
        $("div.loginSmallDiv").css("left",left);
    });
</script>
<div id="loginDiv" style="position: relative">
    <div class="simpleLogo">
        <a href="${contextPath}"><img src="img/site/simpleLogo.png"> </a>
    </div>
    <img id="loginBackgroundImg" class="loginBackgroundImg" src="img/site/loginBackground.png">
    <form method="post" action="forelogin" class="loginForm">
        <div class="loginSmallDiv" id="loginSmallDiv">
            <div class="loginErrorMessageDiv">
                <div class="alert alert-danger">
                    <button type="button" data-dismiss="alert" aria-label="Close" class="close"></button>
                    <span class="errorMessage"></span>
                </div>
            </div>
            <div class="login_acount_text">用户登录</div>
            <div class="loginInput">
                <span class="loginInputIcon">
                    <span class="glyphicon glyphicon-user"></span>
                </span>
                <input id="name" name="name" placeholder="邮箱/会员名/手机" type="text">
            </div>
            <div class="loginInput">
                <span class="loginInputIcon">
                    <span class="glyphicon glyphicon-lock"></span>
                </span>
                <input id="password" name="password"  type="password" placeholder="密码">
            </div>
            <span class="text-danger">不要输入真实账号密码</span><br><br>
            <div>
                <a href="#nowhere" class="notImplementLink">忘记密码</a>
                <a href="registerPage" class="pull-right">免费注册</a>
            </div>
            <div style="margin-top: 20px">
                <button class="btn btn-block redButton" type="submit">登录</button>
            </div>
        </div>
    </form>
</div>
