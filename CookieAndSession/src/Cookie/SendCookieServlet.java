package Cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendCookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.����cookie
		Cookie cookie = new Cookie("name", "zhangsan");
		
		//1.1Ϊcookie���ó־û�ʱ��------------cookie��Ϣ��Ӳ���ϵı���ʱ��
		cookie.setMaxAge(60*10);		//ʮ����
		
		//1.2Ϊcookie����Я��·��
		cookie.setPath("/CookieAndSession");
		
		//2.����cookie���ͻ���-------��Ӧͷ
		response.addCookie(cookie);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
