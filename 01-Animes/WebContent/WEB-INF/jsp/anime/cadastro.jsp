<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
    

<tags:template title="Cadastrar Anime">

<form:form action="${cadastrar}" method="post" commandName="anime">

<div class="form-group">
<form:label path="nome">Nome</form:label>
<form:input path="nome" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="personagemPrincipal"> Personagem Principal</form:label>
<form:input path="personagemPrincipal" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="episodios">Episodios</form:label>
<form:input path="episodios" cssClass="form-control"/>
</div>

<div class="form-group">
<form:label path="trilhasonora">Trilha Sonora</form:label>
<form:input path="trilhasonora" cssClass="form-control"/>

<div class="form-group">
<input type="submit" value="Cadastrar">
</div>

</div>
</form:form>


</tags:template>