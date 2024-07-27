package xxx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//管理员查找教工
public class SelectTeacher extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取宿舍ID或其他查询参数
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("EmployeeID");
        HttpSession session = request.getSession();
        if(session.getAttribute("adminID")==null)
        {
            System.out.println("没注册1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

        if (idString != null && !idString.isEmpty()) {
            try {
                int EmployeeID = Integer.parseInt(idString);

                // 执行数据库查询操作
                Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = null;
                ResultSet rs = null;

                try {

                    String sql = "SELECT * FROM teacher WHERE EmployeeID = ?";
                    pstmt = conn.prepareStatement(sql);
                    pstmt.setInt(1, EmployeeID);
                    rs = pstmt.executeQuery();

                    if (rs.next()) {
                        // 假设宿舍有name和capacity两个字段
                        String Name = rs.getString("Name");
                        String Password = rs.getString("Password");
                        String Gender=rs.getString("Gender");
                        String Phone=rs.getString("Phone");


                        Teacher teacher = new Teacher(EmployeeID,Name,Password,Gender,Phone);
                        // 将结果列表存储到request属性中，然后转发到JSP页面
                        request.setAttribute("teacher", teacher);
                        request.getRequestDispatcher("SelectTeacherResult.jsp").forward(request, response); // 转发到search-results.jsp页面

                        response.setCharacterEncoding("UTF-8");

                        //out.println("{\"宿舍号\":" + DormitoryID + ",\"宿舍类型\":\"" + DormitoryType + "\",\"容纳人数\":" + Capacity + ",\"居住状态\":\"" + OccupancyStatus + ",\"管理员ID\":\"" + AdminID +"}");
                    } else {
                        // 宿舍未找到
                        request.getRequestDispatcher("errorteacher.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    // 处理异常，返回错误信息给前端
                    request.getRequestDispatcher("errorteacher.jsp").forward(request, response);
                } finally {
                    // 关闭资源
                    try {
                        if (rs != null) rs.close();
                        if (pstmt != null) pstmt.close();
                        if (conn != null) conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } catch (NumberFormatException e) {
                // 处理ID格式错误的异常
                request.getRequestDispatcher("errorteacher.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            // 处理参数缺失的错误
            request.getRequestDispatcher("errorteacher.jsp").forward(request, response);
        }
    }
}
