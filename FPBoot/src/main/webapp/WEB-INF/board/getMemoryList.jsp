<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<% System.out.println("jsp"); %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 목록</title>
</head>
<body>
<center>

<h3>게시글 목록</h3>

<br><hr><br>

<table border="1" width="700">
<tr>
	<th width="100">시리얼</th>
	<th width="200">제조사</th>
	<th width="150">제품명</th>
	<th width="150">128</th>
	<th width="150">256</th>
	<th width="150">512</th>
	<th width="150">64</th>
</tr>
 
<c:forEach var="memory" items="${memoryList}">
	<tr>
		<td>${memory.sn}</td>
		<td align="left"><a href="getMemory?sn=${memory.sn}">${memory.brand}</a></td>
		<td>${memory.mcName}</td>		
		<td>${memory.price128GB}</td>		
		<td>${memory.price256GB}</td>		
		<td>${memory.price512GB}</td>		
		<td>${memory.price64GB}</td>		
	</tr>
</c:forEach>

</table>
<br>
<a href="insertBoard.html">게시글 등록</a>
</center>
</body>
</html>