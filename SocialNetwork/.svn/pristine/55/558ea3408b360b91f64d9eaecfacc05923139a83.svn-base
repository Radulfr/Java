<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Publication Details</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<body>
<h2>Publication Details</h2>
<hr>
<jsp:include page="header.jspf"></jsp:include>
<hr>
<table border="1">
<tr><td><b>ID</b></td><td><s:property value="article.getId()" /></td></tr>
<tr><td><b>Owner</b></td><td><s:property value="article.getId_author()" /></td></tr>
<tr><td><b>Dated</b></td><td><s:property value="article.getPublishing_date()" /></td></tr>
<tr><td><b>My Comments</b></td><td><s:property value="article.getComment_author()" /></td></tr>
<tr><td><b>Mark</b></td><td><s:property value="article.getMark()" /></td></tr>
<tr><td><b>State</b></td><td><s:property value="article.getState()" /></td></tr>
<tr><td><b>PDF</b></td><td><a href='<s:url action="download"><s:param name="idArticle" ><s:property value="article.getId()" /></s:param></s:url>'><s:property value="article.getBody()" /></a></td></tr>
</table>
<hr>
<h4>Leave new comment</h4>
<s:form action="leavecomment">
<s:textfield name="comment" label="Comment" />
<s:submit value="Leave a comment" />

</s:form>
<hr>
<s:if test="!article.getState().equals(reviewed)" >
<h4>Cancel a review</h4>
<s:form action="cancelreview">
<s:submit value="Cancel review" />
</s:form>
</s:if>
</body>
</html>