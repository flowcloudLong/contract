package dao;


import domain.Contract;

import java.util.List;


public interface IContractDao {
	
	//增删改查
	void save(Contract cont);
	
	void delete(Long id);

	void update(Contract cont);

	Contract get(long contId);

	List<Contract> list();

}
