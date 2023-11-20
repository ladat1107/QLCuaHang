package hcmute.DAO;

import java.util.List;

import javax.persistence.*;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.Category;

public class CategoryDAOimpl implements ICategoryDAO {

	@Override
	public List<Category> findALL() {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
		return query.getResultList();
	}

	@Override
	public Category findByID(int id) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		Category category = enma.find(Category.class, id);
		return category;

	}

	@Override
	public void insert(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(category);
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
	public void update(Category category) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(category);
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
			Category category = enma.find(Category.class, id);
			if (category != null) {
				enma.remove(category);
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

}
