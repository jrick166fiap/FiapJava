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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
  Launch demo modal
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>


</tags:template>
