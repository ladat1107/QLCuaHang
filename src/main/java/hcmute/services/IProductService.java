package hcmute.services;

import java.util.List;

import hcmute.entity.Category;
import hcmute.entity.Product;

public interface IProductService {
	List<Product> findAll();
	
	List<Product> findByCate(int cateid);
	
	List<Product> find10();
	
	List<Product> findsale();
	
	Product fineOne(int ProID);
	void insert(Product product); 
	void update(Product cateMd);
	void delete(int cateID) throws Exception;

	Product getone(int proID);

	List<Product> findAllProduct();
}
