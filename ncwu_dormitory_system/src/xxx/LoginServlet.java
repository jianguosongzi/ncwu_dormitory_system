package xxx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
//教工登录
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String empId = request.getParameter("empId");
        String password = request.getParameter("password");
        System.out.println(empId);
        System.out.println(password);


        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            conn = JDBCUtil.getConnection();

            String sql = "SELECT * FROM teacher WHERE EmployeeID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, empId);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 用户名存在
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // 密码正确，登录成功
                    HttpSession session = request.getSession();
                    session.setAttribute("EmployeeID", empId);
                    session.setAttribute("Name",rs.getString("Name"));
                    session.setAttribute("Password",rs.getString("Password"));
                    session.setAttribute("Gender",rs.getString("Gender"));
                    session.setAttribute("Phone",rs.getString("Phone"));


                    response.sendRedirect("index.jsp"); // 跳转到成功页面
                } else {
                    System.out.println("111");
                    // 密码错误
                    request.setAttribute("error", "密码错误，请重新输入");
                    System.out.println("222");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            } else {
                // 用户名不存在
                request.setAttribute("error", "用户名不存在");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
