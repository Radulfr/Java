<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="Style.css" type="text/css" />
</head>
<script language="JavaScript">
	function getReview(reviewer) {
		document.getElementById("reviewer").value=reviewer;
	}
</script>
<script language="JavaScript">
	function deleteReviewer(revi) {
		document.getElementById("drevi").value=revi;
	}
</script>
<script language="JavaScript">
	function getRevission(articleid, reviewer) {
		document.getElementById("article").value=articleid;
		document.getElementById("revarticle").value=reviewer;
	}
</script>
<script language="JavaScript">
	function add(friendid) {
		document.getElementById("tbadd").value=friendid;
	}
</script>
<body>
<s:if test="#session.loggedin != 'true'">
            <jsp:forward page="/index.jsp" />
        </s:if>
<h1>Publisher: <s:property value="#session.user.getName()" /> <s:property value="#session.user.getSecond_name()" /></h1>
			<p align="right"><s:url id="link" action="logout" >
			</s:url>
			<s:a href="%{link}" >Logout</s:a></p>
<hr>

<h4>Notifications: </h4> 

<br/>
<s:if test="notifications.isEmpty()" >
	<table>
		<tr>
			<td>
				No notifications :)
			</td>
		</tr>	
	</table> 
</s:if>
<s:else>

	<table border="1">

		<s:iterator value="notifications" status="itStatus">
		<tr>
			<td align="center">
				<s:property value="getId()" />
			</td>
			<td align="center">
				<s:property value="getDate()" />
			</td>
			<td align="center">
				<s:property value="getNote()" />
			</td>
		</tr>
		</s:iterator>
	</table>

</s:else>
	<br />
<hr>
<jsp:include page="header.jspf"></jsp:include>
<hr>
<h4>List of Reviewers</h4>

<s:form action="getreviewers">
	<s:submit value="Get list"></s:submit>
	
		<table border="1">
			<s:iterator value="revlist" status="itStatus">
				<tr><td><s:property value="getReviewer_mail()" /></td>
				<td>
					<s:url id="link" action="getrevision" >
					<s:param name="rev"><s:property value="getReviewer_mail()" /></s:param>
					</s:url>
					<s:a href="%{link}" >Get Reviews</s:a>
				
				</td>
				<td>
					<s:url id="link" action="delreviewer" >
						<s:param name="revdel"><s:property value="getReviewer_mail()" /></s:param>
					</s:url>
					<s:a href="%{link}" >Delete Reviewer</s:a>

				</td>
				</tr>
			</s:iterator>
		</table>
		
		<s:if test="results==true">
			<table border="1">
			<tr><td><b>Article Id</b></td><td><b>State</b></td><td><b>Reviewer</b></td><td><b>Comment</b></td><td><b>Date</b></td><td><b>Mark</b></td><td><b>Link</b></td></tr>
					<s:iterator value="revs" status="itStatus">
						<tr><td><s:property value="getIdArticle()" /></td><td><s:property value="getState_review()" /></td><td><s:property value="getReviewer_mail()" /></td><td><s:property value="getComment()" /></td><td><s:property value="getReview_date()" /></td><td><s:property value="getMark()" /></td>
						<td>
						
						<s:url id="link" action="articleDetailsRes" >
						<s:param name="idDetailsRes" ><s:property value="getIdArticle()" /></s:param>
						</s:url>
						<s:a href="%{link}" >Link to Article</s:a>
						</td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
</s:form>
<br />
<hr>

<br />

<h4>Manage List</h4>
<table >
<tr>
<td>

<h5>Add Reviewer</h5>
<s:form action="addreviewer">
	<s:textfield name="addreviewer" id="tbadd" label="Reviewer's ID" />
	<s:submit value="Add"></s:submit>
</s:form>
</td>
<td>
<s:form action="publisearchid">
<h5>Search Reviewer by ID</h5>
<s:textfield name="searchid" label="Looking for ID" />
<s:submit value="Search" />
</s:form>
<s:form action="publisearchtag">
<h5>Search Reviewer by TAG</h5>
<s:textfield name="tag" label="Looking for TAG" />
<s:submit value="Search" />
</s:form>
</td>
	
	<s:if test="found==true">
	<td>
		<h4>Found:</h4>	 
		
		<p>
		<s:property value="userfound" /> -	
			<s:url id="link" action="addreviewer" >
				<s:param name="addreviewer"><s:property value="userfound" /></s:param>
			</s:url>
			<s:a href="%{link}" >Add Reviewer</s:a>
			
		</p>
	</td>
	</s:if>	

	<s:if test="foundtag==true">
	<td>
		<h4>Found:</h4>
		<ul>
				<s:iterator value="friendlisttag" status="itStatus">
					<li><s:property value="getReviewer_mail()" /> - 
					<s:url id="link" action="addreviewer" >
					<s:param name="addreviewer"><s:property value="getReviewer_mail()" /></s:param>
					</s:url>
					<s:a href="%{link}" >Add Reviewer</s:a>	
				 	</li>
				</s:iterator>
		</ul>	
	</td>		
	</s:if>
	
</tr>
</table>
</body>
</html>