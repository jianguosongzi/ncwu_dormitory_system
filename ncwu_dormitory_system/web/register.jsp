<!DOCTYPE html>
<html>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="register.css">
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <title>教工注册页面</title>
    <style>
        header nav ul li1 {
            margin-right: 10px;
        }
        .move- {
            transform: translateX(-20px); /* 向左移动1px */
            transform:translateY(2px);
            font-size: 26px;
            color: #009dff;
        }
    </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li class="move-">
                <strong><span>华北水利水电大学</span></strong>
            </li>
            <li><a href="index.jsp">首页</a></li>

            <li><a href="ListDormServlet1">宿舍列表</a></li>
            <li><a href="ListAdminServlet">管理员列表</a></li>
            <li><a href="Sousuo.jsp">查询宿舍</a></li>
            <li><a href="Preson.jsp">个人信息</a></li>
            <li><a href="CartServlet">预约信息</a></li>
            <li><a href="logout">退出登录</a></li>

        </ul>
    </nav>
</header>

<section>
    <h2>注册新用户</h2>
    <form action="ControllerServlet" method="post" class="form-container">
        <div class="form-group">
            <label for="username">工号</label>
            <input type="text" id="username" name="EmployeeID" placeholder="请输入工号"  required>
        </div>
        <div class="form-group">
            <label for="email">姓名</label>
            <input type="text" id="email" name="Name" placeholder="请输入姓名" required>
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" id="Password" name="Password"  placeholder="请输入密码" required>
        </div>
        <div class="form-group">
            <label for="password">确认密码</label>
            <input type="password" id="confirmPassword" name="confirmPassword"  placeholder="请再次输入密码" required>
        </div>
        <div class="form-group">
            <label1 for="receiver">性别</label1>
            <input type="text" id="receiver" name="Gender" placeholder="请输入性别" required>
        </div>
        <div class="form-group">
            <label1 for="phone">电话</label1>
            <input type="text" id="phone" name="Phone" placeholder="请输入电话"required>
        </div>

        <input type="submit" value="提交" style="margin-top: 1px;"> <!-- 添加了内联样式来添加一些顶部间距 -->

    </form>
    <% if (request.getAttribute("error") != null) { %>
    <p style="color: red; text-align: center;"><%= request.getAttribute("error") %></p>
    <% } %>
</section>  </body> </html>