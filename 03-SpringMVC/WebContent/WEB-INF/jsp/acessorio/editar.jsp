<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Editar Acessório">
<jsp:body>

<c:url value="/acessorio/editar" var="link"></c:url>
<form:form action="${link}" method="post" commandName="acessorio">

<form:hidden path="codigo"/>

<div class="form-group">
<form:label path="nome">Nome</form:label>
<form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="descricao">Descrição</form:label>
<form:input path="descricao" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="disponivel">Disponivel</form:label>
<form:checkbox path="disponivel"/>
</div>

<input type="submit" value="Alterar" class="btn btn-primary">
<a href="/03-SpringMVC/acessorio/lista" class="btn btn-primary">Voltar</a>
</form:form>
</jsp:body>

</tags:template>