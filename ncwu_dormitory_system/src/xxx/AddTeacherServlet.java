package xxx;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
//添加教工
public class AddTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取表单参数
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        //判断是否登录，没有登录直接返回登录
        if(session.getAttribute("adminID")==null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        //获取教工相关信息
        int EmployeeID = Integer.parseInt(request.getParameter("EmployeeID"));
        String Name = request.getParameter("Name");
        String Password = request.getParameter("Password");
        String Gender = request.getParameter("Gender");
        String Phone = request.getParameter("Phone");

        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO teacher (EmployeeID, Name, Password, Gender, Phone) VALUES (?, ?, ?, ?, ?)")) {

            stmt.setInt(1, EmployeeID);
            stmt.setString(2, Name);
            stmt.setString(3, Password); // 注意：在生产环境中，密码应该被安全地哈希和存储
            stmt.setString(4, Gender);
            stmt.setString(5, Phone);
            stmt.executeUpdate();

            // 重定向到宿舍列表页面
            response.sendRedirect("ListTeacherServlet");

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
