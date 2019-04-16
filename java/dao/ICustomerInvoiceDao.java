package dao;

import domain.CustomerInvoice;

import java.util.List;


public interface ICustomerInvoiceDao {
	
	//增删改查
	void save(CustomerInvoice invo);
			
	void delete(Long invoId);

	void update(CustomerInvoice invo);

	CustomerInvoice get(long invoid);

	List<CustomerInvoice> list();

}
