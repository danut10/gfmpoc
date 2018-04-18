<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div style="margin: auto; margin-top: 10px; width: 900px; border: solid 1px silver; padding: 10px;">
	<h1>Park list</h1>
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
