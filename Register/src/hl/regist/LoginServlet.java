package hl.regist;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.获取页面的登陆信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.获取数据库中的信息
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		Object[] params = {username, password};
		try {
			Map<String, Object> map = runner.query(sql, params, new MapHandler());
			//3.信息验证返回结果
			if(map != null) {
				//登陆成功，跳转到网站首页
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else {
				//登陆错误，跳转到当前登陆界面-----可以重定向也可以跳转
				request.setAttribute("logininfo", "登陆错误");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
