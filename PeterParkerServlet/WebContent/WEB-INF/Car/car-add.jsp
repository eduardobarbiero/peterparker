<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="car?action=AddCar" method="post">
  <label>Placa</label><br>
  <input type="text" id="board" name="board"/><br>
  <label>Cor</label><br>
  <input type="text" id="color" name="color"/><br>
  <input type="submit" value="Cadastrar">
</form>
</body>
</html>