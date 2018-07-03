package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao是数据访问层. Java中一个子类只有一个父类(super)
public class ProductDao extends BaseDao {

	// ctrl + shift +o 导入导出包
	public ArrayList<Product> queryByName(String name){
		ArrayList<Product> proList = new ArrayList<Product>();
		String sql="select * from product where name like ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: 编译和执行SQL语句
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, "%" + name + "%");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
			   Product product = new Product();
				// db中一条记录等于Java中的一个对象
				product.setId(rs.getInt("id")); // 获取id列数据,并且int方式返回
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				// 把查询出来的对象存储到集合中
				proList.add(product);
			}
			// 3: 返回查询的结果集
			return proList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	
	}
	
	// 编写一个根据ID查询对象的方法
	public Product getById(Integer id) {
		Product product= null;
		String sql="select * from product where id = ?";
		// 1: 连接数据库
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: 编译和执行SQL语句
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
//			int count = pre.executeUpdate();
			// ResultSet: 查询结果集,Java中查询的结果保存在ResultSet对象中
			ResultSet rs = pre.executeQuery();
			// rs对象具有指向其当前数据行的光标。最初，光标被置于第一行之前。
			// next 方法将光标移动到下一行,如果当前行有效则返回为true
			if(rs.next()) {
			    product = new Product();
				// db中一条记录等于Java中的一个对象
				product.setId(rs.getInt("id")); // 获取id列数据,并且int方式返回
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
			// 3: 返回查询的结果集
			return product;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void delete(Integer id) {
		// ?称为占位符
		String sql = "delete from product where id = ?";
		// super代指唯一的父类
		super.executeUpdate(sql, new Object[] { id });
	}

	// 编写一个方法,完成数据的插入操作
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		Object[] param = new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() };
		super.executeUpdate(sql,param);
	}

	// 编写一个方法,完成数据的插入操作
	public void save(Product product) {
		// ?称为占位符
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
