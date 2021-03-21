package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JQueryAjax2
 */
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count =0;
	
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
    	
    	 count ++;

 		PrintWriter out = response.getWriter();
 		
 		// 로직을 추가..
 		try {
			Thread.sleep(000);   // 1초동안 멈춰 있는데 cpu 에서 blocking    고의로 응답을 지연시킨 것     error:function() 이쪽으로 날라간다 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
 		
 		out.print(count);  // resultData 증가된 값이 html파일의 success:function() 이쪽으로 날라간다 . 결과 페이지가 있는게 아니라 
    	
    	
	}

}
