<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Put Marks</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>

<script language="JavaScript">
	function notaGlobal(){
		Estruct = document.getElementById("idEstruct").value;
		Exp = document.getElementById("idExp").value;
		Voc = document.getElementById("idVoc").value;
		Or = document.getElementById("idOr").value;
		Expect = document.getElementById("idExpect").value;
		Global = parseInt(((parseInt(Estruct) + parseInt(Exp) + parseInt(Voc) + parseInt(Or) + parseInt(Expect))/5)) ;
		document.getElementById("idGlobal").value = Global;
	}
</script>

<body>

<hr>
	<jsp:include page="header.jspf"></jsp:include>
<hr>

<h3>Put Marks</h3>
			<s:form action="evaluateArticle">
			<table border="1">
				<tr>
					<td>Criterio</td>
					<td align="center">Nota(0-10)</td>
				</tr>
				<tr>
					<s:hidden name="articleId" value="%{#session.EvArticle}"/>
					<s:textfield id="idEstruct" name="idEstruct" label="Estructuracion" align="center"/>
					<s:textfield id="idExp" name="idExp" label="Expresion" align="center"/>
					<s:textfield id="idVoc" name="idVoc" label="Vocabulario" align="center"/>
					<s:textfield id="idOr" name="idOr" label="Originalidad" align="center"/>
					<s:textfield id="idExpect" name="idExpect" label="Expectativas" align="center"/>
				
				</tr>
			</table>
			
			<br>
			<td><a href="javascript:notaGlobal()">Calcular nota global</a></td>
			<s:textfield id="idGlobal" name="idGlobal"/>
			<s:submit value="Evaluar" align="left"></s:submit>
			</s:form>	
			
		
</body>
</html>