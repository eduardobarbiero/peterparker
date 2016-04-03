<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<a href="/PeterParker/" class="header item">Peter Parker</a> 
				<a href="/PeterParker/device" class="item">Dispositivo</a> 
				<a href="/PeterParker/car" class="item">Carro</a> 
				<a href="/PeterParker/ticket" class="item active">Ticket</a>
			</div>
		</div>
		<div class="ui main text container" style="padding-top: 80px">
			<form method="POST" action="" class="ui form segment">
				<h3 class="ui dividing header">
					Informações do ticket
				</h4>
				<div class="field">
					<label>Carro</label>
					<select type="text" name="carro_id">
						<option value="a">a</option>
						<option value="b">b</option>
						<option value="c">c</option>
						<option value="d">d</option>
					</select>
				</div>
				<div class="field">
					<label>Horários</label>
					<div class="two fields">
						<div class="field">
							<input type="text" name="horario_entrada" placeholder="Entrada">
						</div>
						<div class="field">
							<input type="text" name="horario_saida" placeholder="Saída">
						</div>
					</div>
				</div>
				<div class="field">
					<label>Dispositivos</label>
					<div class="two fields">
						<div class="field">
							<select type="text" name="dispositivo_entrada">
								<option value="">Entrada</option>
								<option value="a">a</option>
								<option value="b">b</option>
								<option value="c">c</option>
								<option value="d">d</option>
							</select>
						</div>
						<div class="field">
							<select type="text" name="dispositivo_saida">
								<option value="">Saída</option>
								<option value="a">a</option>
								<option value="b">b</option>
								<option value="c">c</option>
								<option value="d">d</option>
							</select>
						</div>
					</div>
				</div>
				<input type="submit" value="Salvar" class="ui button primary" />
			</form>
		</div>
	
	</body>
</html>
