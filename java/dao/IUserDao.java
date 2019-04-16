package dao;

import domain.User;

import java.util.List;

public interface IUserDao {
	//增删改查
	void save(User user);
			
	void delete(Long userId);

	void update(User user);

	User get(long userid);
	
	User getPassword(String username);

	List<User> list();

}
