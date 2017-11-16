<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:import url="/resources/cabecalho.jsp"></c:import>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<title>Lista de Contatos</title>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-body">
					<div class="table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Nome</th>
									<th>Endereço</th>
									<th>E-mail</th>
									<th>Data de Nascimento</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${contato.nome}</td>
									<td>${contato.endereco}</td>
									<td><c:choose>
											<c:when test="${not empty contato.email}">
												<a href="mailto:${contato.email}"> ${contato.email}</a>
											</c:when>
											<c:otherwise>
												<div class="alert-danger">E-mail não informado</div>
											</c:otherwise>
										</c:choose></td>
									<td><fmt:formatDate value="${contato.dataNascimento.time}"
											pattern="dd/MM/yyyy" /></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/resources/rodape.jsp"></c:import>
</body>
</html>