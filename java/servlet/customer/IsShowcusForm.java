package servlet.customer;

import dao.IBaseDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/iscusform")
public class IsShowcusForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBaseDao<Customer> cusdao;
	@Override
	public void init() throws ServletException {
		cusdao = new CustomerDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Customer> List = cusdao.list();
		
		req.setAttribute("isformList", List);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
	}

}
