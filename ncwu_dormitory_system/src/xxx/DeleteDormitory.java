package xxx;
import java.io.IOException;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;



//删除宿舍
public class DeleteDormitory extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取要删除的宿舍ID
        HttpSession session = request.getSession();
        if(session.getAttribute("adminID")==null)
        {
            System.out.println("没注册1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
        String idString = request.getParameter("DormitoryID");
        if (idString != null && !idString.isEmpty()) {
            try {Connection conn = JDBCUtil.getConnection();
                int DormitoryID = Integer.parseInt(idString);

                // 直接在Servlet中执行数据库操作  

                String sql = "DELETE FROM dorm WHERE DormitoryID = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setInt(1, DormitoryID);
                    pstmt.executeUpdate();
                }

                // 关闭连接
                conn.close();

                response.sendRedirect("ListDormServlet");
            } catch (NumberFormatException | SQLException e) {
                // 处理异常，返回错误信息给前端  
                e.printStackTrace();
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 返回400 Bad Request状态码  
                response.getWriter().write("未找到宿舍 " + e.getMessage());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 处理ID缺失的错误  
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 返回400 Bad Request状态码  
            response.getWriter().write("格式错误");
        }
    }



}