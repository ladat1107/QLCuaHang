package hcmute.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import hcmute.JPAConfig.JPAConfig;
import hcmute.entity.Category;
import hcmute.entity.Product;

public class ProductDAOImpl implements IProductDAO {
	
	EntityManager enma = JPAConfig.getEntityManager();
	EntityTransaction trans = enma.getTransaction();
	
	@Override
	public List<Product> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Product> query = enma.createNamedQuery("Product.findAll", Product.class);
		return query.getResultList();
	}

	@Override
	public List<Product> findByCate(int categoryid) {
		
		Category category = enma.find(Category.class, categoryid);
		return category.getProducts();
		
		
	}
	
	@Override
	public List<Product> find10() {
		TypedQuery<Product> query= enma.createNamedQuery("Product.findAll", Product.class);
		query.setFirstResult(1);
		query.setMaxResults(10);
		return query.getResultList();
	}

	@Override
	public List<Product> findsale() {
		TypedQuery<Product> query= enma.createNamedQuery("Product.findAll", Product.class);
		query.setFirstResult(1);
		query.setMaxResults(10);
		return query.getResultList();
	}

	@Override
	public Product findOne(int ProID) {
		Product product = enma.find(Product.class, ProID);
		return product;
	}
	@Override
	public void insert(Product prodMd) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.persist(prodMd); 
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Product prodMd) {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			enma.merge(prodMd); 
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			enma.close();
		}
	}

	@Override
	public void delete(int prodID) throws Exception {
		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();
			Product author = enma.find(Product.class, prodID);
			if (author != null) {
				enma.remove(author);
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
