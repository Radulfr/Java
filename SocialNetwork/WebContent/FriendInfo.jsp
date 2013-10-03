<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Info</title>
<script language="JavaScript">
    function show_table() {
        var item_tr = document.getElementById("publications");
        
        if (item_tr) { 
	        if (item_tr.style.display == "none") {
		        item_tr.style.display = "";

	        } else {
		        item_tr.style.display = "none";
	        }
        }
    }
	
</script>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<body>
<h2>User Profile</h2>
<hr>
<jsp:include page="header.jspf"></jsp:include>
<hr>
<h3>Information</h3>
	<table border="1">
		<tr><td><b>User mail</b></td><td><s:property value="userfriend.getEmail()" /></td></tr>
		<tr><td><b>Name</b></td><td><s:property value="userfriend.getName()" /></td></tr>
		<tr><td><b>Second Name</b></td><td><s:property value="userfriend.getSecond_name()" /></td></tr>
		<tr><td><b>Birth Date</b></td><td><s:property value="userfriend.getDate()" /></td></tr>
		<tr><td><b>Articles AVG mark</b></td><td><s:property value="avgMark" /></td></tr>
		<tr><td><b>City</b></td><td><s:property value="userfriend.getCity()" /></td></tr>
	</table>
	
	<br />
	<s:if test="#session.friendrol == 1">
		<h3>Publications</h3>
	</s:if>
	<s:elseif test="#session.friendrol == 2">
		<h3>Evaluated publications</h3>
	</s:elseif>
	<s:else>
		<h3>No Publications for Publishers</h3>
	</s:else>
	
	<div id="publications">
		<table border="1">
		<s:if test="articleList.size() > 0" >
			<tr>
				<td><b>Article ID</b></td>
				<td><b>Title</b></td>
				<td><b>Document name</b></td>
				<td><b>Mark</b></td>
				<td><b>Want to see?</b></td>
			</tr>
		</s:if>
			<s:iterator value="%{#session.articleList}" status="itStatus">
				<tr>
					<td><s:property value="getId()" /></td>
					<td><s:property value="getTitle()" /></td>
					<td><s:property value="getBody()" /></td>
					<td><s:property value="getMark()" /></td>
					<td>
						<a href='<s:url action="download"><s:param name="idArticle" ><s:property value="getId()" /> </s:param></s:url>'>Get PDF</a>
					</td>
				</tr>
			</s:iterator>
		</table>
	
	</div>
</body>
</html>