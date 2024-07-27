

<!DOCTYPE html>
<html>
<%@page contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<head>
    <link rel="stylesheet" href="styles.css">
    <link rel="stylesheet" href="autoMatic.css">
    <link rel="stylesheet" href="login.css">
    <meta charset="UTF-8">
    <title>首页</title>
    <style>
        .book-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin: 0 -10px; /* 抵消内边距 */
        }
        .book-item {
            flex: 0 0 calc(50% - 20px); /* 每项占据50%宽度减去间隔 */
            margin: 10px;
            box-sizing: border-box; /* 包含内边距和边框 */
        }
        .book-image {
            width: 100%;
            height: auto;
        }
        .book-description {
            padding: 10px;
            background-color: #009dff;
        }
        section {
            padding: 20px;
            background-color: #97b9ec;
            margin-top: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #208fdc; /* 如果背景图片不能完全覆盖整个页面，这个颜色将作为背景图片的底色 */

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

<section>
    <h2>华北水利水电大学江淮校区教工宿舍管理系统</h2>
    <body>
    <div class="banner-container">
        <!-- 创建图片存储容器 -->
        <div class="banner-img-container">
            <img src="school/school5.jpg" alt="book1">
            <img src="school/school3.png" alt="book2">
            <img src="school/school4.png" alt="book3">
            <img src="school/school2.png" alt="book4">
            <img src="school/school6.png" alt="book5">
        </div>
    </div>
    <h2>宿舍类型</h2>
    <div class="book-container">


        <div class="book-item">
            <img src="dorm/单人宿舍.png" alt="单人间" class="book-image">
            <div class="book-description">
                <p><strong style="font-size: 18px;"><span style="color:#07dc0b;">单人宿舍(单人间)</span>是一个专为个人设计的居住空间，拥有舒适的床铺、书桌及储物设施。宿舍内部布局合理，空间利用高效，确保居住者拥有足够的私人空间。床铺宽敞舒适，保证良好的睡眠质量；书桌则提供了学习和工作的便利；储物柜则能整齐地收纳个人物品。整体设计简约大方，营造了一个温馨舒适的居住环境。</strong></p>
            </div>
        </div>


        <div class="book-item">
            <img src="dorm/双人宿舍.png" alt="双人间" class="book-image">
            <div class="book-description">
                <p><strong style="font-size: 18px;"><span style="color: #07dc0b;">双人宿舍(双人间)</span>是专为两位居住者设计的共享空间，具备两张舒适的床铺、共用书桌及储物区域。宿舍内布局紧凑，既保证了个人的私密空间，又便于相互交流和互动。床铺宽敞，适合两人共同居住；书桌方便两人共同学习或工作；储物设施则提供了充足的收纳空间。整体设计简洁实用，为居住者创造了一个和谐、温馨的居住环境。</strong></p>
            </div>
        </div>


        <div class="book-item">
            <img src="dorm/四人宿舍.png" alt="四人间" class="book-image">
            <div class="book-description">
                <p><strong style="font-size: 18px;"><span style="color: #07dc0b;">四人宿舍(多人间)</span>是一个紧凑而实用的共享空间，专为四位居住者设计。内部设有四张床铺、共用书桌和储物柜，确保每位居住者都有足够的休息和学习空间。床铺宽敞舒适，储物柜方便整理个人物品，书桌则提供了良好的学习环境。整体布局合理，既保障了私密性，也促进了室友间的交流互动。</strong></p>
            </div>
        </div>


        <div class="book-item">
            <img src="dorm/六人宿舍.png" alt="六人间" class="book-image">
            <div class="book-description">
                <p><strong style="font-size: 18px;"><span style="color: #07dc0b;">六人宿舍(多人间)</span>是一个宽敞且实用的共享空间，为六位居住者提供舒适的居住环境。内部设有六张床铺、足够的储物空间和共用学习区域，确保每位居住者都能拥有私人的休息和学习空间。床铺舒适宽敞，储物柜方便整理个人物品，学习区域则提供了良好的学习氛围。整体设计合理，既保障了居住者的私密性，也促进了室友间的友好交流。</strong></p>
            </div>
        </div>


    </div>
    </body>
</section>
</html>

