package hcmute.services;

import java.util.List;

import hcmute.DAO.CategoryDAOimpl;
import hcmute.DAO.ICategoryDAO;
import hcmute.entity.Category;

public class CategoryServiceImpl implements ICategoryService {
	//goi cac phuong thuc trong DAO
	ICategoryDAO cateDAO = new CategoryDAOimpl();
	
	@Override
	public List<Category> findALL() {
		//xu ly logic
		//goi va truyen cho DAO
		return cateDAO.findALL();
	}

	@Override
	public void insert(Category model) {	
		cateDAO.insert(model);
	}

	@Override
	public Category findOne(int id) {
		return cateDAO.findByID(id);
	}

	@Override
	public void update(Category model) {
		Category oldcate = cateDAO.findByID(model.getCategoryID());
		oldcate.setCategoryName(model.getCategoryName());
		oldcate.setIcon(model.getIcon());
		cateDAO.update(model);
		
	}

	@Override
	public void delete(int id) {
		try {
		cateDAO.delete(id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Category getone(int cateID) {
		// TODO Auto-generated method stub
		return cateDAO.findByID(cateID);
	}
}
