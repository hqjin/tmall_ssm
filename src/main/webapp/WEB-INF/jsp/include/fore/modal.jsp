<%--
  Created by IntelliJ IDEA.
  User: xunyi
  Date: 2018/10/10
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<div class="modal" id="loginModal"  tabindex="-1" role="dialog">
    <div class="loginDivInProductPageModalDiv modal-dialog">
        <div class="modal-content">
            <div class="loginDivInProductPage">
                <div class="loginErrorMessageDiv">
                    <div class="alert alert-danger">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
                        <span class="errorMessage"></span>
                    </div>
                </div>
                <div class="login_acount_text">账户登录</div>
                <div class="loginInput">
                    <span class="loginInputIcon">
                        <span class="glyphicon glyphicon-user"></span>
                    </span>
                    <input id="name" name="name" type="text" placeholder="手机/会员名/邮箱">
                </div>
                <div class="loginInput">
                    <span class="loginInputIcon">
                        <span class="glyphicon glyphicon-lock"></span>
                    </span>
                    <input id="password" name="password" type="password" placeholder="密码">
                </div>
                <span class="text-danger">不要输入真实账号密码</span>
                <div>
                    <a href="#nowhere">忘记登录密码</a>
                    <a href="register.jsp" class="pull-right">免费注册</a>
                </div>
                <div style="margin-top: 20px">
                    <button class="btn btn-block redButton loginSubmitButton">登录</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal" tabindex="-1" id="deleteConfirmModal" role="dialog">
    <div class="deleteConfirmModalDiv modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button data-dismiss="modal" class="close" type="button"><span class="arial-hidden">✖</span>
                <span class="sr-only">Close</span> </button>
                <h4 class="modal-title">确认删除?</h4>
            </div>
            <div class="modal-footer">
                <button class="btn btn-default" data-miss="modal" type="button">关闭</button>
                <button type="button" class="btn btn-primary deleteConfirmButton" id="submit">确认</button>
            </div>
        </div>
    </div>
</div>
