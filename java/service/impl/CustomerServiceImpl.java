package service.impl;

import dao.IBaseDao;
import dao.impl.CustomerDaoImpl;
import domain.Customer;
import handle.IResultSetHandler;
import service.ICustomerService;
import template.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{

	private IBaseDao<Customer> cusdao = new CustomerDaoImpl();
	@Override
	public void save(Customer obj) {
		cusdao.save(obj);
	}

	@Override
	public void delete(Long id) {
		cusdao.delete(id);
	}

	@Override
	public void update(Customer obj) {
		cusdao.update(obj);
	}

	@Override
	public Customer get(long contId) {
		return cusdao.get(contId);
	}

	@Override
	public List<Customer> list() {
		return cusdao.list();
	}

	@Override
	public List<Customer> query(String name) {
		String baseSql = "select * from t_customer where 1=1 ";
		StringBuffer sb = new StringBuffer();
		sb.append(" and custName like ?");
		return JdbcTemplate.query(baseSql+ sb, new IResultSetHandler<List<Customer>>() {

			@Override
			public List<Customer> handler(ResultSet rs) throws SQLException {
				List<Customer> cusList = new ArrayList<Customer>();
				while(rs.next()){
					Customer cus = new Customer();
					cus.setCustId(rs.getLong("custId"));
					cus.setCustCompany(rs.getString("custCompany"));
					cus.setCustName(rs.getString("custName"));
					cus.setCustContact(rs.getString("custContact"));
					cusList.add(cus);
				}
				return cusList;
			}
			
			
		}, name);
	}
	

}
