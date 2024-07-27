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
import java.util.ArrayList;
import java.util.List;

//教工预约宿舍
public class PurchaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        System.out.println("没注册");
        if(session.getAttribute("EmployeeID")==null)
        {
            System.out.println("没注册1");
            RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
            dispatcher.forward(req, resp);
        }
        int DormitoryID = Integer.parseInt(req.getParameter("id"));
        String employeeIdStr = (String) session.getAttribute("EmployeeID");
        int EmployeeID = Integer.parseInt(employeeIdStr); // 将字符串转换为整数
        System.out.println(EmployeeID);
        System.out.println(DormitoryID);
        List<Book> cart = (List<Book>) req.getSession().getAttribute("CartServlet");
        if (cart == null) {
            cart = new ArrayList<>();
            req.getSession().setAttribute("CartServlet", cart);
        }

        String OccupancyStatus = null;
        int AdminID = 0;

        try {


            // 执行数据库查询操作
            Connection conn = JDBCUtil.getConnection();
            PreparedStatement pstmt2 = null;
            ResultSet rs2 = null;

            try {

                String sql = "SELECT * FROM dorm WHERE DormitoryID = ?";
                pstmt2 = conn.prepareStatement(sql);
                pstmt2.setInt(1, DormitoryID);
                rs2 = pstmt2.executeQuery();

                if (rs2.next()) {
                    // 假设宿舍有name和capacity两个字段
                    String DormitoryType = rs2.getString("DormitoryType");
                    int Capacity = rs2.getInt("Capacity");
                    OccupancyStatus=rs2.getString("OccupancyStatus");
                    AdminID=rs2.getInt("AdminID");


                    Dorm dorm = new Dorm(DormitoryID,DormitoryType,Capacity,OccupancyStatus,AdminID);

                }
            } catch (SQLException e) {
                // 处理异常，返回错误信息给前端

            } finally {
                // 关闭资源
                try {
                    if (rs2 != null) rs2.close();
                    if (pstmt2 != null) pstmt2.close();
                    if (conn != null) conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (NumberFormatException e) {
            // 处理ID格式错误的异常

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------------");
        System.out.println(AdminID);
        System.out.println(OccupancyStatus);
        System.out.println("--------------");

        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO book (ReservationID, EmployeeID, DormitoryID,AdminID,OccupancyStatus) VALUES (?, ?, ?,?,?)")) {

            stmt.setInt(1, (int)(Math.random() * 100) + 1);
            stmt.setInt(2, EmployeeID);
            stmt.setInt(3, DormitoryID);
            stmt.setInt(4,AdminID);
            stmt.setString(5,"申请中");

            PreparedStatement pstmt = null;
            String sql = "UPDATE dorm SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt = conn.prepareStatement(sql);
            System.out.println("OK");
            pstmt.setString(1, "申请中");
            pstmt.setInt(2, DormitoryID);
            System.out.println("连了");

            stmt.executeUpdate();
            pstmt.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常，例如显示错误消息
            req.setAttribute("errorMessage", "添加宿舍时出错：" + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        Book book = BookDB.getAllBooks(EmployeeID).stream()
                .filter(c -> c.getDormitoryID() == DormitoryID)
                .findFirst()
                .orElse(null);
        if (book != null) {
                cart.add(book);
        }
            resp.sendRedirect("CartServlet");
    }
}