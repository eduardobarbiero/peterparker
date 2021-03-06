<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
			<a href="/PeterParkerStruts/" class="header item">Peter Parker</a> <a
				href="/PeterParkerStruts/device" class="item active">Dispositivo</a> <a
				href="/PeterParkerStruts/car" class="item">Carro</a> <a
				href="/PeterParkerStruts/ticket" class="item">Ticket</a>
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
			<tbody>
				<c:forEach items="${dispositivos}" var="dispositivo">
					<tr>
						<td>${dispositivo.id}</td>
						<td>${dispositivo.localizacao}</td>
						<td>${dispositivo.descricao}</td>
					</tr>					
				</c:forEach>				
			</tbody>
			<tfoot class="full-width">
				<tr>
					<th colspan="4">
						<div onclick="location.href='/PeterParkerStruts/device_add';"
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