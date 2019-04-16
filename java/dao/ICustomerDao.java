package dao;

import domain.Customer;

import java.util.List;


public interface ICustomerDao {
	//增删改查
		void save(Customer cus);
		
		void delete(Long cusid);

		void update(Customer cus);

		Customer get(long cusid);

		List<Customer> list();

}
