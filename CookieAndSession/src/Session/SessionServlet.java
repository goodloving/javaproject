package Session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建属于该客户端的私有的session区域
		HttpSession session = request.getSession();
		session.setAttribute("name", "jerry");
		
		
		//获取该session区域的ID
		String id = session.getId();
		
		//为session设置持久化时间
		Cookie cookie = new Cookie("JSESSIONID", id);
		cookie.setPath("/CookieAndSession/");
		cookie.setMaxAge(60*10);
		response.addCookie(cookie);
		
		response.getWriter().write(id);
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
