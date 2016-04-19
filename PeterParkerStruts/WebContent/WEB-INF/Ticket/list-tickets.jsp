<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


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
			<a href="/PeterParkerStruts/" class="header item">Peter Parker</a> <a
				href="/PeterParkerStruts/device" class="item">Dispositivo</a> <a
				href="/PeterParkerStruts/car" class="item">Carro</a> <a
				href="/PeterParkerStruts/ticket" class="item active">Ticket</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<h1>Entrada</h1>
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identificação</th>
					<th>Identificação do carro</th>
					<th>Hora de entrada</th>					
					<th>Dispositivo de entrada</th>					
					<th>Marcar saída</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tickets}" var="ticket">
					<tr>
						<td>${ticket.id}</td>
						<td>${ticket.carro.placa}</td>
						<td><fmt:formatDate value="${ticket.horaEntrada.time}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>						
						<td>${ticket.dispositivoEntrada.descricao}</td>						
						<td>
							<div class="field">
								<form method="POST" action="/PeterParkerStruts/ticket_update"
									class="ui form">
									<input type="hidden" name="ticket.id" value="${ticket.id}"/>
									<select name="ticket.dispositivoSaida.id">
										<c:forEach items="${devices}" var="device">
											<option value="${device.id}">${device.descricao}</option>
										</c:forEach>
									</select>
									<input type="submit" value="Saiu" class="ui button primary">
								</form>
							</div>
						</td>
					</tr>
				</c:forEach>

			</tbody>
			<tfoot class="full-width">
				<tr>
					<th colspan="7">
						<div onclick="location.href='/PeterParkerStruts/ticket_add';"
							class="ui right floated small primary labeled icon button">
							<i class="plus icon"></i> Adicionar ticket
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>

	<div class="ui main text container" style="padding-top: 80px">
		<h1>Saida</h1>
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identificação</th>
					<th>Identificação do carro</th>
					<th>Hora de entrada</th>
					<th>Hora de saída</th>
					<th>Dispositivo de entrada</th>
					<th>Dispositivo de saída</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ticketsSaida}" var="ticket">
					<tr>
						<td>${ticket.id}</td>
						<td>${ticket.carro.placa}</td>
						<td><fmt:formatDate value="${ticket.horaEntrada.time}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td><fmt:formatDate value="${ticket.horaSaida.time}"
								pattern="dd/MM/yyyy HH:mm:ss" /></td>
						<td>${ticket.dispositivoEntrada.descricao}</td>
						<td>${ticket.dispositivoSaida.descricao}</td>
					</tr>
				</c:forEach>

			</tbody>
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
