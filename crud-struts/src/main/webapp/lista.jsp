<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crud struts</title>
</head>
<body>
	<s:a href="home.jsp">Home </s:a>
 <br/>
		<s:a href="usuarioFormulario.jsp">Novo Usuário</s:a>
 <br/>
			<s:a action="Logout">Logout</s:a>
 <hr/>

				<c:if test="${not empty usuariosList }">
					<h1>Usuários</h1>
					<table>
						<tr>
							<th>ID</th>
							<th>Nome</th>
							<th>Username</th>
							<th>Password</th>
							<th>Alterar</th>
							<th>Remover</th>
						</tr>

						<s:iterator value="usuariosList" status="status">
							<tr
								style="background-color: ${status.even ? '# EEEEEE' : '# FFFFFF'}">
								<td><s:property value="id" /></td>
								<td><s:property value="nome" /></td>
								<td><s:property value="username" /></td>
								<td><s:property value="password" /></td>
								
								<td>
								  <s:a action="UsuarioPreparaAlteracao">
                                     alterar
                                     <s:param name="usuario.id" value="id" />
                                  </s:a>
                               </td>
								
								<td>
								   <s:a action="UsuarioRemove">
                                     remover
                                   <s:param name="usuario.id" value="id" />
								   </s:a>
								   
								</td>
							</tr>
						</s:iterator>
					</table>
				</c:if>
				
			<c:if test ="${empty usuariosList}">	
				<h1>Sem usuários cadastrados.</h1>
			</c:if>	
				
				
	</body>
</html>