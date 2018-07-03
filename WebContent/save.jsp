<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
   <!-- 发送的是http请求,ProductService是不能够识别,需要一个中介Servlet -->
   <!-- 在项目中所有的请求都要从工程名开始,请修改成自己工程名 -->
   <form action="/java0630/ProductServlet" method="post">
      <!--  ctrl + atl + 下方向键 -->
           商品名:<input type="text" name="name" /><br/>
            价格:<input type="text" name="price" /><br/>
            备注:<input type="text" name="remark" /><br/>
       <input type="submit" value="提交" />
   </form>
</body>
</html>