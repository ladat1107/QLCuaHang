package hcmute.services;

import java.util.List;

import hcmute.DAO.IProductDAO;
import hcmute.DAO.ProductDAOImpl;
import hcmute.entity.Category;
import hcmute.entity.Product;

public class ProductServiceImpl implements IProductService {
	IProductDAO proDAO = new ProductDAOImpl();
	
	@Override
	public List<Product> findAll() {
		return proDAO.findAll();
	}

	@Override
	public List<Product> findByCate(int cateid) {
		return proDAO.findByCate(cateid);
	}
	
	@Override
	public List<Product> find10() {
		return proDAO.find10();
	}

	@Override
	public List<Product> findsale() {
		return proDAO.findsale();
	}

	@Override
	public Product fineOne(int ProID) {
		return proDAO.findOne(ProID);
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		proDAO.insert(product);
	}

	@Override
	public void update(Product cateMd) {
		// TODO Auto-generated method stub
		proDAO.update(cateMd);
	}

	@Override
	public void delete(int cateID) throws Exception {
		// TODO Auto-generated method stub
		proDAO.delete(cateID);
	}

	@Override
	public Product getone(int proID) {
		// TODO Auto-generated method stub
		return proDAO.findOne(proID);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return proDAO.findAll();
	}


}
