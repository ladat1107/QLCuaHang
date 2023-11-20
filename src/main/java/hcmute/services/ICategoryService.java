package hcmute.services;

import java.util.List;

import hcmute.entity.Category;

public interface ICategoryService {
	List<Category> findALL();
	
	void insert(Category model); 
	
	Category findOne(int id);
	
	void update(Category model);
	
	void delete(int id);

	Category getone(int cateID);
}
