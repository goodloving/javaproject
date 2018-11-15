package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.创建cookie
		Cookie cookie = new Cookie("name", "zhangsan");
		
		//1.1为cookie设置持久化时间------------cookie信息在硬盘上的保存时间
		cookie.setMaxAge(60*10);		//十分钟
		
		//1.2为cookie设置携带路径
		cookie.setPath("/CookieAndSession");
		
		//2.发送cookie到客户端-------响应头
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
