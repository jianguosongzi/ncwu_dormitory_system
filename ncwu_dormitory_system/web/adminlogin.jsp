
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<head>

    <title>教工宿舍管理系统 - 登录</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background: url('school/school7.png') no-repeat center center fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
        }

        .container {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: rgba(255, 255, 255, 0.5); /* Optional: 半透明背景 */
        }

        .login-form {
            text-align: center;
            max-width: 300px; /* 可选：限制表单的最大宽度 */
        }

        .login-form label {
            display: block;
            margin-bottom: 5px;
        }

        .login-form input[type="text"],
        .login-form input[type="password"] {
            width: 100%; /* 设置为100%以填充表单容器 */
            padding: 10px;
            margin-bottom: 10px;
        }

        .login-links {
            margin-top: 30px;
        }
        .login-links {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .login-links a {
            display: inline-block;
            text-decoration: none;
            color: white;
            background-color: #007BFF; /* 蓝色背景 */
            border: none;
            border-radius: 4px; /* 圆角 */
            padding: 10px 10px; /* 内边距 */
            margin-right: 10px; /* 右边距，用于分隔按钮 */
            margin-left: 10px;
            transition: background-color 0.3s ease; /* 过渡效果 */
        }

        .login-links a:hover {
            background-color: #00b31e; /* 鼠标悬停时的背景色 */
        }

        .login-links span {
            display: none; /* 隐藏分隔符，因为我们用边距来分隔按钮 */
        }

        .btn-login {
            display: inline-block; /* 让按钮在行内显示 */
            text-decoration: none; /* 移除下划线 */
            color: white; /* 文本颜色 */
            background-color: #007BFF; /* 背景颜色 */
            border: none; /* 无边框 */
            border-radius: 4px; /* 边框圆角 */
            padding: 10px 20px; /* 内边距 */
            cursor: pointer; /* 鼠标悬停时变为小手形状 */
            font-size: 16px; /* 字体大小 */
            transition: background-color 0.3s ease; /* 过渡效果 */
        }

        .btn-login:hover {
            background-color: #00b324; /* 鼠标悬停时的背景颜色 */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-form">
        <h2>华北水利水电大学江淮校区教工宿舍管理系统 - 管理员登录</h2>
        <form method="post" action="AdminLoginServlet">
            <label for="empId">管理员ID:</label>
            <input type="text" id="empId" name="AdminID" required>

            <label for="password">密码:</label>
            <input type="password" id="password" name="Password" required>

            <input type="submit" value="登录" class="btn-login">
<%--        <button type="button" onclick="submitLogin()">提交</button>--%>

            <div class="login-links">
                <a href="login.jsp">教工登录</a>
                <a href="register.jsp">教工注册</a>
            </div>
        </form>
        <%-- 显示错误信息 --%>
        <c:if test="${not empty error}">
            <p style="color: red;" class="error">${error}</p>
        </c:if>
    </div>
</div>
</body>
<footer> <p>友情链接 https://blog.csdn.net/jianguosongzi?spm=1000.2115.3001.5343</p> <a href="#">作者署名 202231615 张嵩培</a>  </footer>
</body>

