<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/11
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        $("div.registerErrorMessageDiv").css("visibility","visible");
        </c:if>
        $(".registerForm").submit(function () {
            if(0==$("#name").val().length){
                $("span.errorMessage").html("请输入用户名");
                //犯错:!!!就因为把“css”写成了“html”,找了进一个小时bug！！！
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#password").val().length){
                $("span.errorMessage").html("请输入密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if(0==$("#repeatpassword").val().length){
                $("span.errorMessage").html("请重新输入密码");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            if($("#repeatpassword").val()!=$("#password").val()){
                $("span.errorMessage").html("重复密码不一致");
                $("div.registerErrorMessageDiv").css("visibility","visible");
                return false;
            }
            //犯错：在此处的“return true”设置在了外面一层的括号里。
            return true;
        });
    });
</script>

<form action="foreregister" class="registerForm" method="post">
    <div class="registerDiv">
        <div class="registerErrorMessageDiv">
            <div class="alert alert-danger" role="alert">
                <button type="button" class="close" aria-label="Close" data-dismiss="alert"></button>
                <span class="errorMessage"></span>
            </div>
        </div>
        <table class="registerTable" align="center">
            <tr>
                <td class="registerTableLeftTD registerTip">设置会员名</td>
                <td></td>
            </tr>
            <tr>
                <td class="registerTableLeftTD">登录名</td>
                <td class="registerTableRightTD"><input id="name" name="name" placeholder="登录名一旦设置成功，无法修改"></td>
            </tr>
            <tr>
                <td class="registerTip registerTableLeftTD">设置登录密码</td>
                <td class="registerTableRightTD">登录时验证，保护账号信息</td>
            </tr>
            <tr>
                <td class="registerTableLeftTD">登录密码</td>
                <td class="registerTableRightTD"><input id="password" name="password"
                                                        type="password" placeholder="设置你的登录密码"></td>
            </tr>
            <tr>
                <td class="registerTableLeftTD">密码确认</td>
                <td class="registerTableRightTD"><input id="repeatpassword" type="password" placeholder="请再次输入你的登陆密码"></td>
            </tr>
            <tr>
                <td colspan="2" class="registerButtonTD">
                    <a href="registerSuccess.jsp"><button>提 交</button></a>
                </td>
            </tr>
        </table>
    </div>

</form>
