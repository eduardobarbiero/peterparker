<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tickets</title>
</head>
<body>

	<div class="container">
		<div class="col-xs-10 col-md-10" style="padding-left:20%">
			<table class="table table-hover">
				<tr>
					<th>Ticket Id</th>
					<th>Placa</th>
					<th>Cor</th>
					<th>Dispositivo Entrada</th>
					<th>Dispositivo Saida</th>
					<th>Hora entrada</th>
					<th>Hora saida</th>
				</tr>
				
				<c:forEach items="${tickets}" var="ticket" >
					<tr>
						<td>${ticket.id}</td>
						<td>${ticket.car.board}</td>
						<td>${ticket.car.color}</td>
						<td>${ticket.dispositivoEntrada.id}</td>
						<c:if test="${ticket.dispositivoSaida.id != null}">
							<td>${ticket.dispositivoSaida.id}</td>
	            		</c:if>
	            		<c:if test="${ticket.dispositivoSaida.id == null}">
							<td>N/A</td>
	            		</c:if>
						
						<td>
							<fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${ticket.horaEntrada.time}" />
	            		</td>
	            		
	            		<c:if test="${ticket.horaSaida.time != null}">
		            		<td>
								<fmt:formatDate type="both" dateStyle="short" timeStyle="short"  value="${ticket.horaSaida.time}" />
		            		</td>
	            		</c:if>
	            		<c:if test="${ticket.horaSaida.time == null}">
		            		<td>
								N/A
		            		</td>
	            		</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>
</html>