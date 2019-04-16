package service;

import dao.IBaseDao;
import domain.Customer;

import java.util.List;

public interface ICustomerService extends IBaseDao<Customer>{

	public List<Customer> query(String name); 
}
