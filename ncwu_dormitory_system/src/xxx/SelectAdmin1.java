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
import java.sql.ResultSet;
import java.sql.SQLException;

//教工查找管理员
public class SelectAdmin1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从请求中获取宿舍ID或其他查询参数
        request.setCharacterEncoding("UTF-8");
        String idString = request.getParameter("id");
        HttpSession session = request.getSession();
        if(session.getAttribute("EmployeeID")==null)
        {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }

        if (idString != null && !idString.isEmpty()) {
            try {
                int DormitoryID = Integer.parseInt(idString);
                System.out.println(DormitoryID);
                // 执行数据库查询操作
                Connection conn = JDBCUtil.getConnection();
                PreparedStatement pstmt = null;
                PreparedStatement pst = null;
                ResultSet rs = null;
                ResultSet rs1 = null;

                try {
                    System.out.println("管理员查找了");
                    String sql1 = "SELECT * FROM dorm WHERE DormitoryID = ?";
                    pst = conn.prepareStatement(sql1);
                    pst.setInt(1, DormitoryID);
                    rs1 = pst.executeQuery();
                    if (rs1.next()) {
                        int AdminID = rs1.getInt("AdminID");



                        String sql = "SELECT * FROM admin WHERE AdminID = ?";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setInt(1, AdminID);
                        rs = pstmt.executeQuery();

                        if (rs.next()) {
                            // 假设宿舍有name和capacity两个字段
                            String Username = rs.getString("Username");
                            String Email = rs.getString("Email");
                            String Password = rs.getString("Password");


                            Admin admin = new Admin(AdminID, Username, Email, Password);
                            // 将结果列表存储到request属性中，然后转发到JSP页面
                            request.setAttribute("admin", admin);
                            request.getRequestDispatcher("SelectAdminResult1.jsp").forward(request, response); // 转发到search-results.jsp页面

                            response.setCharacterEncoding("UTF-8");



                            //out.println("{\"宿舍号\":" + DormitoryID + ",\"宿舍类型\":\"" + DormitoryType + "\",\"容纳人数\":" + Capacity + ",\"居住状态\":\"" + OccupancyStatus + ",\"管理员ID\":\"" + AdminID +"}");
                        }
                        else {
                            System.out.println("没有找到匹配的宿舍记录");
                        }
                    }else {
                        // 宿舍未找到
                        request.getRequestDispatcher("errordormitory.jsp").forward(request, response);
                    }

                } catch (SQLException e) {
                    // 处理异常，返回错误信息给前端
                    request.getRequestDispatcher("SelectResult.jsp").forward(request, response);
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
                request.getRequestDispatcher("SelectResult.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.getRequestDispatcher("SelectResult.jsp").forward(request, response);
        }
    }
}
