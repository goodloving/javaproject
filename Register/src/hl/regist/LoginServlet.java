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
		
		//1.��ȡҳ��ĵ�½��Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.��ȡ���ݿ��е���Ϣ
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		Object[] params = {username, password};
		try {
			Map<String, Object> map = runner.query(sql, params, new MapHandler());
			//3.��Ϣ��֤���ؽ��
			if(map != null) {
				//��½�ɹ�����ת����վ��ҳ
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}else {
				//��½������ת����ǰ��½����-----�����ض���Ҳ������ת
				request.setAttribute("logininfo", "��½����");
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
