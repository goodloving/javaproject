package hl.regist;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置request的编码防止乱码------只适合  post 方式
		request.setCharacterEncoding("UTF-8");
		
		//get方式的乱码解决方法    先用iso8859-1编码，再用utf-8解码
//		String username = request.getParameter("user");
//		username = new String(username.getBytes("iso8859-1"),"UTF-8");
		
		//1.获取数据
//		String username = request.getParameter("user");
//		String password = request.getParameter("psw");
//		String tel = request.getParameter("tel");
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String sex = request.getParameter("gender");
//		String birthday = request.getParameter("date");
//		
//		//2.将数据封装为javaBean------User
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setTel(tel);
//		user.setEmail(email);
//		user.setName(name);
//		user.setSex(sex);
//		user.setBirthday(birthday);
		
		//其中1，2两步可以总结为一步，用BeanUtils。先导包
		User user =new User();
		Map<String, String[]> parameterMap = request.getParameterMap();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.将参数传递给一个业务操作的方法
		try {
			regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4.注册成功跳转到登陆界面------------转发不好，决定用重定向
		//request.getRequestDispatcher("/login.html").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//注册的方法
	public void regist(User user) throws SQLException {
		//操作数据库
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		user.setUid(UUID.randomUUID().toString());
		runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTel(),user.getBirthday(),user.getSex(),null,null);
	}
	
}
