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
		System.out.println("�˷����ڲ��Է���֮ǰִ��,ͨ��������ʼ�����Զ���");
		productDao = new ProductDao();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮��ִ��,ͨ�������ͷ���Դ");
		productDao = null;
	}

	@Test
	public void testDelete() {
		productDao.delete(2);
	}

	@Test
	public void testUpdate() {
		Product p=new Product();
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setId(1);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.update(p);
	}

	@Test
	public void testSave() {
		System.out.println("testSave......");
		Product p=new Product();
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setId(2);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.save(p);
	}

}















