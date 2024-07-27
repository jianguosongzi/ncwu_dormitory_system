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

//教工的预约记录表
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("EmployeeID")==null)
        {
            System.out.println("没注册1");
            RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");
            dispatcher.forward(req, resp);
        }
        String employeeIdStr = (String) session.getAttribute("EmployeeID");
        System.out.println(employeeIdStr);
        int EmployeeID = Integer.parseInt(employeeIdStr); // 将字符串转换为整数

        List<Book> books = BookDB.getAllBooks(EmployeeID);
        for (Book book:books) {
            System.out.println(book.getReservationID());
            System.out.println(book.getEmployeeID());
            System.out.println(book.getDormitoryID());
        }
        if (books == null) {
            books = new ArrayList<>();
        }
        // 将书籍列表存储到会话中（通常购物车会存储在这里）
        // 注意：这里我们使用了一个不同的属性名来存储购物车数据，例如"cart"而不是"CartServlet"
        req.getSession().setAttribute("CartServlet", books);

        // 将书籍列表也作为请求属性传递给JSP，以便在JSP中直接访问
        req.setAttribute("books", books);

        // 转发请求到JSP页面显示购物车内容
        RequestDispatcher dispatcher = req.getRequestDispatcher("cart.jsp");
        dispatcher.forward(req, resp);
    }
}