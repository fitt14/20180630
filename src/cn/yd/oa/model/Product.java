package cn.yd.oa.model;

import java.util.Date;

// 类-->表   对象-->记录   属性 ---> 字段
public class Product {
	
	// 与类同名的方法称为构造方法(函数),默认有一个缺省无参构造方法
//	public Product() {  // alt + <-
//		System.out.println("........");
//	}
	
	// 如果显示声明构造方法,则缺省构造会消失
//	public Product(Integer id, String name, Double price, String remark, Date date) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.remark = remark;
//		this.date = date;
//	}
	
	
    // 属性是私有的,不能直接访问.
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
