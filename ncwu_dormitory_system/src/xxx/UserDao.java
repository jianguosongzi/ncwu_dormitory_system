//package xxx;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//
//public class UserDao {
//    //添加用户
//    public boolean insert(User user){
//        Connection conn=null;
//        Statement stmt=null;
//        ResultSet rs=null;
//        try {
//            conn=JDBCUtil.getConnection();
//            stmt=conn.createStatement();
//
//            System.out.println(user.getconsignee());
//            System.out.println(user.getUsername());
//            System.out.println(user.getPassword());
//            System.out.println(user.getEmail());
//            System.out.println(user.getAddress());
//            System.out.println(user.getPhone());
//            System.out.println(user.getMoney());
//            String sql="INSERT INTO user2(username,email,password,consignee,phone,address,money)"+
//                    "VALUES('"
//                    +user.getUsername()
//                    +"','"
//                    +user.getEmail()
//                    +"','"
//                    +user.getPassword()
//                    +"','"
//                    +user.getconsignee()
//                    +"','"
//                    +user.getPhone()
//                    +"','"
//                    +user.getAddress()
//                    +"','"
//                    +user.getMoney()
//                    +"')";
//            int num=stmt.executeUpdate(sql);
//            if(num>0){
//                return true;
//            }
//            return false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.release(rs,stmt,conn);
//        }
//        return false;
//    }
//
//    //查询操作
//    public  ArrayList<User> findAll(){
//        Connection conn=null;
//        Statement stmt=null;
//        ResultSet rs=null;
//        ArrayList<User> list=new ArrayList<User>();
//        try {
//            conn=JDBCUtil.getConnection();
//            stmt=conn.createStatement();
//            String sql="SELECT * FROM user";
//            rs=stmt.executeQuery(sql);
//            while(rs.next()){
//                User user=new User();
//                user.setUsername(rs.getString("username"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                user.setconsignee(rs.getString("consignee"));
//                user.setPhone(rs.getString("phone"));
//                user.setAddress(rs.getString("address"));
//
//                list.add(user);
//            }
//            return list;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.release(rs,stmt,conn);
//        }
//        return null;
//    }
//    //查找指定id操作
//    public User find(String username){
//        Connection conn=null;
//        Statement stmt=null;
//        ResultSet rs=null;
//        try {
//            conn=JDBCUtil.getConnection();
//            stmt=conn.createStatement();
//            String sql="SELECT * FROM user WHERE username='"+username+"'";
//            rs=stmt.executeQuery(sql);
//            while(rs.next()){
//                User user=new User();
//                user.setUsername(rs.getString("username"));
//                user.setEmail(rs.getString("email"));
//                user.setPassword(rs.getString("password"));
//                user.setconsignee(rs.getString("consignee"));
//                user.setPhone(rs.getString("phone"));
//                user.setAddress(rs.getString("address"));
//                return user;
//            }
//            return null;
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.release(rs,stmt,conn);
//        }
//        return null;
//    }
//    //删除操作
//    public boolean delete(User user){
//        Connection conn=null;
//        Statement stmt=null;
//        ResultSet rs=null;
//        try{
//            conn=JDBCUtil.getConnection();
//            stmt=conn.createStatement();
//            String sql="DELETE FROM user WHERE username="+user.getUsername();
//            int num=stmt.executeUpdate(sql);
//            if(num>0){
//                return true;
//            }
//            return false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.release(rs,stmt,conn);
//        }
//        return false;
//    }
//    //修改用户
//    public boolean update(User user){
//        Connection conn=null;
//        Statement stmt=null;
//        ResultSet rs=null;
//        try {
//            conn=JDBCUtil.getConnection();
//            stmt=conn.createStatement();
//
//            String sql="UPDATE user2 set email='"+user.getEmail()
//                    +"',consignee='"+user.getconsignee()+"',phone='"
//                    +user.getPhone()+"',address='"+user.getAddress()
//                    +"'WHERE username='"+user.getUsername()+"'AND password='"+user.getPassword()+"'";
//            int num=stmt.executeUpdate(sql);
//            if(num>0){
//                return true;
//            }
//            return false;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.release(rs,stmt,conn);
//        }
//        return false;
//    }
//}
