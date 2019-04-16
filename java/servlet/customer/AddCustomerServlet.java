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

@WebServlet("/cusadd")
public class AddCustomerServlet extends HttpServlet{

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
		String company = req.getParameter("custcompany");
		String name = req.getParameter("custname");
		String contact = req.getParameter("custcontact");
		Customer c = new Customer();
		c.setCustCompany(company);
		c.setCustName(name);
		c.setCustContact(contact);
		cusdao.save(c);
		List<Customer> List = cusdao.list();
		req.setAttribute("customerList", List);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);	
		
		
	}
}
