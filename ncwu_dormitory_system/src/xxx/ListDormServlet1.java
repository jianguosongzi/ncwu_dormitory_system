package xxx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//宿舍列表
public class ListDormServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dorm> dorms = DormDB.getAllDorms();
        System.out.println("111");
        req.setAttribute("dorms", dorms);
        RequestDispatcher dispatcher = req.getRequestDispatcher("dorm_list1.jsp");
        dispatcher.forward(req, resp);
    }
}