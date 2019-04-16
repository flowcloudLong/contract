package servlet;

import dao.IBaseDao;
import dao.impl.UserDaoImpl;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBaseDao udao;
	@Override
	public void init() throws ServletException {

		udao = new UserDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = ((UserDaoImpl) udao).getPassword(username);
		if(user != null){
			resp.getWriter().write("该用户已存在<a href='/jsp/register.jsp'>点击重新注册...</a>");
		}else{
			User u = new User();
			u.setUsername(username);
			u.setPassword(password);
			udao.save(u);
			resp.getWriter().write("注册成功<a href='/jsp/login.jsp'>点击登录...</a>");
		}
		
		
	}

}
