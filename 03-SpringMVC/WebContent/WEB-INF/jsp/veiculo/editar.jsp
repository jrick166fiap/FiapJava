<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Editar Cadastro">
	<jsp:body>

<c:url value="/veiculo/editar" var="link"></c:url>
<form:form action="${link}" method="post" commandName="veiculo">

<form:hidden path="codigo" />

<div class="form-group">
<form:label path="marca">Marca</form:label>
<form:input path="marca" cssClass="form-control" />
<form:errors path="marca" cssClass="text-danger"/>
</div>

<div class="form-group">
<form:label path="modelo">Modelo</form:label>
<form:input path="modelo" cssClass="form-control"/>
<form:errors path="modelo" cssClass="text-danger"/>
</div>

<div class="form-group">
	<form:label path="ano">Ano</form:label>
	<form:input path="ano" cssClass="form-control" />
	<form:errors path="ano" cssClass="text-danger"/>
</div>

<div class="form-group">
<form:label path="placa">Placa</form:label>
<form:input path="placa" cssClass="form-control" />
<form:errors path="placa" cssClass="text-danger"/>
</div>

<div class="form-group">
<form:label path="cor">Cor</form:label>
<form:input path="cor" cssClass="form-control" />
<form:errors path="cor" cssClass="text-danger"/>
</div>

<div class="form-group">
	<form:label path="dataFabricacao">Data Fabricação</form:label>
	<form:input path="dataFabricacao" cssClass="form-control" />
	<form:errors path="dataFabricacao" cssClass="text-danger" />
	</div>

<input type="submit" value="Alterar" class="btn btn-primary" />
<a href="/03-SpringMVC/veiculo/listar" class="btn btn-primary">Voltar</a>
</form:form>


</jsp:body>

</tags:template>