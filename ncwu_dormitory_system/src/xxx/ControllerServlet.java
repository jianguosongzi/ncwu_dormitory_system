package xxx;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


//教工注册
public class ControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("register.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String EmployeeID = request.getParameter("EmployeeID");
        String Name = request.getParameter("Name");
        String Password = request.getParameter("Password");
        String Gender = request.getParameter("Gender");
        String Phone = request.getParameter("Phone");
        System.out.println(EmployeeID);
        System.out.println(Name);
        System.out.println(Password);
        System.out.println(Gender);
        System.out.println(Phone);

        String confirmPassword = request.getParameter("confirmPassword");


        if (!Password.equals(confirmPassword)) {
            System.out.println("密码不一致");
            request.setAttribute("error", "两次输入的密码不匹配");
        }

         else {



            // 连接到数据库并执行插入操作
            try (Connection conn = JDBCUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO teacher (EmployeeID, Name, Password, Gender, Phone) VALUES (?, ?, ?, ?, ?)")) {

                stmt.setString(1, EmployeeID);
                stmt.setString(2, Name);
                stmt.setString(3, Password); // 注意：在生产环境中，密码应该被安全地哈希和存储
                stmt.setString(4, Gender);
                stmt.setString(5, Phone);
                stmt.executeUpdate();



            } catch (SQLException e) {
                e.printStackTrace();
                // 处理异常，例如显示错误消息
                request.setAttribute("errorMessage", "注册失败:" + e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            // 假设存储用户信息成功


            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }


}