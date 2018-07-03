package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yd.oa.model.Product;
import cn.yd.oa.utils.JdbcUtils;

// dao�����ݷ��ʲ�. Java��һ������ֻ��һ������(super)
public class ProductDao extends BaseDao {

	// ctrl + shift +o ���뵼����
	public ArrayList<Product> queryByName(String name){
		ArrayList<Product> proList = new ArrayList<Product>();
		String sql="select * from product where name like ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: �����ִ��SQL���
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setString(1, "%" + name + "%");
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
			   Product product = new Product();
				// db��һ����¼����Java�е�һ������
				product.setId(rs.getInt("id")); // ��ȡid������,����int��ʽ����
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
				// �Ѳ�ѯ�����Ķ���洢��������
				proList.add(product);
			}
			// 3: ���ز�ѯ�Ľ����
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
	
	// ��дһ������ID��ѯ����ķ���
	public Product getById(Integer id) {
		Product product= null;
		String sql="select * from product where id = ?";
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		// 2: �����ִ��SQL���
		PreparedStatement pre;
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, id);
//			int count = pre.executeUpdate();
			// ResultSet: ��ѯ�����,Java�в�ѯ�Ľ��������ResultSet������
			ResultSet rs = pre.executeQuery();
			// rs�������ָ���䵱ǰ�����еĹ�ꡣ�������걻���ڵ�һ��֮ǰ��
			// next ����������ƶ�����һ��,�����ǰ����Ч�򷵻�Ϊtrue
			if(rs.next()) {
			    product = new Product();
				// db��һ����¼����Java�е�һ������
				product.setId(rs.getInt("id")); // ��ȡid������,����int��ʽ����
				product.setName(rs.getString("name"));
				product.setDate(rs.getDate("date"));
				product.setPrice(rs.getDouble("price"));
				product.setRemark(rs.getString("remark"));
			}
			// 3: ���ز�ѯ�Ľ����
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
		// ?��Ϊռλ��
		String sql = "delete from product where id = ?";
		// super��ָΨһ�ĸ���
		super.executeUpdate(sql, new Object[] { id });
	}

	// ��дһ������,������ݵĲ������
	public void update(Product product) {
		String sql = "update product set name=?,price=?,remark=? where id = ?";
		Object[] param = new Object[] { product.getName(), product.getPrice(), product.getRemark(), product.getId() };
		super.executeUpdate(sql,param);
	}

	// ��дһ������,������ݵĲ������
	public void save(Product product) {
		// ?��Ϊռλ��
		String sql = "insert into product (name,price,remark) values (?,?,?)";
		super.executeUpdate(sql, new Object[] { product.getName(), product.getPrice(), product.getRemark() });
	}
}
