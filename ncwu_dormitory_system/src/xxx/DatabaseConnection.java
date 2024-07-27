//package xxx;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
////数据库连接
//public class DatabaseConnection {
//
//    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ncwu_dormitory_system";
//    private static final String JDBC_USER = "root";
//    private static final String JDBC_PASSWORD = "123456";
//
//    public static boolean isConnectionSuccessful() {
//        Connection connection = null;
//        try {
//            // 加载数据库驱动（以MySQL为例）
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 建立数据库连接
//            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//
//            // 如果连接不为空，则表示连接成功
//            if (connection != null) {
//                System.out.println("数据库连接成功！");
//                return true;
//            }
//        } catch (ClassNotFoundException e) {
//            // 驱动未找到异常处理
//            System.err.println("数据库驱动未找到: " + e.getMessage());
//        } catch (SQLException e) {
//            // SQL异常处理
//            System.err.println("数据库连接失败: " + e.getMessage());
//        } finally {
//            // 关闭连接（如果有的话）
//            try {
//                if (connection != null && !connection.isClosed()) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // 关闭连接时的异常处理
//                System.err.println("关闭数据库连接时出错: " + e.getMessage());
//            }
//        }
//
//        // 如果执行到这里，则表示连接失败
//        return false;
//    }
//
////    public static void main(String[] args) {
////        boolean isSuccess = isConnectionSuccessful();
////        System.out.println("连接是否成功: " + isSuccess);
////    }
//}
