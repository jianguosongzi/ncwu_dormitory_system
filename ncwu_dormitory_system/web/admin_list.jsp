<%@ page import="xxx.Dorm" %>
<%@ page import="java.util.List" %>
<%@ page import="xxx.Admin" %>

<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员列表</title>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
            /*overflow: hidden; !* 隐藏超出视口的滚动条 *!*/
        }

        .full-page-table {
            width: 100%;
            height: 100vh; /* 视口高度的100% */
            border-collapse: collapse; /* 合并表格边框 */
        }

        .full-page-table th, .full-page-table td {
            border: 1px solid #ddd; /* 添加边框 */
            padding: 8px; /* 添加内边距 */
            text-align: left; /* 文本左对齐 */
        }

        .book-button {
            display: inline-block; /* 让按钮在行内显示 */
            padding: 5px 20px; /* 内边距 */
            color: white; /* 文本颜色 */
            background-color: #4CAF50; /* 背景颜色，例如绿色 */
            border: none; /* 无边框 */
            border-radius: 4px; /* 边框圆角 */
            cursor: pointer; /* 鼠标悬停时变为小手形状 */
            text-align: center; /* 文本居中 */
            text-decoration: none; /* 无下划线 */
            font-size: 15px; /* 字体大小 */
            transition: background-color 0.3s ease; /* 过渡效果 */
        }

        .book-button:hover {
            background-color: #45a049; /* 鼠标悬停时的背景颜色 */
        }
        header nav ul li1 {
            margin-right: 10px;
        }
        .move- {
            transform: translateX(-20px); /* 向左移动1px */
            transform:translateY(2px);
            font-size: 26px;
            color: #009dff;
        }


        /* 其他样式可以根据需要添加 */
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

<table class="full-page-table">
    <thead>
    <tr>
        <th>管理员ID</th>
        <th>姓名</th>

        <th>联系邮箱</th>

    </tr>
    </thead>
    <tbody>
    <!-- 使用JSP循环填充数据 -->
    <% for (Admin admin : (List<Admin>)request.getAttribute("admins")) { %>
    <tr>
        <td><%=admin.getAdminID()%></td>
        <td><%=admin.getUsername()%></td>

        <td><%=admin.getEmail()%></td>


    </tr>
    <% } %>

    </tbody>
</table>

</body>
</html>