<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Adicionar dispositivo</title>
		
		<link rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.8/semantic.min.css" />
	</head>
	<body>
		<div class="ui fixed inverted menu">
			<div class="ui container">
				<a href="/PeterParkerStruts/" class="header item">Peter Parker</a> 
				<a href="/PeterParkerStruts/device" class="item active">Dispositivo</a> 
				<a href="/PeterParkerStruts/car" class="item">Carro</a> 
				<a href="/PeterParkerStruts/ticket" class="item">Ticket</a>
			</div>
		</div>
		<div class="ui main text container" style="padding-top: 80px">		    
			<form method="POST" action="/PeterParkerStruts/device_create" class="ui form segment">
				<h3 class="ui dividing header">
					Informa��es do dispositivo
				</h4>
				<div class="field">					
					<s:textfield key="dispositivo.localizacao" label="Localiza��o"/>					
				</div>
				<div class="field">					
					<s:textfield key="dispositivo.descricao" label="Descri��o"/>					
				</div>
				<input type="submit" value="Salvar" class="ui button primary" />
			</form>
		</div>
	
	</body>
</html>

