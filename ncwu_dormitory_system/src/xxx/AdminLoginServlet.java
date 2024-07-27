package xxx;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
//管理员登录
public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String adminID = request.getParameter("AdminID");
        String password = request.getParameter("Password");



        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        //获取admin表中存储的信息并进行登录验证
        try {

            conn = JDBCUtil.getConnection();
            String sql = "SELECT * FROM admin WHERE AdminID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                // 用户名存在
                String dbPassword = rs.getString("password");
                if (dbPassword.equals(password)) {
                    // 密码正确，登录成功
                    HttpSession session = request.getSession();
                    session.setAttribute("adminID", adminID);
                    session.setAttribute("Username",rs.getString("Username"));
                    session.setAttribute("Password",rs.getString("Password"));
                    session.setAttribute("Email",rs.getString("Email"));

                    response.sendRedirect("Adminindex.jsp"); // 跳转到成功页面
                } else {
                    // 密码错误
                    request.setAttribute("error", "密码错误，请重新输入");

                    request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
                }
            } else {
                // 用户名不存在
                request.setAttribute("error", "用户名不存在");
                request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
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
