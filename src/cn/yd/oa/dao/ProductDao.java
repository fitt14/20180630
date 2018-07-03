package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao�����ݷ��ʲ�. Java��һ������ֻ��һ������(super)
public class ProductDao extends BaseDao {

	public void delete(Integer id) {
		// ?��Ϊռλ��
		String sql = "delete from product where id = ?";
		// super��ָΨһ�ĸ���
		super.executeUpdate(sql, new Object[] { id });
	}

	// ��дһ������,������ݵĲ������
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		super.executeUpdate(sql,
				new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() });
	}

	// ��дһ������,������ݵĲ������
	public void save(Product product) {
		// ?��Ϊռλ��
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
