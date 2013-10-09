<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Throwing dices</title>
</head>
<body bgcolor="#CCCCCC">
<b>Good luck!</b>
<br />
<br />
	<s:form action="throw">
		<s:textfield value="1" name="nd4" size="2" onFocus="this.value=''" /><s:submit value="d4"  />
		<s:hidden name="selector" value="4" />
	</s:form>
	<br />

	<s:form action="throw">
		<s:textfield value="1"  name="nd6" size="2" onFocus="this.value=''" /><s:submit value="d6" />
		<s:hidden name="selector" value="6" />
	</s:form>
	<br />
	<s:form action="throw">
		<s:textfield value="1"  name="nd8" size="2" onFocus="this.value=''" /><s:submit value="d8" />
		<s:hidden name="selector" value="8" />
	</s:form>
	<br />
	<s:form action="throw">
		<s:textfield value="1" name="nd10" size="2" onFocus="this.value=''" /><s:submit value="d10" />
		<s:hidden name="selector" value="10" />
	</s:form>
	<br />
	<s:form action="throw">
		<s:textfield value="1"  name="nd12" size="2" onFocus="this.value=''" /><s:submit value="d12" />
		<s:hidden name="selector" value="12" />
	</s:form>
	<br />
	<s:form action="throw">
		<s:textfield value="1"  name="nd20" size="2" onFocus="this.value=''" /><s:submit value="d20" />
		<s:hidden name="selector" value="20" />
	</s:form>
	<br />
	<b>Result <s:property value="getOperation()" />: </b> <h2><s:property value="getResult()" /></h2>

</body>
</html>