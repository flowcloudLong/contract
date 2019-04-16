package servlet.contract;

import dao.IBaseDao;
import dao.impl.ContractDaoImpl;
import domain.Contract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/isconform")
public class IsShowconForm extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBaseDao<Contract> condao;
	@Override
	public void init() throws ServletException {
		condao = new ContractDaoImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Contract> List = condao.list();
		
		req.setAttribute("isconForm", List);
		req.getRequestDispatcher("/jsp/main.jsp").forward(req, resp);
	}
	

}
