package cn.yd.oa.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.yd.oa.model.Product;
import cn.yd.oa.service.ProductService;

// HttpServlet:可以接受Http请求信息,请求的地址:  /ProductServlet
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
	private ProductService productService = new ProductService();
  
	// 处理:method="get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	// 处理:method="post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1: 获取前端数据(java web中客户端返回的数据都被封装到request对象)
		Product product = new Product();
		product.setName(request.getParameter("name")); // <input name="name" />
		product.setRemark(request.getParameter("remark"));
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setPrice(price);
		// 2: 调用业务逻辑
		productService.save(product);
		// 3: 返回结果页面
	}

}
