<%@ page import="java.util.List" %>
<%@ page import="xxx.Dorm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>

    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <title>查找</title>
    <style>
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
            overflow: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        .full-height {
            height: calc(100vh - 100px); /* Adjust the value to fit your header/footer needs */
            overflow-y: auto;
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

<h1>搜索结果</h1>

<div class="full-height">
    <%-- Check if dorms list is not empty --%>
    <% if (request.getAttribute("dorms") != null && !((List<?>) request.getAttribute("dorms")).isEmpty()) { %>
    <table>
        <thead>
        <tr>
            <th>宿舍号</th>
            <th>宿舍类型</th>
            <th>容纳人数</th>
            <th>居住状态</th>
            <th>管理员ID</th>
            <th>预约</th>
            <!-- Add other column headers as needed -->
        </tr>
        </thead>
        <tbody>
        <%-- Iterate over the dorms list and display each dorm's information --%>
        <% for (Object dormObj : (List<?>) request.getAttribute("dorms")) {
            Dorm dorm = (Dorm) dormObj; %>
        <tr>
            <td><%=dorm.getDormitoryID()%></td>
            <td><%=dorm.getDormitoryType()%></td>
            <td><%=dorm.getCapacity()%></td>

            <td><%=dorm.getOccupancyStatus()%></td>
            <td><%=dorm.getAdminID()%></td>

            <!-- Add other cell data as needed -->
            <td>
                <% if ("空闲".equals(dorm.getOccupancyStatus())) { %>
                <button class="book-button" onclick="location.href='purchase?id=<%=dorm.getDormitoryID()%>'">预约</button>
                <% } %>
            </td>
        </tr>

        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>没有查找到相关宿舍</p>
    <% } %>


</div>
</body>
</html>