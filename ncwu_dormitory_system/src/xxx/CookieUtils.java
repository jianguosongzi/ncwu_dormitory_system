//package xxx;
//
//import javax.servlet.http.Cookie;
//
//
////Cookie信息管理
//public class CookieUtils {
//    public static Cookie findCookie(Cookie[] cookies, String name) {
//        if (cookies == null) {
//            // 浏览器没有携带Cookie
//            return null;
//        } else {
//            for (Cookie cookie : cookies) {
//                // 判断cookie是否是我们想要的那个cookie
//                // public String getName()：返回 Cookie 的名称。创建后无法更改名称。
//                if (cookie.getName().equals(name)) {
//                    // 直接返回cookie
//                    return cookie;
//                }
//            }
//            // 浏览器带有Cookie，但是没有指定名称的那个Cookie
//            return null;
//        }
//    }
//}
//
