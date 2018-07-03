package cn.yd.oa.service;

import cn.yd.oa.dao.ProductDao;
import cn.yd.oa.model.Product;

// 此类主要是用来实现业务逻辑
public class ProductService {

	// 业务逻辑完成功能之后数据将入库,因此此类依赖ProductDao
	private ProductDao productDao = new ProductDao();
	
	public void save(Product product) {
		// 此处用来实现业务逻辑代码
		productDao.save(product);
	}
}
