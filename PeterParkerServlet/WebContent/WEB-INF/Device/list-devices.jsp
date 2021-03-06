<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de dispositivos</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="/PeterParker/" class="header item">Peter Parker</a> <a
				href="/PeterParker/device" class="item active">Dispositivo</a> <a
				href="/PeterParker/car" class="item">Carro</a> <a
				href="/PeterParker/ticket" class="item">Ticket</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identificação</th>
					<th>Localização</th>
					<th>Descrição</th>
					<th></th>
				</tr>
			</thead>
			<c:if test="${devices.isEveryElementActive()}">
				<tbody>
					<c:forEach items="${devices}" var="device">
						<c:if test="${device.getIsActive()}">
							<tr>
								<td>${device.id}</td>
								<td>${device.address}</td>
								<td>${device.description}</td>
								<td>
									<form method="POST" action="/PeterParker/device/remove">
										<input type="hidden" name="id" value="${device.id}" />
										<input type="submit" value="Remover" class="ui button red" />
									</form>
								</td>
							</tr>
						</c:if>					
					</c:forEach>				
				</tbody>
			</c:if>
			<c:if test="${!devices.isEveryElementActive()}">
				<tbody>
					<tr>
						<td colspan="4">
							<div class="ui ribbon label">
								Nenhum dispositivo foi cadastrado
							</div>
						</td>
					</tr>				
				</tbody>
			</c:if>			
			<tfoot class="full-width">
				<tr>
					<th colspan="4">
						<div onclick="location.href='/PeterParker/device/add';"
							class="ui right floated small primary labeled icon button">
							<i class="plus icon"></i> Adicionar dispositivo
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