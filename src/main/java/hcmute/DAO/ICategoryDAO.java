package hcmute.DAO;

import java.util.List;

import hcmute.entity.Category;

public interface ICategoryDAO {
	// dinh nghia cac phuong thuc
	List<Category> findALL();
	
	void insert(Category category); 
	
	Category findByID(int id);
	
	void update(Category category);
	
	void delete(int id) throws Exception ;
}
