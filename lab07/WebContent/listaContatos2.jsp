<!-- Lab 07a  -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
	</head>
	<body>
		<!-- Cria objeto DAO -->
		<jsp:useBean id="cdao" class="br.fepi.si.jdbc.dao.ContatoDao"/>
		
		<table>
			<!-- Percorre tabela com foreach -->
			<c:forEach var="contato" items="${cdao.selectAll()}">
			<tr>
				<td>${contato.nome}</td>
				<td>
				<!-- Estrutura com if -->
				
				<%-- <c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}"> ${contato.email}</a>
				</c:if> --%>
				
				<!-- Estrutura com choose  -->
				<c:choose>
					<c:when
						test="${not empty contato.email}">
						<a href="mailto:${contato.email}"> ${contato.email}</a>
					</c:when>
					<c:otherwise>
						E-mail não informado.
					</c:otherwise>
				</c:choose>
				
				</td>
				<td>${contato.endereco}</td>
				<td>${contato.dataNascimento.time}</td>
			</tr>
			</c:forEach>
		</table>
	</body>
</html>