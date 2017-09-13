<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
</head>
<body>
<h1>Cadastro dos Pratos</h1>

<form action="cadastrar" method="post">
<div>
<label for="id-name">Nome:</label>
<input id="id-name" type="text" name="nome" placeholder="Digite o nome">
</div>

<div>
<label  for="id-preco">Preço:</label>
<input id="id-preco" type="text" name="preco" placeholder="Digite o valor">
</div>

<div>
<label for="id-peso">Peso:</label>
<input id=id-peso name="peso" placeholder="Digite o peso">
</div>

<input type="submit" value="cadastrar">
</form>
</body>
</html>