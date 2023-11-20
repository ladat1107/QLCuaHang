package hcmute.services;

import java.util.List;

import hcmute.DAO.IUsersDAO;
import hcmute.DAO.UsersDAOImpl;
import hcmute.entity.User;



public class UsersServiceImpl implements IUsersService{
	IUsersDAO userDao=new UsersDAOImpl();
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public void insert(User user) {
		userDao.insert(user);
		
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		
	}

	@Override
	public void delete(int id) throws Exception {
		userDao.delete(id);
		
	}
	@Override
	public User getOneUser(int userID) {
		return userDao.getOneUser(userID);
	}

	@Override
	public User login(String username, String password) {
		return userDao.login(username, password);
	}

	@Override
	public boolean checkExistUserEmail(String email) {
		return userDao.checkExistUserEmail(email);
	}

	@Override
	public boolean register(String email, String fullName, String password) {
		if(userDao.checkExistUserEmail(email)) {
			return false;
		}
		//userDao.insert(new User(email,fullName,password));
		return true;
	}

}
