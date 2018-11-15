package Cookie;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoLastAccessTimeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前时间
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String currentTime = format.format(date);
		
		//1.创建一个cookie存放时间
		Cookie cookie = new Cookie("lastAccessTime", currentTime);
		cookie.setMaxAge(60*10*500);
		response.addCookie(cookie);
		
		//2.获得客户端携带的cookie ------lastAccessTime
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cook : cookies) {
				if(cook.getName().equals("lastAccessTime")) {
					response.getWriter().write(cook.getValue());
				}
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
