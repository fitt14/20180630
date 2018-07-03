package cn.yd.oa.dao;

import static org.junit.Assert.*;

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

	@Test
	public void testSave() {
		System.out.println("testSave......");
		Product p=new Product();
		p.setName("华为手机");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("华为新款手机");
		productDao.save(p);
	}

}















