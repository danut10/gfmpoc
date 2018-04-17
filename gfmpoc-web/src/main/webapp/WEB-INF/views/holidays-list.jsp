<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div style="margin: auto; margin-top: 10px; width: 900px; border: solid 1px silver; padding: 10px;">
	<h1>Holiday list</h1>
	<table class="tblGrid">
		<tr>
			<th align="left">ID</th>
	   		<th align="left">Name</th>
	 	</tr>
	 	
	 	<c:forEach var="holiday" items="${recordList}">
	 	<tr>
			<td align="left">${holiday.id}</a></td>
			<td align="left">${holiday.name}</a></td>
		</tr>
		</c:forEach>	
	</table>
	
</div>
