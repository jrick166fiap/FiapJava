<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Lista de Acessorios" >

<jsp:body>

<c:if test="${not empty msg}">
	<div class="alert alert-success">
	${msg} 
	</div>

</c:if>

<h1>Lista de Acessórios</h1>
<table class="table">

<tr>
	<th>Nome</th>
	<th>Preço</th>
	<th>Descrição</th>
	<th>Disponível</th>

</tr>

<c:forEach items="${listao}" var="v">
<tr>
	<td>${v.nome}</td>
	<td>${v.preco}</td>
	<td>${v.descricao}</td>
	<td>${v.disponivel}</td>
	<td> <a href="<c:url value="/acessorio/editar/${v.codigo }"/>">Alterar</a></td>
	<td><button onclick="idCodigo.value = ${v.codigo}" type="button"
						class="btn btn-danger btn-xs" data-toggle="modal"
						data-target="#exampleModal">Excluir</button></td>


</tr>

</c:forEach>

</table>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Excluir</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Deseja realmente excluir ?</div>
				<div class="modal-footer">
					<c:url value="/acessorio/remover" var="excluir" />
					<form:form action="${excluir}" method="post">
						<input type="hidden" name="codigo" id="idCodigo" />
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Não</button>
						<button type="submit" class="btn btn-primary">Sim</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</jsp:body>
</tags:template>



