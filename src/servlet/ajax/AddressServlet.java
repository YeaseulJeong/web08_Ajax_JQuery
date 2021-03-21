package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressServlet
 */
@WebServlet("/AddressServlet")
public class AddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, String> map;  // 전역변수로 선언 
	
	// WAS가 작동되면  DD대로 Servlet WAS가 알아서 만들고 Servlet들의  ~~~
	// 1. 생성자 호출 됨   
	// 클라이언트 요청 전
	public AddressServlet() {
		map = new HashMap<String, String>();
	}
	
	
	// 2. init() 실행됨 
	// 클라이언트 요청 전
	// DB를 연결하는 대신에 Map 을 생성, 각 선수들의 주소를 매핑 시킨다 
	@Override
	public void init() throws ServletException {
		map.put("Son", "A");
		map.put("Ahn", "B");
		map.put("Park", "C");
		map.put("Messi", "D");
		map.put("Lee", "E");
		map.put("Hwang", "F");
	}

	
	// 3. doGet/ doPost 가 실행됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	// 3. doGet/ doPost 가 실행됨
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	// Jquery 에서 비동기로 요청이 들어왔을 때 실행된다  
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성 
	/*
	 * 1. jquery에서 선택한 폼값 받아온다 _ 메시/ 안정환 ...
	 * (2. DAO 받아와서 비즈니스 로직에 이름 넣고 이름에 사는 사는 곳을 리턴 받는다)
	 * 3. 
	 */
		
		String player= request.getParameter("player");
		String address = map.get(player);
		
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
 		out.print("사는 곳은: "+address+ "");  
	}

}
