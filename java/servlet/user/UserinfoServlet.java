package servlet.user;

import domain.User;
import query.UserinfoQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/userinfo")
public class UserinfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserinfoQuery uq = new UserinfoQuery();
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		User user =  (User) session.getAttribute("USER_IN_SESSION");
		System.out.println(user);
		User u = uq.get(user.getUsername());
		req.setAttribute("userinfo", u);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
	}
	

}
