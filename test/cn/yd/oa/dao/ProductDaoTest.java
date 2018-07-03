package cn.yd.oa.dao;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.yd.oa.model.Product;

public class ProductDaoTest {
	
	private static ProductDao productDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("此方法在测试方法之前执行,通常用来初始化测试对象");
		productDao = new ProductDao();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("此方法在测试方法之后执行,通常用来释放资源");
		productDao = null;
	}
	
	
	@Test
	public void testAAA() {
		ArrayList<Product> proList = productDao.queryByName("%%");
//		for(int i=0;i<proList.size();i++) {
//			
//		}
		for(Product temp:proList) {
			System.out.println(temp.toString());
		}
	}
	
	@Test
	public void testGetById() {
		Product product = productDao.getById(2);
		if(product!=null) {
			System.out.println(product.getId() + "," + product.getName());
		}
		// 默认调用的是系统的toString方法
//		System.out.println(product.toString());
	}
	
	@Test
	public void testDelete() {
		productDao.delete(2);
	}
	
	@Test
	public void testUpdate() {
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setId(1);
		p.setRemark("华为新款手机");
		productDao.update(p);
	}

	@Test  // 只有添加了注解@Test的方法才是测试方法 
	public void testSave() {
		System.out.println("testSave......");
		// 对象在创建的时候100%会调用构造方法
		Product p=new Product();
		String s = new String("abc");
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setRemark("华为新款手机");
		productDao.save(p);
	}

}















