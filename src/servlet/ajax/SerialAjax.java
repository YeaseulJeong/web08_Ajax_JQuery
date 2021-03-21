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
 * Servlet implementation class SerialAjax
 */
@WebServlet("/SerialAjax")
public class SerialAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, String> map = new HashMap<>();
	
	@Override
		public void init() throws ServletException {
		// 원래는 DB에 접속해야 하지만 여기서 임의로 DB역할을 할  Map을 만듦 
			map.put("ajax", "james");
			map.put("kim77", "gosling");
		}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doProcess(request,response);
	}
		
		protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			//1. Command 값 받아서 
			String command = request.getParameter("command");
			if(command.equals("register")) {
				String name = request.getParameter("name");    // 여기에서 name 은 form 에서의 자리 name 으로 내가 지정해준 값들 
				String addr= request.getParameter("addr");
				
				out.print(addr+" 에 사는 "+ name + " 님");     // 결과를 보여주는 success function data 쪽으로
				
			}else if (command.equals("idcheck")) {
				String id = request.getParameter("id");
				
				if(map.get(id)==null) {   // id 가 DB에 아예 없는 경우 
					out.print(false);   
				// 화면에서 받아온 값을  DB의 아이디와 비교했을 때 같으면 false boolean 값으로 넘기면 그게 boolean 값으로 안 넘어가고 String으로 인식하고 넘어간다 
				// 를 나타내고 싶은데 그러면 너무 복잡해지니까 받아온 아이디에 해당하는 값이 있다는 건 즉 이미 DB에 그 아이디가 존재한다는 걸로 해석해서 사용!
				}else {
					out.print(true);
				}
			}
		}

}
