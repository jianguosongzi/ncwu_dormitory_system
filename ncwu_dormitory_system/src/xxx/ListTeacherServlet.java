package xxx;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//教工列表
public class ListTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Teacher> teachers = TeacherDB.getAllTeachers();
        System.out.println("111");
        req.setAttribute("teachers", teachers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("teacher_list.jsp");
        dispatcher.forward(req, resp);
    }
}