package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.User;
public class UsersDAOImpl implements IUsersDAO{

	@Override
	public List<User> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<User> query = enma.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	@Override
	public void insert(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}

	@Override
	public void delete(int id) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			User auth = enma.find(User.class, id);
			if (auth != null) {
				enma.remove(auth);
			} else {
				throw new Exception("Không tìm thấy");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
		
	}
	@Override
	public User getOneUser(int userID) {
		EntityManager enma=JPAConfig.getEntityManager();
		User user=enma.find(User.class, userID);
		return user;
	}
	@Override
	public User login(String username, String password) {
		EntityManager enma=JPAConfig.getEntityManager();
		try {
			TypedQuery<User> query=enma.createNamedQuery("User.login", User.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public boolean checkExistUserEmail(String username) {
		EntityManager enma=JPAConfig.getEntityManager();
		String jpql="select u from User u where u.username = :username";
		TypedQuery<User> query=enma.createQuery(jpql, User.class);
		query.setParameter("username", username);
		List<User> users = query.getResultList();
	    if (!users.isEmpty()) {
	    	return true; // The email already exists in the database
	    }  
    return false;
	}
	@Override
	public void insertUser(User user) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			enma.close();
		}
	}

}
