<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
    


<tags:template title="Lista de Animes">

<jsp:body>
<c:if test="${not empty msg }">
<div class="alert alert-success">
${msg }
</div>
</c:if>

<table>
<tr>
 <th>Nome</th>
 <th>Personagem</th>
 <th>Episodios</th>
 <th>Trilha Sonora</th>
 </tr>
<c:forEach items="${listao}"  var="v">
 <tr>
 <td>${v.nome}</td>
 <td>${v.personagemPrincipal}</td>
 <td>${v.episodios}</td>
 <td>${v.trilhasonora}</td>
 </tr>
 </c:forEach>
 </table>
 </jsp:body>
 
 </tags:template>
