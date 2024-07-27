package xxx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//管理员列表
public class ListAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Admin> admins = AdminDB.getAllAdmins();
        System.out.println("111");
        req.setAttribute("admins", admins);
        RequestDispatcher dispatcher = req.getRequestDispatcher("admin_list.jsp");
        dispatcher.forward(req, resp);
    }
}