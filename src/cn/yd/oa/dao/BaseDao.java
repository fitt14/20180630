package cn.yd.oa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.yd.oa.utils.JdbcUtils;

// ctrl + / עጴ��a    ctrl + shift + F ��ʽ������
// ���������洢�������ݿ⹲�Դ���,��Щ���붼��Ҫ�̳и�����
public class BaseDao {
	// �������ɾ�����޸�����,������Ϊ����
	public void executeUpdate(String sql,Object[] param) {
		// 1: �������ݿ�
		JdbcUtils utils = new JdbcUtils();
		Connection conn = utils.getConnection();
		try {
			// 2: Ԥ����SQL(�˴���δ����ִ��SQL,��Ϊ���в���δ��ֵ)
			// ctrl + shift + o ���Ե��뵼����
			PreparedStatement pre = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++) {
				pre.setObject(i+1, param[i]);
			}
			int count = pre.executeUpdate();
			System.out.println("count:" + count);
		} catch (SQLException e) {
			// ���Դ����쳣: �����쳣������Ա����
			// ֱ�Ӱѵ�ǰ�쳣�����׳�
			throw new RuntimeException(e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		// 5: �ر�Connection�ͷ���Դ
	}

}
