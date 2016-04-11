<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de carros</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
</head>
<body>
	<div class="ui fixed inverted menu">
		<div class="ui container">
			<a href="/PeterParker/" class="header item">Peter Parker</a> <a
				href="/PeterParker/device" class="item">Dispositivo</a> <a
				href="/PeterParker/car" class="item active">Carro</a> <a
				href="/PeterParker/ticket" class="item">Ticket</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<table class="ui blue celled table">
			<thead>
				<tr>
					<th>Identificação</th>
					<th>Placa</th>
					<th>Cor</th>
					<th></th>
				</tr>
			</thead>
			<c:if test="${cars.isEveryElementActive()}">
				<tbody>
					<c:forEach items="${cars}" var="car">
						<c:if test="${car.getIsActive()}">
							<tr>
								<td>${car.id}</td>
								<td>${car.board}</td>
								<td>${car.color}</td>
								<td>
									<form method="POST" action="/PeterParker/car/remove">
										<input type="hidden" name="id" value="${car.id}" /> <input type="submit"
											class="ui button red" value="Remover" />
									</form>
								</td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${!cars.isEveryElementActive()}">
				<tbody>
					<tr>
						<td colspan="4">
							<div class="ui ribbon label">Nenhum carro foi cadastrado</div>
						</td>
					</tr>
				</tbody>
			</c:if>
			<tfoot class="full-width">
				<tr>
					<th colspan="4">
						<div onclick="location.href='/PeterParker/car/add';"
							class="ui right floated small primary labeled icon button">
							<i class="plus icon"></i> Adicionar carro
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