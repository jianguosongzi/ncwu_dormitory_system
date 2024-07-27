package xxx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//宿舍库，需要从MySQL中的Dorm数据表导入

public class DormDB {


    public static List<Dorm> getAllDorms() {
        List<Dorm> dorms = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            // 建立数据库连接
            conn = JDBCUtil.getConnection();

            // 创建SQL查询语句
            String sql = "SELECT DormitoryID, DormitoryType,Capacity,OccupancyStatus,AdminID FROM dorm";

            // 创建PreparedStatement对象
            pstmt = conn.prepareStatement(sql);

            // 执行查询并获取结果集
            rs = pstmt.executeQuery();
            System.out.println("333");
            // 遍历结果集并创建Dorm对象
            while (rs.next()) {
                System.out.println("222");
                int DormitoryID = rs.getInt("DormitoryID");
                String DormitoryType = rs.getString("DormitoryType");
                int Capacity = rs.getInt("Capacity");
                String OccupancyStatus=rs.getString("OccupancyStatus");
                int AdminID = rs.getInt("AdminID");
                Dorm dorm = new Dorm(DormitoryID, DormitoryType,Capacity,OccupancyStatus,AdminID);
                dorms.add(dorm);
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

        return dorms;
    }




}