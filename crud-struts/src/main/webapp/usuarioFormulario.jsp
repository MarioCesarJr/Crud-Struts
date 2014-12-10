<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:a href="home.jsp">Home</s:a>
 <br/>
		<s:a action="Logout">Logout</s:a>
 <hr/>

			<h1>Cadastro ou Alteração de Usuários</h1>

			<s:form action="UsuarioAdicionaOuAltera">
				<s:hidden name="usuario.id"/>
                    <s:textfield label ="Nome" name ="usuario.nome"/>
                    <s:textfield label ="Username" name="usuario.username"/>
                    <s:textfield label ="Password" name ="usuario.password"/>
                    <s:submit value="Salvar"/>
            </s:form>



</body>
</html>