<%@ page language="java" contentType="text/html; ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:import url="/resources/cabecalho.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Cadastro</title>
	<meta name="viewport" content="width=device-width">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="js/datepicker-pt-BR.js"></script>
	<link href="css/bootstrap.css" rel="stylesheet">
	<link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet">
    <script>
        $(function() {
            $( "#datepicker" ).datepicker();
        });
   </script>
</head>
<body>
	<div class="jumbotron">
			<div class="container">	
				<div class="panel panel-default" style="margin: 10px">
					<div class="panel-heading">
						<h1 class="panel-title">Editar Contatos</h1>
					</div>	
					<div class="panel-body">			
						<form action="<c:url value = "/mvc?bean=AlteraContatoBean&id=${contato.id}"/>" method="post">
							<fieldset>
								<legend>Cadastro</legend>
								<div class="form-group">
									<label for="nome">Nome completo</label>
									<input type="text" value = "${contato.nome}" class="form-control" id="nome" name="nome" autofocus required>
								</div>
								<div class="form-group">
									<label for="email">Email</label>
									<div class="input-group">
										<span class="input-group-addon">@</span>
										<input type="email" value = "${contato.email}"class="form-control" id="email" name="email"
										placeholder="email@exemplo.com" required>
									</div>									
								</div>
								<div class="form-group">
									<label for="endereco">Endereço</label>
									<div class="input-group">
										<span class="input-group-addon glyphicon glyphicon-home"></span>										
										<input type="text" value = "${contato.endereco}" class="form-control" id="endereco" name="endereco" required>
									</div>
								</div>
								<div class="form-group">
									<label for="dataNascimento">Data de Nascimento</label>		
									<div class="input-group">	
										<span class="input-group-addon glyphicon glyphicon-calendar"></span>						
										<input type="text" value = "<fmt:formatDate value="${contato.dataNascimento.time}"/>" class="form-control" id="datepicker" name="dataNascimento" 
										placeholder="10/10/2000" required>
									</div>
								</div>
								<button type="submit" class="btn btn-primary btn-lg pull-right">
									<span class="glyphicon glyphicon-thumbs-up"></span>
									Alterar							
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