package xxx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//教工的宿舍搜索
public class Sousuo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm"); // 获取搜索词
        request.setCharacterEncoding("UTF-8");



        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Dorm> dorms = new ArrayList<>(); // 用于存储查询到的宿舍列表
        try {
            conn = JDBCUtil.getConnection();// 调用你的数据库连接方法

            // 构建查询语句
            String sql = "SELECT * FROM dorm WHERE DormitoryType LIKE ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + searchTerm + "%"); // 使用LIKE进行模糊查询

            rs = pstmt.executeQuery();

            while (rs.next()) { // 迭代所有结果
                // 假设bookname和id是你要从ResultSet中获取的字段
                int DormitoryID =rs.getInt("DormitoryID");
                String DormitoryType = rs.getString("DormitoryType"); // 假设bookname是数据库中的列名
                int Capacity = rs.getInt("Capacity"); // 假设id是数据库中的列名
                String OccupancyStatus=rs.getString("OccupancyStatus");
                int AdminID=rs.getInt("AdminID");


                // 创建一个新的Dorm对象并添加到列表中
                Dorm dorm = new Dorm(DormitoryID,DormitoryType,Capacity,OccupancyStatus,AdminID);
                dorms.add(dorm);
            }

            // 将结果列表存储到request属性中，然后转发到JSP页面
            request.setAttribute("dorms", dorms);
            request.getRequestDispatcher("search-results.jsp").forward(request, response); // 转发到search-results.jsp页面

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源（省略了具体实现）
            // ...
        }


    }






}

