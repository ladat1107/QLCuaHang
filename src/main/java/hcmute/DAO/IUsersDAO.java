package hcmute.DAO;

import java.util.List;

import hcmute.entity.User;

public interface IUsersDAO {
	List<User> findAll();
	void insert(User user);
	void update(User user);
	void delete(int id) throws Exception;
	User getOneUser(int userID);
	User login(String email, String password);
	boolean checkExistUserEmail(String email);
	void insertUser(User user);
}
