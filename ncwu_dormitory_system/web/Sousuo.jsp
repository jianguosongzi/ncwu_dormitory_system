<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<head>
    <link rel="stylesheet" href="Sousuo.css">
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>搜索框页面</title>
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

<body>

<div class="search-container">
    <h1>搜索</h1>
    <form action="Sousuo" method="get">
        <input type="text" name="searchTerm" placeholder="搜索(宿舍类型)..." required>
        <input type="submit" value="搜索">
    </form>
</div>
<footer> <p>友情链接 https://blog.csdn.net/jianguosongzi?spm=1000.2115.3001.5343</p> <a href="#">作者署名 202231615 张嵩培</a>  </footer>
</body>

</html>