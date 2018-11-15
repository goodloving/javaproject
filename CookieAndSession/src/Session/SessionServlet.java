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
		//�������ڸÿͻ��˵�˽�е�session����
		HttpSession session = request.getSession();
		session.setAttribute("name", "jerry");
		
		
		//��ȡ��session�����ID
		String id = session.getId();
		
		//Ϊsession���ó־û�ʱ��
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
