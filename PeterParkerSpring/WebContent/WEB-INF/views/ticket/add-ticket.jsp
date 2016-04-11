<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Adicionar ticket</title>
		
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
			<form method="POST" action="adicionaTicket" class="ui form segment">
				<h3 class="ui dividing header">
					Informações do ticket
				</h4>
				<div class="field">
					<label>Carro</label>
					<select id="carId" class="form-control" required name="carro.id" >
					  <c:forEach items="${cars}" var="car">
					    <option value="${car.id}">
					        ${car.placa}
					    </option>
					  </c:forEach>
					</select>
				</div>
				<div class="field">
					<label>Dispositivo</label>
					<select id="dispositivoId" class="form-control"  required name="dispositivoEntrada.id" >
					  <c:forEach items="${devices}" var="device">
					    <option value="${device.id}">
					        ${device.localizacao}
					    </option>
					  </c:forEach>
					</select>
				</div>
				<input type="submit" value="Salvar" class="ui button primary" />
			</form>
		</div>
	
	</body>
</html>
