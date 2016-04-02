<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Adicionar Ticket</title>
</head>
<body>
	<div class="container" style="padding-top: 20px;">
		<div class="col-md-12 col-lg-6 col-sm-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h2>Adicionar Ticket</h2>
				</div>
				<div class="panel-body">
					<form class="form-horizontal" action="adicionaTicket" method="post">
						  <div class="form-group">
						    <label for="placaId" class="col-sm-3 control-label">Placa:</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="placaId" placeholder="Placa" name="car.board">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="corId" class="col-sm-3 control-label">Cor:</label>
						    <div class="col-sm-8">
						      <input type="text" class="form-control" id="corId" placeholder="Cor" name="car.color">
						    </div>
						  </div>
			
						<div class="form-group">
      						<label for="entradaId" class="col-sm-3 control-label">Entrada:</label>
      						<div class="col-sm-8">
								<select id="entradaId" class="form-control"  name="dispositivoEntrada.id" >
								  <c:forEach items="${devices}" var="device">
								    <option value="${device.id}">
								        ${device.address}
								    </option>
								  </c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-lg-11 col-md-11 col-sm-11">
							<a class="btn btn-default" style="float: left;" href="lista">Lista de tickets</a>
								<input style="float: right;" class="btn btn-primary" type="submit" value="Adicionar" />
							</div>
						</div>							
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>