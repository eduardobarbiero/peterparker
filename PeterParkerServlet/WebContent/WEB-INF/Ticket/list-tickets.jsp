<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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
			<a href="/PeterParker/" class="header item">Peter Parker</a> <a
				href="/PeterParker/device" class="item">Dispositivo</a> <a
				href="/PeterParker/car" class="item">Carro</a> <a
				href="/PeterParker/ticket" class="item active">Ticket</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<h1>Entrada</h1>
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identifica��o</th>
					<th>Identifica��o do carro</th>
					<th>Hora de entrada</th>
					<th>Dispositivo de entrada</th>
					<th>Marcar sa�da</th>
				</tr>
			</thead>
			<c:if test="${fn:length(tickets) > 0}">
				<tbody>
					<c:forEach items="${tickets}" var="ticket">
						<tr>
							<td>${ticket.id}</td>
							<td>${ticket.car.board}</td>
							<td><fmt:formatDate value="${ticket.horaEntrada.time}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>
							<td>${ticket.dispositivoEntrada.description}</td>
							<td>
								<div class="field">
									<form method="POST" action="/PeterParker/ticket/update"
										class="ui form">
										<input type="hidden" id="ticket_id" name="ticket_id"
											value="${ticket.id}" /> <select type="text"
											name="dispositivo_saida">
											<c:forEach items="${devices}" var="device">
												<c:if test="${device.getIsActive()}">
													<option value="${device.id}">${device.description}</option>
												</c:if>
											</c:forEach>
										</select> <input type="submit" value="Saiu" class="ui button primary"
											style="margin: 10px 0">
									</form>
								</div>
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
						<div onclick="location.href='/PeterParker/ticket/add';"
							class="ui right floated small primary labeled icon button">
							<i class="plus icon"></i> Adicionar ticket
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>

	<div class="ui main text container"
		style="padding-top: 80px; padding-bottom: 80px;">
		<h1>Saida</h1>
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identifica��o</th>
					<th>Identifica��o do carro</th>
					<th>Hora de entrada</th>
					<th>Hora de sa�da</th>
					<th>Dispositivo de entrada</th>
					<th>Dispositivo de sa�da</th>
				</tr>
			</thead>
			<c:if test="${fn:length(tickets_saida) > 0}">
				<tbody>
					<c:forEach items="${tickets_saida}" var="ticket">
						<tr>
							<td>${ticket.id}</td>
							<td>${ticket.car.board}</td>
							<td><fmt:formatDate value="${ticket.horaEntrada.time}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>
							<td><fmt:formatDate value="${ticket.horaSaida.time}"
									pattern="dd/MM/yyyy HH:mm:ss" /></td>
							<td>${ticket.dispositivoEntrada.description}</td>
							<td>${ticket.dispositivoSaida.description}</td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${fn:length(tickets_saida) == 0}">
				<tbody>
					<tr>
						<td colspan="5">
							<div class="ui ribbon label">Nenhum ticket de sa�da foi
								cadastrado</div>
						</td>
					</tr>
				</tbody>
			</c:if>
			<tfoot class="full-width">
				<tr>
					<th colspan="7">
						<div onclick="location.href='/PeterParker/ticket/add';"
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
