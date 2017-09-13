<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="titulo" required="true" %>
<%@ attribute name="script" fragment="true" %>

<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titulo}</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    
      <li class="nav-item active">
        <a class="nav-link" href="cadastrar">Cadastrar <span class="sr-only">(current)</span></a>
        
      </li>
      <li class="nav-item">
        <a class="nav-link" href="listar">Listar</a>
      </li>
      
  <li class="dropdown nav-link">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Ve�culo<b class="caret"></b>
    </a>
    <ul class="dropdown-menu">
    	<li>
      <a class="nav-link" href="<c:url value="/veiculo/cadastrar/"/>">Cadastrar</a>
      
      	</li>
      	<li>
      <a class="nav-link" href="<c:url value="/veiculo/listar/"/>">Listar</a>
      </li>
    </ul>
  </li>


<li class="dropdown nav-link">
    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Acess�rio<b class="caret"></b>
    </a>
    <ul class="dropdown-menu">
    <li>
      <a class="nav-link" href="<c:url value="/acessorio/cadastrar/"/>">Cadastrar</a>
      </li>
      <li>
      <a class="nav-link" href="<c:url value="/acessorio/listar/"/>">Listar</a>
      </li>
    </ul>
  </li>
</ul>
		
     
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
	<div class="container">
		<h1>Spring MVC</h1>
		<jsp:doBody/>
<p>Todos os Direitos Reservados &copy; - 2017</p>
</div>
<script src="<c:url value="/resources/js/jquery-3.2.1.min.js"/>"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


	<jsp:invoke fragment="script"></jsp:invoke>
</body>
</html>