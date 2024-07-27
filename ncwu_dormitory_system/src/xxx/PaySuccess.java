//package xxx;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class PaySuccess extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req, resp);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        request.setCharacterEncoding("UTF-8");
//        int count=countMoney();
//        Date d1 = new Date();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
//        String s1 = sdf1.format(d1);
//        request.setAttribute("time", s1);
//
//        PayMoney money=new PayMoney(count);
//
//
//
//        int userBalance = getUserBalance(request); // 假设这个方法存在并返回用户余额
//
//
//        request.setAttribute("paymoney", money.getMoney());
//
//        int amountToPay=userBalance-money.getMoney();
//        money.setMoney(amountToPay);
//        request.setAttribute("amountToPay", amountToPay);
//
//        UserDao userDao=new UserDao();
//        User user= userDao.find("username");
//
//
//
//
//
//
//
//        DormDao dormDao = new DormDao();
//        ArrayList<Dorm> list = dormDao.findAll();
//        List<Dorm> cart = (List<Dorm>) request.getSession().getAttribute("CartServlet");
//
//        for (int i = 0; i < list.size(); i++) {
//            dormDao.delete(list.get(i).getDormitoryType());
//
//        }
//        cart.clear();
//
//
//        request.getRequestDispatcher("PaySuccess.jsp").forward(request, response);
//
//
//
//    }
//    public int countMoney() {
//        DormDao dormDao = new DormDao();
//        ArrayList<Dorm> list = dormDao.findAll();
//        int total = 0;
//        for (int i = 0; i < list.size(); i++) {
//            total += list.get(i).getCapacity();
//        }
//        return total;
//    }
//    private int getUserBalance(HttpServletRequest request) {
//        // 这里只是一个示例，您需要根据实际情况从session、数据库或其他地方获取用户余额
//        // 假设从session中获取用户余额
//        Integer balance = (Integer) request.getSession().getAttribute("money");
//        if (balance == null) {
//            // 如果没有找到用户余额，可以设置一个默认值或抛出异常
//            return 0;
//        }
//        return balance;
//    }
//}
