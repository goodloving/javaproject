package hl.demo.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCDX1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//û����Ӧͷ����֪�ͻ���ȥ�ض���ServletCDX2
		//1.����״̬��302
		//response.setStatus(302);
		//2.������Ӧͷloction
		//response.setHeader("Location", "/HttpResponseStudy/ServletCDX2");
		
		//response.sendRedirect("/HttpResponseStudy/ServletCDX2");
		
		response.setHeader("refresh", "5;url=http://www.baidu.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}