package xxx;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//教工取消预约
public class CancelServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int DormitoryID = Integer.parseInt(req.getParameter("id"));
        String employeeIdStr = (String) session.getAttribute("EmployeeID");
        int EmployeeID = Integer.parseInt(employeeIdStr); // 将字符串转换为整数
        System.out.println(EmployeeID);
        System.out.println(DormitoryID);

        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE DormitoryID = ?")) {

             stmt.setInt(1, DormitoryID);

            PreparedStatement pstmt = null;
            String sql = "UPDATE dorm SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt = conn.prepareStatement(sql);
            System.out.println("OK");
            pstmt.setString(1, "空闲");
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



        resp.sendRedirect("CartServlet");
    }
}