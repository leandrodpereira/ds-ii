<%@page import="java.text.SimpleDateFormat,
				br.fepi.si.jdbc.dao.ContatoDao,
				java.util.List,
				br.fepi.si.jdbc.model.Contato"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="jumbotron">
		<div class="container">	
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">Lista de Contatos</h1>
				</div>
				<div class="panel-body">
					<table class="table">
						<thead>
							<tr>
								<th>Nome</th>
								<th>E-mail</th>
								<th>Endereço</th>
								<th>Data de Nascimento</th>
							</tr>
						</thead>
						<%
						ContatoDao cd = new ContatoDao();
						List<Contato> contatos = cd.selectAll();
						for (Contato c : contatos){
							String data = new SimpleDateFormat("dd/MM/yyyy").
									format(c.getDataNascimento().getTimeInMillis());
						
						%>
						<tbody>
							<tr>
								<td><%=c.getNome() %></td>
								<td><%=c.getEmail() %></td>
								<td><%=c.getEndereco() %></td>
								<td><%=data %></td>
							</tr>
						</tbody>
						<%}%>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>