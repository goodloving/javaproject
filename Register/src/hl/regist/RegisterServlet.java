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
		//����request�ı����ֹ����------ֻ�ʺ�  post ��ʽ
		request.setCharacterEncoding("UTF-8");
		
		//get��ʽ������������    ����iso8859-1���룬����utf-8����
//		String username = request.getParameter("user");
//		username = new String(username.getBytes("iso8859-1"),"UTF-8");
		
		//1.��ȡ����
//		String username = request.getParameter("user");
//		String password = request.getParameter("psw");
//		String tel = request.getParameter("tel");
//		String email = request.getParameter("email");
//		String name = request.getParameter("name");
//		String sex = request.getParameter("gender");
//		String birthday = request.getParameter("date");
//		
//		//2.�����ݷ�װΪjavaBean------User
//		User user = new User();
//		user.setUsername(username);
//		user.setPassword(password);
//		user.setTel(tel);
//		user.setEmail(email);
//		user.setName(name);
//		user.setSex(sex);
//		user.setBirthday(birthday);
		
		//����1��2���������ܽ�Ϊһ������BeanUtils���ȵ���
		User user =new User();
		Map<String, String[]> parameterMap = request.getParameterMap();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.���������ݸ�һ��ҵ������ķ���
		try {
			regist(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//4.ע��ɹ���ת����½����------------ת�����ã��������ض���
		//request.getRequestDispatcher("/login.html").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/login.jsp");
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//ע��ķ���
	public void regist(User user) throws SQLException {
		//�������ݿ�
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		user.setUid(UUID.randomUUID().toString());
		runner.update(sql, user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTel(),user.getBirthday(),user.getSex(),null,null);
	}
	
}
