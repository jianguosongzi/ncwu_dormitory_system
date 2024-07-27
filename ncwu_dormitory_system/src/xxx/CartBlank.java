package xxx;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

//清空预约记录
public class CartBlank extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        DormDao dormDao = new DormDao();
        ArrayList<Dorm> list = dormDao.findAll();

        for (int i = 0; i < list.size(); i++) {
            dormDao.delete(list.get(i).getDormitoryType());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }
}
