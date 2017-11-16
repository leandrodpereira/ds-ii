<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>

	<div class="panel-heading">
		<a href="<c:url value = "/"/>">
			<img src="<c:url value ="/img/cabecalho.png"/>" />
		</a>
	</div>


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      
    </div>
    <ul class="nav navbar-nav">
   
			<li class="active"><a href="<c:url value = "/mvc?bean=FormAdicionaContatoBean"/>">Cadastro</a></li>
			<li><a href="<c:url value = "/mvc?bean=ListaContatosBean"/>">Contatos</a></li>
			<li><a href="<c:url value = "/mvc?bean=FormBuscaIdBean"/>">Busca</a></li>
		</ul>
    
    
  </div>
</nav>


	
</html>
