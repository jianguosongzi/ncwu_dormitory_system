<%@ page import="java.util.List" %>
<%@ page import="xxx.Dorm" %>
<%@ page import="xxx.Teacher" %>
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
<body>
<h1>搜索结果</h1>
<div class="full-height">
    <%-- Check if dorms list is not empty --%>
    <% if (request.getAttribute("teacher") != null) { %>
    <table>
        <thead>
        <tr>
            <th>工号</th>
            <th>姓名</th>
            <th>密码</th>
            <th>性别</th>
            <th>电话</th>
            <!-- Add other column headers as needed -->
        </tr>
        </thead>
        <tbody>
        <%-- Iterate over the dorms list and display each dorm's information --%>
        <% Teacher teacher= (Teacher)request.getAttribute("teacher"); %>
        <tr>
            <td><%=teacher.getEmployeeID()%></td>
            <td><%=teacher.getName()%></td>
            <td><%=teacher.getPassword()%></td>
            <td><%=teacher.getGender()%></td>
            <td><%=teacher.getPhone()%></td>
            <!-- Add other cell data as needed -->
        </tr>

        </tbody>
    </table>
    <%}else { %>
    <p>No dorms found for search term: ${param.searchTerm}</p>
    <% } %>
</div>
</body>
</html>