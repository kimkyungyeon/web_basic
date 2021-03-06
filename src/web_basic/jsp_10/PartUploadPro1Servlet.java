package web_basic.jsp_10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/jsp_10/partUploadPro1")
@MultipartConfig(fileSizeThreshold=0, location = "D:/upload")
public class PartUploadPro1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String writer = request.getParameter("writer");
		Part part = request.getPart("partFile1");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String contentDisposition = part.getHeader("content-disposition");
		String uploadFileName = getUploadFileName(contentDisposition);
		part.write(uploadFileName);
		out.println("작성자 " + writer + "님이 " + uploadFileName + "파일을 업로드 하였습니다. (" +part.getSize()/1000+"KB)" );
	}



	private String getUploadFileName(String contentDisposition) {
		String uploadFileName = null;
		String[] contentSplitStr = contentDisposition.split(";");
		int firstQutosIndex = contentSplitStr[2].indexOf("\"");
		int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
		uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
		return uploadFileName;
	}

}
