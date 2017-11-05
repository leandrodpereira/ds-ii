<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/resources/cabecalho.jsp"></c:import>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Busca</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-body">
					<form action="mvc?bean=BuscaContatoIdBean&" method="post">
						<fieldset>
							<legend>Busca pela Id</legend>
							<div class="form-group">
								<label for="nome">Id</label> <input type="number"
									class="form-control" id="buscaId" name="buscaId" autofocus
									required>
							</div>
							<button type="submit" class="btn btn-primary btn-lg pull-right">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/resources/rodape.jsp"></c:import>
</body>
</html>