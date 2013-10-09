<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Take a note</title>
</head>
<body bgcolor="#DDDDDD">
<h2>Notes</h2>
<h4>Dungeon Master's Notepad</h4>

	<s:form action="addnote">
		<b>Your note:</b>
		<s:textarea name="body" cols="40" rows="4" onFocus="this.value=''"/>
		<s:submit value="Submit" />
	</s:form>
	<s:form action="clearnotelist">
		<s:submit value="Clear notelist" />
	</s:form>
</body>


			<table border="1" bgcolor="#EEEEEE">
			<s:if test="notelist.size()>0">
				<tr align="center">
					<td><b>Time</b></td>
					<td><b>Note</b></td>
				</tr>
			</s:if>
			<s:iterator value="notelist" status="itStatus">
				<tr align="center">
					<td><s:property value="getDate()" /></td>
					<td><i><s:property value="getEvent()" /></i></td>
				</tr>
			</s:iterator>
		</table>

</html>