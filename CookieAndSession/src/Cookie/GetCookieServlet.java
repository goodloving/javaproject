package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ÿͻ���Я����cookie������
		Cookie[] cookies = request.getCookies();
		
		//2.ͨ��cookie��name�����Ҫ��cookie
		for(Cookie cookie:cookies) {
			String cookieName = cookie.getName();
			if(cookieName.equals("name")) {
				//3.��ø�cookie��ֵ
				String cookieValue = cookie.getValue();
				System.out.println(cookieValue);
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
