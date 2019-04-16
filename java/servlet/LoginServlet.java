package servlet;

import dao.impl.UserDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDaoImpl udao;
	@Override
	public void init() throws ServletException {

	
		udao = new UserDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("有人访问");
		String username = req.getParameter("username");
//		username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
		String password = req.getParameter("password");
//		System.out.println(username + "  " + password);
//		resp.getWriter().write("你好");
		
		
		if(username == null || "".equals(username)){
			resp.getWriter().write("请输入用户名和密码. <a href='/jsp/login.jsp'>点击重新登录...</a>");
		}else{
//				if(udao.getPassword(username) == null){
//					resp.getWriter().write("没有此用户. <a href='/cms01/jsp/login.jsp'>点击重新登录...</a>");
//
//				}else if(udao.getPassword(username).getPassword().equals(password)){
				if(username.equals("123")){
					HttpSession session = req.getSession();
					User u = new User();
					u.setUsername(username);
					session.setAttribute("USER_IN_SESSION", u);
					req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
				}else{
					
					resp.getWriter().write("密码错误. <a href='/jsp/login.jsp'>点击重新登录...</a>");
					
		}
		
		
	}
}
}
