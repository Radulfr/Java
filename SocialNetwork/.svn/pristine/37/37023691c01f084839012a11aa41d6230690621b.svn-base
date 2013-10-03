<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Profile</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<body>
<h2>User Profile</h2>
<hr>

<s:form action="Adminupdateprofile">
	<s:textfield name="email" label="E-mail" disabled="true" value="%{#session.edit_user.getEmail()}"  />
	<s:textfield name="karma" label="Karmapoints" value="%{#session.edit_user.getKarma()}" />
	<s:textfield name="name" label="First Name" value="%{#session.edit_user.getName()}" />
	<s:textfield name="secondname" label="Second Name" value="%{#session.edit_user.getSecond_name()}" />
	<s:textfield name="city" label="City" value="%{#session.edit_user.getCity()}" />
	<s:textfield name="rol" label="Rol" value="%{#session.edit_user.getRol()}" disabled="true" />
	<s:password name="password" label="New Password"/>
	<s:password name="password_confirmation" label="Re-Type Password"/>
	<s:submit value="Update"> </s:submit>
	
</s:form>
</body>
</html>