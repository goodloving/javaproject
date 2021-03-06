package hl.demo.download;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class downloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filename = request.getParameter("filename");
		
		//告诉客户端要下载的这个文件的类型-----客户端通过文件的MIME类型区分类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		
		//告诉客户端该文件不是直接解析 而是以附件形式打开----下载
		response.setHeader("Content-Disposition", "attachment;filename="+filename);
		
		String realPath = this.getServletContext().getRealPath("download/"+filename);
		InputStream in = new FileInputStream(realPath);
		
		//获得输出流-----通过response获得输出流用于向客户端写内容
		ServletOutputStream out = response.getOutputStream();
		
		int len = 0;
		byte[] buffer = new byte[1024];
		while(((len=in.read(buffer))>0)) {
			out.write(buffer, 0, len);
		}
		
		in.close();
		//out.close();
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
