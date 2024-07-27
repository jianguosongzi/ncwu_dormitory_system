<%@ page import="java.util.List" %>
<%@ page import="xxx.Dorm" %>
<%@ page import="xxx.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="cart.css">
    <link rel="stylesheet" href="login.css">
    <title>管理员预约总表</title>
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

    <h2>预约总表</h2>
    <table class="full-page-table">
        <thead>
        <tr>
            <th>预约号</th>
            <th>工号</th>

            <th>宿舍号</th>
            <th>管理员ID</th>
            <th>预约状态</th>



        </tr>
        </thead>
        <tbody>
        <!-- 使用JSP循环填充数据 -->
        <%
            List<Book> cart = (List<Book>)request.getAttribute("books");
            if (cart != null && !cart.isEmpty()) {
                for (Book book : cart) {
        %>
        <tr>
            <td><%=book.getReservationID()%></td>
            <td><%=book.getEmployeeID()%></td>

            <td><%=book.getDormitoryID()%></td>
            <td><%=book.getAdminID()%></td>
            <td><%=book.getOccupancyStatus()%></td>

        </tr>
        <%
            }
        } else {
        %>
        预约信息为空
        <%
            }
        %>

        </tbody>

    </table>






    </body>
</section>
</html>