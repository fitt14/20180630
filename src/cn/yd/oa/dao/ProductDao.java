package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao是数据访问层. Java中一个子类只有一个父类(super)
public class ProductDao extends BaseDao {

	public void delete(Integer id) {
		// ?称为占位符
		String sql = "delete from product where id = ?";
		// super代指唯一的父类
		super.executeUpdate(sql, new Object[] { id });
	}

	// 编写一个方法,完成数据的插入操作
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// 编写一个方法,完成数据的插入操作
	public void save(Product product) {
		// ?称为占位符
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
