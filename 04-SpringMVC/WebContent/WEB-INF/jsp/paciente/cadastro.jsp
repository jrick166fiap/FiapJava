<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<tags:template title="Cadastro de Pacientes">

<jsp:body>

<h1>Cadastro de Pacientes</h1>

<form:form action="${action}" method="post" commandName="paciente">

<div class="form-group">
<form:label path="nome"> Nome</form:label>
<form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="dataNascimento"> Data de Nascimento</form:label>
<form:input path="dataNascimento" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="numeroQuarto">Número do Quarto</form:label>
<form:input path="numeroQuarto" cssClass="form-control"/>
</div>

<input type="submit" value="Salvar" class="btn btn-primary">

</form:form>


</jsp:body>

</tags:template>