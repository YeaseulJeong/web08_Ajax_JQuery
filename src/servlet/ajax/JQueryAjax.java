package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjax
 */
@WebServlet("/JQueryAjax")
public class JQueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성     web07에서는 DispatcherServlet 의 역할 
    	// 1. JQuery에서 넘어온 값 받아서
    	// 2. 다시 화면으로 보냄
    	
    	String id = request.getParameter("id");   // 앞의 data: "id="+id+"&pass="+pass 에서의 id, pass 와 같아야 
		String pw = request.getParameter("pass");
		
		PrintWriter out = response.getWriter();
		out.print("id "+ id + " pass "+ pw);
    	
    	
	}

}
