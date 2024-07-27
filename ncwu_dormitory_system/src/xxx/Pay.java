//package xxx;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//
//
//    public class Pay extends HttpServlet {
//        @Override
//        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//            doPost(req, resp);
//        }
//
//        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//            request.setCharacterEncoding("UTF-8");
//            int count=countMoney();
//
//            PayMoney money=new PayMoney(count);
//            int userBalance = getUserBalance(request); // 假设这个方法存在并返回用户余额
//
//
//            request.setAttribute("paymoney", money.getMoney());
//            System.out.println(money.getMoney());
//            int amountToPay=userBalance;
//            request.setAttribute("amountToPay", amountToPay);
//
//
//
//            request.getRequestDispatcher("pay.jsp").forward(request, response);
//
//
//
//        }
//        public int countMoney() {
//            DormDao dormDao = new DormDao();
//            ArrayList<Dorm> list = dormDao.findAll();
//            int total = 0;
//            for (int i = 0; i < list.size(); i++) {
//                total += list.get(i).getCapacity();
//            }
//            return total;
//        }
//
//        private int getUserBalance(HttpServletRequest request) {
//            // 这里只是一个示例，您需要根据实际情况从session、数据库或其他地方获取用户余额
//            // 假设从session中获取用户余额
//            Integer balance = (Integer) request.getSession().getAttribute("money");
//            if (balance == null) {
//                // 如果没有找到用户余额，可以设置一个默认值或抛出异常
//                return 0;
//            }
//            return balance;
//        }
//
//
//
//
//    }
//
//
