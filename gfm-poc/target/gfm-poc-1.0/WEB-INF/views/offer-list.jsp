<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div style="margin: auto; margin-top: 10px; width: 900px; border: solid 1px silver; padding: 10px;">
	<h1>Offer list</h1>
	<table class="tblGrid">
		<tr>
			<th align="left">ID</th>
	   		<th align="left">Park</th>
	   		<th align="left">Accomodation</th>
	   		<th align="left">From</th>
	   		<th align="left">To</th>
	   		<th align="left">Price</th>
	 	</tr>
	 	
	 	<c:forEach var="record" items="${recordList}">
	 	<tr>
			<td align="left">${record.id}</td>
			<td align="left">${record.parkName}</td>
			<td align="left">${record.accommodation}</td>
			<td align="left">${record.dtFrom}</td>
			<td align="left">${record.dtTo}</td>
			<td align="left">£ ${record.price}</td>
		</tr>
		</c:forEach>	
	</table>
	
</div>
