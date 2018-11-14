package hl.demo.header;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date date = new Date();
		
		response.addHeader("name", "zhangsan");
		response.addIntHeader("age", 28);
		response.addDateHeader("birthday", date.getTime());
		
		response.addHeader("name", "lisi");
		
		response.setIntHeader("age", 50);
		response.setHeader("name", "wangwu");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}