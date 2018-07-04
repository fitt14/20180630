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

// HttpServlet:可以接受Http请求信息,请求的地址:  /ProductServlet
// @WebServlet("/ProductServlet") // 也可以把访问地址配置web.xml中
public class ProductServlet extends HttpServlet {
	
	// JSP --> Servlet --> Service ---> Dao ---> DB
	private ProductService productService = new ProductService();
  
	// 处理:method="get"
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1: 获取前端输入查询关键字
		String keyword = request.getParameter("keyword");
		// 2: 调用业务逻辑
		ArrayList<Product> proList = productService.queryByName(keyword);
		System.out.println(proList.size());
		// 此数据要交给query.jsp页面显示
		request.setAttribute("proList", proList);
		HttpSession session = request.getSession();
		session.setAttribute("proList",proList);
		// 当前页面跳转到query.jsp
		response.sendRedirect("/20180630/query.jsp");
		// json
	}
	// 处理:method="post"
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("request:" + request);
		System.out.println("response:" + response);
		// 1: 获取前端数据(java web中客户端返回的数据都被封装到request对象)
		Product product = new Product();
		product.setName(request.getParameter("name")); // <input name="name" />
		product.setRemark(request.getParameter("remark"));
		Double price = Double.parseDouble(request.getParameter("price"));
		product.setPrice(price);
		// 2: 调用业务逻辑
		productService.save(product);
		// 3: 跳转到查询页面,在Java开发中所有的资源访问都要从工程名开始(query.jsp)
		response.sendRedirect("/20180630/query.jsp");
	}

}
