<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<tags:template titulo="Editar Acess�rio">
<jsp:body>


<form:form action="${action}" method="post" commandName="acessorio">

<div class="form-group">
<form:label path="nome">Nome</form:label>
<form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="descricao">Descri��o</form:label>
<form:input path="descricao" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="disponivel">Disponivel</form:label>
<form:checkbox path="disponivel"/>
</div>

<input type="submit" value="Alterar">
</form:form>
</jsp:body>

</tags:template>