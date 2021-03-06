package servlet.invo;

import dao.IBaseDao;
import dao.impl.CustomerInvoiceDaoImpl;
import domain.CustomerInvoice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/invoinfo")
public class InvoiceinfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBaseDao<CustomerInvoice> indao;
	
	@Override
	public void init() throws ServletException {
		indao = new CustomerInvoiceDaoImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CustomerInvoice> list = indao.list();
		req.setAttribute("invoiceList", list);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
	}

}
