package cn.yd.oa.model;

import java.util.Date;

// ��-->��   ����-->��¼   ���� ---> �ֶ�
public class Product {
	
	// ����ͬ���ķ�����Ϊ���췽��(����),Ĭ����һ��ȱʡ�޲ι��췽��
//	public Product() {  // alt + <-
//		System.out.println("........");
//	}
	
	// �����ʾ�������췽��,��ȱʡ�������ʧ
//	public Product(Integer id, String name, Double price, String remark, Date date) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.remark = remark;
//		this.date = date;
//	}
	
	
    // ������˽�е�,����ֱ�ӷ���.
	private Integer id;
	
	private String name;
	private Double price;
	private String remark;
	private Date date;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
