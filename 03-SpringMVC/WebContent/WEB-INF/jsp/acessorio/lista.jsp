<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Lista de Acessorios" >

<jsp:body>

<c:if test="${not empty msg}">
	<div class="alert alert-sucess">
	${msg} 
	</div>

</c:if>

<table class="table">

<tr>
	<th>Nome</th>
	<th>Descrição</th>
	<th>Disponível</th>

</tr>

<c:forEach items="${listao}" var="v">
<tr>
	<td>${v.nome}</td>
	<td>${v.descricao}</td>
	<td>${v.disponivel}</td>
	<td> <a href="<c:url value="/acessorio/editar/${v.codigo }"/>">Alterar</a></td>
	<td> <a href="<c:url value="/acessorio/remover/${v.codigo}"/>">Excluir</a></td>


</tr>

</c:forEach>

</table>
</jsp:body>
</tags:template>



