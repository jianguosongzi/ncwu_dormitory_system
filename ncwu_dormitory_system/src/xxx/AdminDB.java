package xxx;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//管理员库，需要从MySQL数据库的管理员表中导入数据
public class AdminDB {

    public static List<Admin> getAllAdmins() {
        List<Admin> admins = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {

            // 建立数据库连接
            conn = JDBCUtil.getConnection();

            // 创建SQL查询语句
            String sql = "SELECT AdminID, Username,Email,Password FROM admin";

            // 创建PreparedStatement对象
            pstmt = conn.prepareStatement(sql);

            // 执行查询并获取结果集
            rs = pstmt.executeQuery();

            // 遍历结果集并创建Admin对象
            while (rs.next()) {
                int AdminID = rs.getInt("AdminID");
                String Username = rs.getString("Username");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                Admin admin = new Admin(AdminID, Username,Email,Password);
                admins.add(admin);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return admins;
    }




}