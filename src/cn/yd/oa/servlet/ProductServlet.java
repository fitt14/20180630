package cn.yd.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

// HttpServlet:���Խ���Http������Ϣ,����ĵ�ַ:  /ProductServlet
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
	private ProductService productService = new ProductService();
  
	// ����:method="get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	// ����:method="post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1: ��ȡǰ������(java web�пͻ��˷��ص����ݶ�����װ��request����)
		Product product = new Product();
		product.setName(request.getParameter("name")); // <input name="name" />
		product.setRemark(request.getParameter("remark"));
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setPrice(price);
		// 2: ����ҵ���߼�
		productService.save(product);
		// 3: ���ؽ��ҳ��
	}

}
