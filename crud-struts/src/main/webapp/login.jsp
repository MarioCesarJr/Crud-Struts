<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
    <dir style="color:red">
       <s:property value="mensagem"/>
    </dir>
    
    <s:form action="Login">
        <s:label value="Usuário"/>
          <s:textfield name="usuario.username"/>
          
        <s:label value="Senha"/>
          <s:password name="usuario.password"/>
          
        <s:submit value="Entrar"/>    
    </s:form>
</body>
</html>