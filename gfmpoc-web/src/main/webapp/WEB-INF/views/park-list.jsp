<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>

<head>
	<title>Holidays Platform</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/img/favicon.ico" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/body.css">	
</head>

<body>
<div class="divMain adm">
	<header>
		GFM Holidays Platform<br> 
		Admin interface
	</header>
	
	<h1>Holiday parks</h1>
	<table class="tblGrid">
		<tr>
			<th align="left">ID</th>
	   		<th align="left">City</th>
	   		<th align="left">Park name</th>
	   		<th align="left">Last updated</th>
	 	</tr>
	 	
	 	<c:forEach var="record" items="${recordList}">
	 	<tr>
			<td align="left">${record.id}</td>
			<td align="left">${record.city}</td>
			<td align="left">${record.name}</td>
			<td align="left">${record.lastUpdated}</td>
		</tr>
		</c:forEach>	
	</table>
</div>
</body>

</html>

