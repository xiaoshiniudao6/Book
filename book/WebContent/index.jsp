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
	<form action="Servlet?action=query" method="post">
		类型<select name="typeid">
				<option value="" selected="selected">全部</option>
			<c:forEach items="${sessionScope.listType}" var="p">
				<option value="${p.typeid}">${p.typeName}</option>
			</c:forEach>
		</select> <input type="submit" value="查询" /><br>
	</form>
</body>
</html>