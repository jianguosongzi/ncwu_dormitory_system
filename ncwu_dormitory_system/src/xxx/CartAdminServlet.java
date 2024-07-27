package xxx;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//管理员管理预约记录
public class CartAdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String idString=(String) session.getAttribute("adminID");
        System.out.println(idString);
        List<Book> books = BookAdminDB.getAllAdminBooks(idString);
        for (Book book:books) {
            System.out.println(book.getReservationID());
            System.out.println(book.getEmployeeID());
            System.out.println(book.getDormitoryID());
        }
        if (books == null) {
            books = new ArrayList<>();
        }
        // 将书籍列表存储到会话中（通常购物车会存储在这里）

//        req.getSession().setAttribute("CartAdminServlet", books);

        // 将书籍列表也作为请求属性传递给JSP，以便在JSP中直接访问
        req.setAttribute("books", books);

        // 转发请求到JSP页面显示购物车内容
        RequestDispatcher dispatcher = req.getRequestDispatcher("cartadmin.jsp");
        dispatcher.forward(req, resp);
    }
}