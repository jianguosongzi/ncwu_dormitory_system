package xxx;

import java.sql.*;

//数据库连接
public class JDBCUtil {
    public static Connection getConnection() throws SQLException,
            ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/ncwu_dormitory_system?useUnicode=true&characterEncoding=UTF-8&userSSL=false&serverTimezone=GMT%2B8";
        String username="root";
        String password="123456";
        Connection conn= DriverManager.getConnection(url,username,password);
        return conn;
    }
    public static void release(Statement stmt,Connection conn){
        if(stmt!=null){
            try {
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            stmt=null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn=null;
        }
    }
    public static void release(ResultSet rs,Statement stmt,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        release(stmt,conn);
    }
}
