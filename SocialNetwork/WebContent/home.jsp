<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<body>
<s:if test="#session.role == 1">
            <jsp:forward page="/Author.jsp" />
</s:if>
<s:elseif test="#session.role == 2">
            <jsp:forward page="/Publisher.jsp" />
</s:elseif>
<s:elseif test="#session.role == 3">
            <jsp:forward page="/Reviewer.jsp" />
</s:elseif>
<s:else>
		<jsp:forward page="/index.jsp" />
</s:else>
<h2>Loading...</h2>
</body>
</html>