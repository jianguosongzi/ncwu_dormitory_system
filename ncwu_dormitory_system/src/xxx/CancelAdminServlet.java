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

//管理员删除自己管理的预约记录，每个预约记录都有指定的唯一管理员管理，只有对应的管理员可以删除相关预约记录
public class CancelAdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int DormitoryID = Integer.parseInt(req.getParameter("id"));



//        List<Book> cart = (List<Book>) req.getSession().getAttribute("CartServlet");
//        if (cart == null) {
//            cart = new ArrayList<>();
//            req.getSession().setAttribute("CartServlet", cart);
//        }
        // 连接到数据库并执行插入操作
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM book WHERE DormitoryID = ?")) {

            stmt.setInt(1, DormitoryID);

            PreparedStatement pstmt = null;
            String sql = "UPDATE dorm SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "空闲");
            pstmt.setInt(2, DormitoryID);


            PreparedStatement pstmt1 = null;
            String sql1 = "UPDATE book SET OccupancyStatus=? WHERE DormitoryID = ?";
            pstmt1 = conn.prepareStatement(sql1);

            pstmt1.setString(1, "空闲");
            pstmt1.setInt(2, DormitoryID);

            pstmt1.executeUpdate();
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



        resp.sendRedirect("CartAdminServlet");
    }
}