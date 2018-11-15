<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="index.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <a href="addBook.jsp"><input type="button" value="增加书籍"/></a>
  <table border="1" align="center" cellpadding="0" cellspacing="0">
		<caption></caption>
		<tr>
			<td>书名</td>
			<td>类型</td>
			<td>作者</td>
			<td>价格</td>
			<td>修改</td>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.bookName}</td>
				<td>${p.bookType.typeName}</td>
				<td>${p.author}</td>
				<td>${p.price}</td>
				<td><a href="Servlet?action=get&id=${p.id}">修改</a>
				</td>
			    </tr>
		</c:forEach>
	</table>

</body>
</html>