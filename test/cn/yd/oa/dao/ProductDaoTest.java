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
		System.out.println("�˷����ڲ��Է���֮ǰִ��,ͨ��������ʼ�����Զ���");
		productDao = new ProductDao();
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("�˷����ڲ��Է���֮��ִ��,ͨ�������ͷ���Դ");
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
		// Ĭ�ϵ��õ���ϵͳ��toString����
//		System.out.println(product.toString());
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

	@Test  // ֻ�������ע��@Test�ķ������ǲ��Է��� 
	public void testSave() {
		System.out.println("testSave......");
		// �����ڴ�����ʱ��100%����ù��췽��
		Product p=new Product();
		String s = new String("abc");
		p.setName("��Ϊ�ֻ�");
		p.setPrice(3600.00);
		p.setRemark("��Ϊ�¿��ֻ�");
		productDao.save(p);
	}

}















