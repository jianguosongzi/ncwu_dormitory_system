

<!DOCTYPE html>
<html>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="Person.css">
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <title>个人信息</title>
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
            <li><a href="Adminindex.jsp">首页</a></li>

            <li><a href="ListDormServlet">宿舍列表</a></li>
            <li><a href="dormmanager.jsp">宿舍管理</a></li>
            <li><a href="ListTeacherServlet">教工列表</a></li>
            <li><a href="teachermanager.jsp">教工管理</a></li>
            <li><a href="adminPerson.jsp">个人信息</a></li>
            <li><a href="CartAdminServlet1">预约总表</a></li>
            <li><a href="CartAdminServlet">预约管理</a></li>



            <li><a href="logout">退出登录</a></li>

        </ul>
    </nav>



</header>

<section>
    <h2>个人信息</h2>
    <%
        // 获取session中的用户信息
        String adminID = (String) session.getAttribute("adminID");
        String Username = (String) session.getAttribute("Username");
        String Password = (String) session.getAttribute("Password");
        String Email = (String) session.getAttribute("Email");


        // 获取session中的用户信息（... 同上 ...）

        if (adminID != null) {
            // 用户已登录，显示用户信息
            // 使用HTML的列表和样式来美化输出
    %>
    <div class="user-info">
        <div class="info-item">
            <span class="info-label">管理员ID：</span>
            <span class="info-value"><%=adminID%></span>
        </div>
        <div class="info-item">
            <span class="info-label">姓名：</span>
            <span class="info-value"><%=Username%></span>
        </div>
        <div class="info-item">
            <span class="info-label">密码：</span>
            <span class="info-value"><%=Password%></span>
        </div>
        <div class="info-item">
            <span class="info-label">邮箱：</span>
            <span class="info-value"><%=Email%></span>
        </div>



        <!-- 其他信息项 ... -->
    </div>
    <%
    } else {
        // 用户未登录，显示登录链接
    %>
    <p>请点击 <a href='login.jsp'>登录</a> 登录您的账号.</p>
    <%
        }
    %>
</section>
<footer> <p>友情链接 https://blog.csdn.net/jianguosongzi?spm=1000.2115.3001.5343</p> <a href="#">作者署名 202231615 张嵩培</a>  </footer>
</body>
</html>

