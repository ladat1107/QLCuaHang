package hcmute.DAO;

import java.util.List;

import hcmute.entity.Product;

public interface IProductDAO {
	List<Product> findAll();
	
	List<Product> findByCate(int cateid);
	
	List<Product> find10();
	
	List<Product> findsale();
	
	Product findOne(int ProID);

	void delete(int prodID) throws Exception;

	void update(Product prodMd);

	void insert(Product prodMd);
}
