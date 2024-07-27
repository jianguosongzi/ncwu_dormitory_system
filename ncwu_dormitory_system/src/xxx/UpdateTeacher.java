package xxx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//管理员更新教工
public class UpdateTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取宿舍ID和需要更新的信息
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        if(session.getAttribute("adminID")==null)
        {
            System.out.println("没注册1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        String EmployeeID = request.getParameter("EmployeeID");
        String Name = request.getParameter("Name");
        String Password = request.getParameter("Password");
        String Gender = request.getParameter("Gender");
        String Phone = request.getParameter("Phone");

        if (EmployeeID != null && !EmployeeID.isEmpty() && Name != null && Password != null && !Password.isEmpty()) {
            try {
                Connection conn = JDBCUtil.getConnection();


                PreparedStatement pstmt = null;
                // 执行数据库更新操作

                try {

                    String sql = "UPDATE teacher SET  Name = ?,Password=?,Gender=?,Phone=? WHERE EmployeeID = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, Name);
                    pstmt.setString(2, Password);
                    pstmt.setString(3, Gender);
                    pstmt.setString(4, Phone);
                    pstmt.setString(5, EmployeeID);

                    int updatedRows = pstmt.executeUpdate();

                    if (updatedRows > 0) {
                        response.setStatus(HttpServletResponse.SC_OK); // 返回200 OK状态码
                        response.sendRedirect("ListTeacherServlet");
                    } else {

                        response.sendRedirect("errorteacher.jsp");
                    }
                } catch (SQLException e) {
                    // 处理异常，返回错误信息给前端
                    e.printStackTrace();
                    response.sendRedirect("errorteacher.jsp");
                } finally {
                    // 关闭资源（尽管在实际应用中，应该使用try-with-resources来自动关闭）
                    try {
                        if (pstmt != null) {
                            pstmt.close();
                        }
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (NumberFormatException e) {
                // 处理ID或容量格式错误的异常
                e.printStackTrace();
                response.sendRedirect("errorteacher.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 处理参数缺失的错误
            response.sendRedirect("errorteacher.jsp");
        }
    }
}