<%@ page import="xxx.Dorm" %>
<%@ page import="java.util.List" %>

<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>管理员宿舍列表</title>
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
<%--    <div class="search-icon">--%>
<%--        <a href="Sousuo.jsp">--%>
<%--            <i class="fas fa-search"></i>--%>
<%--        </a>--%>
<%--    </div>--%>


</header>
<body>

<table class="full-page-table">
    <thead>
    <tr>
        <th>宿舍号</th>
        <th>宿舍类型</th>

        <th>容纳人数</th>
        <th>居住状态</th>
        <th>管理员ID</th>
<%--        <th>预约</th>--%>
    </tr>
    </thead>
    <tbody>
    <!-- 使用JSP循环填充数据 -->
    <% for (Dorm dorm : (List<Dorm>)request.getAttribute("dorms")) { %>
    <tr>
        <td><%=dorm.getDormitoryID()%></td>
        <td><%=dorm.getDormitoryType()%></td>

        <td><%=dorm.getCapacity()%></td>
        <td><%=dorm.getOccupancyStatus()%></td>
        <td><%=dorm.getAdminID()%></td>
<%--       <td>--%>
<%--        <td>--%>
<%--            <% if ("空闲".equals(dorm.getOccupancyStatus())) { %>--%>
<%--            <button class="book-button" onclick="location.href='purchase?id=<%=dorm.getDormitoryID()%>'">预约</button>--%>
<%--            <% } %>--%>
<%--        </td>--%>

    </tr>
    <% } %>

    </tbody>
</table>

</body>
</html>