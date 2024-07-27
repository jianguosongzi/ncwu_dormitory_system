package xxx;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//教工库，需要从MySQL的Teacher表中导入
public class TeacherDB {

    public static List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {


            conn = JDBCUtil.getConnection();

            // 创建SQL查询语句
            String sql = "SELECT EmployeeID, Name,Password,Gender,Phone FROM teacher";

            // 创建PreparedStatement对象
            pstmt = conn.prepareStatement(sql);

            // 执行查询并获取结果集
            rs = pstmt.executeQuery();
            System.out.println("333");
            // 遍历结果集并创建Book对象
            while (rs.next()) {
                System.out.println("222");
                int EmployeeID = rs.getInt("EmployeeID");
                String Name = rs.getString("Name");
                String Password = rs.getString("Password");
                String Gender=rs.getString("Gender");
                String Phone = rs.getString("Phone");
                Teacher teacher = new Teacher(EmployeeID, Name,Password,Gender,Phone);
                teachers.add(teacher);
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

        return teachers;
    }




}