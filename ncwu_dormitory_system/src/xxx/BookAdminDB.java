package xxx;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//管理员管理预约记录的库，每个管理员都有自己对应的预约记录，不可越权操作
public class BookAdminDB {


    //获取指定管理员ID的预约记录
    public static List<Book> getAllAdminBooks(String AdminID) {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        PreparedStatement pst = null;
        ResultSet rs1 = null;

        try {
//
//            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            conn = JDBCUtil.getConnection();

            System.out.println("管理员查找了");
            String sql1 = "SELECT * FROM dorm WHERE AdminID = ? AND OccupancyStatus IN ('已预约', '申请中')";
            System.out.println("管理员查找了");

            pst = conn.prepareStatement(sql1);
            pst.setString(1, AdminID);
            System.out.println(AdminID);

            rs1 = pst.executeQuery();
            while (rs1.next()) {
                int DormitoryID = rs1.getInt("DormitoryID");
                System.out.println(DormitoryID);

                // 创建SQL查询语句
                String sql = "SELECT ReservationID, EmployeeID,DormitoryID,AdminID,OccupancyStatus FROM book WHERE DormitoryID = ? ";
                // 创建PreparedStatement对象
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, DormitoryID);


                // 执行查询并获取结果集
                rs = pstmt.executeQuery();
                System.out.println("333");
                // 遍历结果集并创建Dorm对象
                while (rs.next()) {
                    System.out.println("222");
                    int ReservationID = rs.getInt("ReservationID");
                    int EmployeeID = rs.getInt("EmployeeID");
                    int AdminID1=Integer.parseInt(AdminID);
                    String OccupancyStatus=rs.getString("OccupancyStatus");

                    Book book = new Book(ReservationID, EmployeeID, DormitoryID,AdminID1,OccupancyStatus);
                    books.add(book);
                }
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

 //获取所有的预约记录，不分属于哪个管理员
    public static List<Book> getAllAdminBooks() {
        List<Book> books = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 加载并注册JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立数据库连接
            conn = JDBCUtil.getConnection();
                // 创建SQL查询语句
                String sql = "SELECT ReservationID, EmployeeID,DormitoryID,AdminID,OccupancyStatus FROM book ";
                // 创建PreparedStatement对象
                pstmt = conn.prepareStatement(sql);

                // 执行查询并获取结果集
                rs = pstmt.executeQuery();
                // 遍历结果集并创建Dorm对象
                while (rs.next()) {
                    int ReservationID = rs.getInt("ReservationID");
                    int EmployeeID = rs.getInt("EmployeeID");
                    int DormitoryID = rs.getInt("DormitoryID");
                    int AdminID=rs.getInt("AdminID");
                    String OccupancyStatus=rs.getString("OccupancyStatus");

                    Book book = new Book(ReservationID, EmployeeID, DormitoryID,AdminID,OccupancyStatus);
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