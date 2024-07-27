<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="Manager.css">
    <title>教工管理</title>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            height: 100%;
            /*overflow: hidden; !* 隐藏超出视口的滚动条 *!*/
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
<!-- 表格显示宿舍信息 -->
<%-- 使用JSP的JSTL或EL来替代Java代码以提高可读性和可维护性 --%>
<!-- ... -->

<h2>添加教工</h2>
<form action="AddTeacherServlet" method="post">

    <label for="EmployeeID">工号:</label>
    <input type="text" id="EmployeeID" name="EmployeeID" placeholder="工号">

    <label for="Name">姓名:</label>
    <input type="text" id="Name" name="Name" placeholder="姓名">

    <label for="Password">密码:</label>
    <input type="password" id="Password" name="Password" placeholder="密码">

    <label for="Gender">性别:</label>
    <input type="text" id="Gender" name="Gender" placeholder="性别">

    <label for="Phone">电话:</label>
    <input type="number" id="Phone" name="Phone" placeholder="电话">

    <input type="submit" value="添加">
</form>

<h2>删除教工</h2>
<form action="DeleteTeacher" method="post">

    <label for="DeleteEmployeeID">教工号:</label>
    <input type="text" id="DeleteEmployeeID" name="EmployeeID" placeholder="教工号">
    <input type="submit" value="删除">
</form>

<h2>修改教工</h2>
<form action="UpdateTeacher" method="post">

    <label for="UpdateEmployeeID">教工号:</label>
    <input type="text" id="UpdateEmployeeID" name="EmployeeID" placeholder="教工号">

    <label for="UpdateName">姓名:</label>
    <input type="text" id="UpdateName" name="Name" placeholder="姓名">

    <label for="UpdatePassword">密码:</label>
    <input type="password" id="UpdatePassword" name="Password" placeholder="密码">

    <label for="UpdateGender">性别:</label>
    <input type="text" id="UpdateGender" name="Gender" placeholder="性别">

    <label for="UpdatePhone">电话:</label>
    <input type="number" id="UpdatePhone" name="Phone" placeholder="电话">
    <input type="submit" value="修改">
</form>

<h2>查找教工</h2>
<form action="SelectTeacher" method="post">

    <label for="SearchEmployeeID">教工号:</label>
    <input type="text" id="SearchEmployeeID" name="EmployeeID" placeholder="教工号">
    <input type="submit" value="查找">
</form>
</body>
</html>