package servlet.expire;

import domain.Contract;
import query.ExpireQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/expirethree")
public class ExpirethreeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ExpireQuery eq =new ExpireQuery();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contract> list = eq.Expirequery(0,3);
		
		for (Contract con : list) {
			System.out.println(con);
			
		}
		req.setAttribute("expiredays", list);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
	}

}
