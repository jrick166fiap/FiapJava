<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<tags:template titulo="Lista de Veículos">
<h1>Lista de Veículos</h1>

<c:if test="${not empty msg}">
	<div class="alert alert-sucess">
	${msg} 
	</div>

</c:if>
<table class="table">

<tr>
	
	<th>Marca</th>
	<th>Modelo</th>
	<th>Placa</th>
	<th>Cor</th>
	</tr>
	<c:forEach items="${listao}" var="v"> 
	<tr>
	 <td>${v.marca}</td>
	 <td>${v.modelo}</td>
	 <td>${v.placa}</td>
	 <td>${v.cor}</td>
	 <td> <a href="<c:url value="/veiculo/editar/${v.codigo }"/>">Alterar</a></td>
	 <td> <a href="<c:url value="/veiculo/remover/${v.codigo}"/>">Excluir</a></td>
	 
	</tr>
	</c:forEach>
</table>


</tags:template>
