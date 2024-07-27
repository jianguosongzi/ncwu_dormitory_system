package xxx;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//预约记录库，从MySQL数据库的Book表中导入
public class BookDB {


    public static List<Book> getAllBooks(int EmployeeID) {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;



        try {


            // 建立数据库连接
            conn = JDBCUtil.getConnection();


            System.out.println(EmployeeID);
            // 创建SQL查询语句
            String sql = "SELECT ReservationID, EmployeeID,DormitoryID,AdminID,OccupancyStatus FROM book WHERE EmployeeID = ?";

            // 创建PreparedStatement对象
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,EmployeeID);

            // 执行查询并获取结果集
            rs = pstmt.executeQuery();

            // 遍历结果集并创建Book对象
            while (rs.next()) {

                int ReservationID = rs.getInt("ReservationID");

                int DormitoryID = rs.getInt("DormitoryID");

                int AdminID=rs.getInt("AdminID");

                String OccupancyStatus=rs.getString("OccupancyStatus");


                Book book = new Book(ReservationID, EmployeeID,DormitoryID,AdminID,OccupancyStatus);
                books.add(book);
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

        return books;
    }




}