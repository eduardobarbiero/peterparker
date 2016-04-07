<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar ticket</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
<link rel="stylesheet" type="text/css"
	href="//assets.locaweb.com.br/locastyle/3.8.4/stylesheets/locastyle.css">
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
		<form method="POST" action="/PeterParker/ticket/create"
			class="ui form segment">
			<h3 class="ui dividing header">
				Informações do ticket
				</h4>
				<div class="field">
					<label>Carro</label> <select type="text" name="carro_id" required>
						<c:forEach items="${cars}" var="car">
							<option value="${car.id}">${car.board}</option>
						</c:forEach>
					</select>
				</div>
				<!--  <div class="field">					
					<div class="two fields">
						<div class="field">
						<label>Entrada</label>
							<input type="text" name="horario_entrada"
								placeholder="Ex: 00/00/0000 00:00:00"
								data-mask="00/00/0000 00:00:00">
						</div>
						<div class="field">
						<label>Saída</label>
							<input type="text" name="horario_saida"
								placeholder="Ex: 00/00/0000 00:00:00"
								data-mask="00/00/0000 00:00:00">
						</div>
					</div>
				</div>-->
				<div class="field">
					<label>Dispositivos</label>
					<div class="field">
						<select type="text" name="dispositivo_entrada" required>
							<c:forEach items="${devices}" var="device">
								<option value="${device.id}">${device.description}</option>
							</c:forEach>
						</select>
					</div>
					<!--<div class="field">
							<select type="text" name="dispositivo_saida">
								<c:forEach items="${devices}" var="device">
									<option value="${device.id}">${device.description}</option>
								</c:forEach>
							</select>
						</div>-->

				</div>
				<input type="submit" value="Salvar" class="ui button primary" />
		</form>
	</div>

</body>

<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.0.0-beta1/jquery.min.js"></script>
<script
	src="//assets.locaweb.com.br/locastyle/3.8.4/javascripts/locastyle.js"></script>
</html>
