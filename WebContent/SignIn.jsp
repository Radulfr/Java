<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>
</head>
<body>
<h3>Welcome</h3>
<s:form action="register">
<s:textfield name="nickname" label="Nickname" />
<s:textfield name="email" label="E-mail" />
<s:password name="password" label="Password" />
<s:password name="rpassword" label="Re-tye password" />
<s:submit value="Submit" />
</s:form>

</body>
</html>