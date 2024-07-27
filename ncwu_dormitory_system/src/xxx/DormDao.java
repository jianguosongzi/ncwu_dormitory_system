package xxx;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

//宿舍类操作

public class DormDao {
    public boolean insert(Dorm dorm){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn=JDBCUtil.getConnection();
            stmt=conn.createStatement();


            String sql="INSERT INTO cart1(bookname,price)"+
                    "VALUES("
                    +"'"
                    +dorm.getDormitoryType()
                    +"',"
                    +dorm.getCapacity()
                    +")";
            int num=stmt.executeUpdate(sql);
            if(num>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,stmt,conn);
        }
        return false;
    }
    //查询操作
    public ArrayList<Dorm> findAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Dorm> list=new ArrayList<Dorm>();
        try {
            conn=JDBCUtil.getConnection();
            stmt=conn.createStatement();
            String sql="SELECT * FROM cart1";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Dorm book=new Dorm();
                book.setDormitoryType(rs.getString("bookname"));
                book.setCapacity(rs.getInt("price"));



                list.add(book);
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,stmt,conn);
        }
        return null;
    }

    //删除操作
    public boolean delete(String name){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try{
            conn=JDBCUtil.getConnection();
            stmt=conn.createStatement();

            String sql="DELETE FROM cart1 WHERE bookname='"+name+"'";
            int num=stmt.executeUpdate(sql);
            if(num>0){
                return true;
            }
            return false;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.release(rs,stmt,conn);
        }
        return false;
    }

}
