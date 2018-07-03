package cn.yd.oa.service;

import java.util.ArrayList;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

// ������Ҫ������ʵ��ҵ���߼�
public class ProductService {

	// ҵ���߼���ɹ���֮�����ݽ����,��˴�������ProductDao
	private ProductDao productDao = new ProductDao();
	
	public void save(Product product) {
		// �˴�����ʵ��ҵ���߼�����
		productDao.save(product);
	}
	
	public ArrayList<Product> queryByName(String keyword){
		return productDao.queryByName(keyword);
	}
}
