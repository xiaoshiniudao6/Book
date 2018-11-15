<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Servlet?action=add" method="post">
		<center>增加书籍</center>
		<table border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
				<td><input type="hidden" name="userid" value="${book.userid}" />
				书名：<input type="text" name="bookName" value="${book.bookName}" /><br />
				</td>
			</tr>
			<tr>
				<td>类型：<select name="typeid">
						<c:forEach items="${listType}" var="p">
							<option  value="${p.typeid}">${p.typeName}</option>
						</c:forEach>
				</select><br />
				</td>
			</tr>
			<tr>
				<td>作者：<input type="text" name="author" value="${book.author}" /><br />
				</td>
			</tr>
			<tr>
				<td>价格：<input type="text" name="price" value="${book.price}" /><br />
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="保存" /><a href="Servlet?action=query"><input type="button"
					value="返回" /></a></td>
			</tr>
		</table>
	</form>
</body>
</html>