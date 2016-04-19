<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			<a href="/PeterParkerStruts/" class="header item">Peter Parker</a> <a
				href="/PeterParkerStruts/device" class="item">Dispositivo</a> <a
				href="/PeterParkerStruts/car" class="item">Carro</a> <a
				href="/PeterParkerStruts/ticket" class="item active">Ticket</a>
		</div>
	</div>
	<div class="ui main text container" style="padding-top: 80px">
		<form method="POST" action="/PeterParkerStruts/ticket_create"
			class="ui form segment">
			<h3 class="ui dividing header">
				Informações do ticket
				</h4>
				<div class="field">
					<s:select label="Carro"
						list="cars"
						listKey="id" 
						listValue="placa"
						key="ticket.carro.id" />
				</div>				
				<div class="field">
					<s:select label="Dispositivo"
						list="devices"
						listKey="id"
						listValue="descricao"
						key="ticket.dispositivoEntrada.id" />		
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
