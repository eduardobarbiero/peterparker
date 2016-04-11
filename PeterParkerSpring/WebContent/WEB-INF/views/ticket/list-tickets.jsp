<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Lista de tickets</title>
		
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
	</head>
	<body>
		<div class="ui fixed inverted menu">
			<div class="ui container">
				<a href="#" class="header item">Peter Parker</a> 
				<a href="/PeterParkerSpring/device" class="item">Dispositivo</a> 
				<a href="/PeterParkerSpring/car" class="item">Carro</a> 
				<a href="/PeterParkerSpring/ticket" class="item active">Ticket</a>
			</div>
		</div>
		<div class="ui main text container" style="padding-top: 80px">
			<h2>Entrada</h2>
			<table class="ui blue celled table">
				<thead>
					<tr>
						<th>Identificação</th>
						<th>Placa do carro</th>
						<th>Hora de entrada</th>
						<th>Dispositivo de entrada</th>
						<th>Sair</th>
					</tr>
				</thead>
				<c:if test="${fn:length(tickets) > 0}">
					<tbody>
						<c:forEach items="${tickets}" var="ticket" >
							<tr>
								<td>${ticket.id}</td>
								<td>${ticket.carro.placa}</td>
								<td>
									<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${ticket.horaEntrada.time}" />
								</td>		            		
								<td>${ticket.dispositivoEntrada.id}</td>
								<td>
									<form class="ui form" method="POST" action="alteraTicket?id=${ticket.id}">
										<select id="dispositivoId" class="form-control" name="dispositivoSaida.id" >
										  <c:forEach items="${devices}" var="device">
										    <option value="${device.id}">
										        ${device.localizacao}
										    </option>
										  </c:forEach>
										</select>
										<input type="submit" value="Saiu" class="ui button primary" style="margin: 10px 0" />
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</c:if>
				<c:if test="${fn:length(tickets) == 0}">
					<tbody>
						<tr>
							<td colspan="5">
								<div class="ui ribbon label">Nenhum ticket de entrada foi
									cadastrado</div>
							</td>
						</tr>
					</tbody>
				</c:if>
				<tfoot class="full-width">
					<tr>
						<th colspan="7">
							<div onclick="location.href='/PeterParkerSpring/formTicket';"
								class="ui right floated small primary labeled icon button">
								<i class="plus icon"></i> Adicionar ticket
							</div>
						</th>
					</tr>
				</tfoot>
			</table>
		</div>
		<div class="ui main text container" style="padding-top: 120px">
			<h2>Saída</h2>
			<table class="ui blue celled table">
				<thead>
					<tr>
						<th>Identificação</th>
						<th>Placa do carro</th>
						<th>Hora de entrada</th>
						<th>Hora de saída</th>
						<th>Dispositivo de entrada</th>
						<th>Dispositivo de saída</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ticketsout}" var="ticket" >
						<tr>
							<td>${ticket.id}</td>
							<td>${ticket.carro.placa}</td>
							<td>
								<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${ticket.horaEntrada.time}" />
							</td>
							
							<td>
								<fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"  value="${ticket.horaSaida.time}" />
		            		</td>
		            		
							<td>${ticket.dispositivoEntrada.id}</td>
							<td>${ticket.dispositivoSaida.id}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot class="full-width">
					<tr>
						<th colspan="7">
							<div onclick="location.href='/PeterParkerSpring/formTicket';"
								class="ui right floated small primary labeled icon button">
								<i class="plus icon"></i> Adicionar ticket
							</div>
						</th>
					</tr>
				</tfoot>
			</table>
		</div>	
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js"></script>
		<script type="text/javascript"
			src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.js"></script>
	</body>
</html>
