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
	<jsp:useBean id="cdao" class="br.fepi.si.jdbc.dao.ContatoDao"></jsp:useBean>
	<div class="jumbotron">
		<div class="container">
			<div class="panel panel-primary">
				<div class="panel-body">
					<table class="table table-responsive">
						<thead>
							<tr>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Endereço</th>
								<th>Data de Nascimento</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="contatos" items="${cdao.selectAll()}">
								<tr>
									<td>${contatos.nome}</td>
									<td>${contatos.endereco}</td>									
									
									<c:if test="${not empty contatos.email}">
										<td class="warning">${contatos.email}</td>
									</c:if>
									
									<td><fmt:formatDate
											value="${contatos.dataNascimento.time}" pattern="dd/MM/yyyy" />
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<c:import url="/resources/rodape.jsp"></c:import>
</body>
</html>