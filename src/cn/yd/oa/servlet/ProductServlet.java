package cn.yd.oa.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

// HttpServlet:���Խ���Http������Ϣ,����ĵ�ַ:  /ProductServlet
// @WebServlet("/ProductServlet") // Ҳ���԰ѷ��ʵ�ַ����web.xml��
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
	private ProductService productService = new ProductService();
  
	// ����:method="get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1: ��ȡǰ�������ѯ�ؼ���
		String keyword = request.getParameter("keyword");
		// 2: ����ҵ���߼�
		ArrayList<Product> proList = productService.queryByName(keyword);
		System.out.println(proList.size());
		// ������Ҫ����query.jspҳ����ʾ
		request.setAttribute("proList", proList);
		HttpSession session = request.getSession();
		session.setAttribute("proList",proList);
		// ��ǰҳ����ת��query.jsp
		response.sendRedirect("/20180630/query.jsp");
		// json
	}
	// ����:method="post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request:" + request);
		System.out.println("response:" + response);
		// 1: ��ȡǰ������(java web�пͻ��˷��ص����ݶ�����װ��request����)
		Product product = new Product();
		product.setName(request.getParameter("name")); // <input name="name" />
		product.setRemark(request.getParameter("remark"));
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setPrice(price);
		// 2: ����ҵ���߼�
		productService.save(product);
		// 3: ��ת����ѯҳ��,��Java���������е���Դ���ʶ�Ҫ�ӹ�������ʼ(query.jsp)
		response.sendRedirect("/20180630/query.jsp");
	}

}
