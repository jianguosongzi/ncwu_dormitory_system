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
//管理员更新宿舍
public class UpdateDormitory extends HttpServlet {
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
        String DormitoryID = request.getParameter("DormitoryID");
        String DormitoryType = request.getParameter("DormitoryType");
        String Capacity = request.getParameter("Capacity");
        String OccupancyStatus = request.getParameter("OccupancyStatus");
        String AdminID = request.getParameter("AdminID");

        if (DormitoryID != null && !DormitoryID.isEmpty() && DormitoryType != null && Capacity != null && !Capacity.isEmpty()) {
            try {
                Connection conn = JDBCUtil.getConnection();
                //int id = Integer.parseInt(DormitoryID);
                int capacity = Integer.parseInt(Capacity);
                PreparedStatement pstmt = null;
                // 执行数据库更新操作

                try {

                    String sql = "UPDATE dorm SET  DormitoryType = ?,Capacity=?,OccupancyStatus=?,AdminID=? WHERE DormitoryID = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, DormitoryType);
                    pstmt.setInt(2, capacity);
                    pstmt.setString(3, OccupancyStatus);
                    pstmt.setString(4, AdminID);
                    pstmt.setString(5, DormitoryID);

                    int updatedRows = pstmt.executeUpdate();

                    if (updatedRows > 0) {
                        response.setStatus(HttpServletResponse.SC_OK); // 返回200 OK状态码
                        response.sendRedirect("ListDormServlet");
                    } else {
                        response.sendRedirect("errordormitory.jsp");
                    }
                } catch (SQLException e) {
                    // 处理异常，返回错误信息给前端
                    e.printStackTrace();
                    response.sendRedirect("errordormitory.jsp");
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
                response.sendRedirect("errordormitory.jsp");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 处理参数缺失的错误
            response.sendRedirect("errordormitory.jsp");
        }
    }
}