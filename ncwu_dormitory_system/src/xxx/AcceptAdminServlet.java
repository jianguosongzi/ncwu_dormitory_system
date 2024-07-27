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

//管理员同意预约
public class AcceptAdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int DormitoryID = Integer.parseInt(req.getParameter("id"));

        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection()){


            PreparedStatement pstmt = null;
            String sql = "UPDATE dorm SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "已预约");
            pstmt.setInt(2, DormitoryID);

            PreparedStatement pstmt1 = null;
            String sql1 = "UPDATE book SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt1 = conn.prepareStatement(sql1);

            pstmt1.setString(1, "已预约");
            pstmt1.setInt(2, DormitoryID);



            pstmt.executeUpdate();
            pstmt1.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
            // 处理异常，例如显示错误消息
            req.setAttribute("errorMessage", "添加宿舍时出错：" + e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        resp.sendRedirect("ListDormServlet");
    }
}