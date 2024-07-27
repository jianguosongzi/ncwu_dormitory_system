<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="login.css">
    <link rel="stylesheet" href="Manager.css">
    <title>宿舍管理</title>
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

<h2>添加宿舍</h2>

<form action="addDormitory" method="post">

    <label for="DormitoryID">宿舍号:</label>
    <input type="text" id="DormitoryID" name="DormitoryID" placeholder="宿舍号">

    <label for="DormitoryType">宿舍类型:</label>
    <select id="DormitoryType" name="DormitoryType">
        <option value="单人间">单人间</option>
        <option value="双人间">双人间</option>
        <option value="多人间">多人间</option>
    </select>

    <label for="Capacity">容纳人数:</label>
    <input type="number" id="Capacity" name="Capacity" placeholder="容纳人数">

    <label for="OccupancyStatus">居住状态:</label>
    <select id="OccupancyStatus" name="OccupancyStatus">
        <option value="已预约">已预约</option>
        <option value="空闲">空闲</option>
        <option value="已入住">已入住</option>
    </select>

    <label for="AdminID">管理员ID:</label>
    <input type="number" id="AdminID" name="AdminID" placeholder="管理员ID">

    <input type="submit" value="添加">
</form>

<h2>删除宿舍</h2>
<form action="DeleteDormitory" method="post">

    <label for="DeleteDormitoryID">宿舍号:</label>
    <input type="text" id="DeleteDormitoryID" name="DormitoryID" placeholder="宿舍号">
    <input type="submit" value="删除">
</form>

<h2>修改宿舍</h2>
<form action="UpdateDormitory" method="post">

    <label for="UpdateDormitoryID">宿舍号:</label>
    <input type="text" id="UpdateDormitoryID" name="DormitoryID" placeholder="宿舍号">

    <label for="UpdateDormitoryType">宿舍类型:</label>
    <select id="UpdateDormitoryType" name="DormitoryType">
        <option value="单人间">单人间</option>
        <option value="双人间">双人间</option>
        <option value="多人间">多人间</option>
    </select>

    <label for="UpdateCapacity">容纳人数:</label>
    <input type="number" id="UpdateCapacity" name="Capacity" placeholder="容纳人数">

    <label for="UpdateOccupancyStatus">居住状态:</label>
    <select id="UpdateOccupancyStatus" name="OccupancyStatus">
        <option value="已预约">已预约</option>
        <option value="空闲">空闲</option>
        <option value="已入住">已入住</option>
    </select>

    <label for="UpdateAdminID">管理员ID:</label>
    <input type="number" id="UpdateAdminID" name="AdminID" placeholder="管理员ID">

    <input type="submit" value="修改">
</form>

<h2>查找宿舍</h2>
<form action="SelectDormitory" method="post">

    <label for="SearchDormitoryID">宿舍号:</label>
    <input type="text" id="SearchDormitoryID" name="DormitoryID" placeholder="宿舍号">
    <input type="submit" value="查找">
</form>
</body>
</html>