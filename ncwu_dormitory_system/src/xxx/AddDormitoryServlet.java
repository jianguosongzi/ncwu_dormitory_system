package xxx;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

//添加宿舍
public class AddDormitoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单参数
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //判断是否登录，没登录的直接返回登录
        if(session.getAttribute("adminID")==null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        //获取宿舍相关信息
        int DormitoryID = Integer.parseInt(request.getParameter("DormitoryID"));
        String DormitoryType = request.getParameter("DormitoryType");
        String capacity = request.getParameter("Capacity");
        String occupancyStatus = request.getParameter("OccupancyStatus");
        String adminID = request.getParameter("AdminID");
        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO dorm (DormitoryID, DormitoryType, Capacity, OccupancyStatus, AdminID) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setInt(1, DormitoryID);
            stmt.setString(2, DormitoryType);
            stmt.setString(3, capacity); //
            stmt.setString(4, occupancyStatus);
            stmt.setString(5, adminID);
            stmt.executeUpdate();

            // 重定向到宿舍列表页面
            response.sendRedirect("ListDormServlet");

        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常，例如显示错误消息
            request.setAttribute("errorMessage", "添加宿舍时出错：" + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
