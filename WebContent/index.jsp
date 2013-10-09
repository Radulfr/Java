<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dungeon Master App</title>
</head>
<frameset  cols="45%,10%,*">
    <frame name="left" src="DMCombat.jsp" scrolling="auto" noresize frameborder="2">
    <frame name="center" src="Dices.jsp" scrolling="auto" frameborder="2">
    <frame name="right" src="Notes.jsp" scrolling="auto" frameborder="2">
</frameset>
<%--<body bgcolor="#DDDDDD" >
 <h1>Dungeons and Dragons Application</h1>
<s:form action="login" >
<s:textfield name="email" label="E-mail" />
<s:password name="password" label="Password" />
<s:submit name="Submit" />
</s:form>

<a href="SignIn.jsp">Get an account NOW!</a>
</body> --%>
</html>