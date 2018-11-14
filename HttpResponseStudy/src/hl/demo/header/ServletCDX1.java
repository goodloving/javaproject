package hl.demo.header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCDX1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//没有响应头，告知客户端去重定向到ServletCDX2
		//1.设置状态码302
		//response.setStatus(302);
		//2.设置响应头loction
		//response.setHeader("Location", "/HttpResponseStudy/ServletCDX2");
		
		//response.sendRedirect("/HttpResponseStudy/ServletCDX2");
		
		response.setHeader("refresh", "5;url=http://www.baidu.com");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
