<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700' rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css" href="resources/css/style.css" />
<body>

	<div id="login" class="bradius">
		<div class="message">
			<s:property value="mensagem" />
		</div>

		<div class="acomodar">
			<s:form action="Login">
				<s:label value="Usuário" />
				<s:textfield class="txt bradius" name="usuario.username" />

				<s:label value="Senha" />
				<s:password class="txt bradius" name="usuario.password" />

				<s:submit class="sb bradius" value="Entrar" />
			</s:form>
		</div>
	</div>
</body>
</html>