<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dungeon Master App</title>
</head>
<script language="JavaScript">
	function delete_player(id) {
		document.getElementById("delplayer").value=id;
	}
</script>
<script language="JavaScript">
	function hit_player(id) {
		document.getElementById("hitplayer").value=id;
	}
</script>
<script type="text/javascript">
	function formReset(formid){
		document.getElementById(formid).reset();
	}
</script>
<script language="JavaScript">
    function hitplayer(id) {
        var item_tr = document.getElementById("hittable");
        document.getElementById("hitplayer").value=id;
        
        if (item_tr) { 
	        if (item_tr.style.display == "none") {
		        item_tr.style.display = "";

	        } else {
		        item_tr.style.display = "none";
	        }
        }
    }
	
</script>




<body bgcolor="#DDDDDD">
	<h1>Dungeons and Dragons Application</h1>
	<table border="1" bgcolor="#EEEEEE">
		<tr>
			<td><s:form action="addfighter" id="addform">
					<s:textfield label="PJ/PNJ" name="player" onFocus="this.value=''" />
					<s:textfield label="Initiative" name="init" onFocus="this.value=''" />
					<s:textfield label="Initial damage" name="idamage"
						onFocus="this.value=''" value="0" />
					<s:submit value="Add PJ/PNJ" />
				</s:form></td>
		</tr>
	</table>
	<br />
	<table border="1" bgcolor="#EEEEEE">
		<s:if test="combatlist.size()>0">
			<tr align="center">
				<td><b>Initiative</b></td>
				<td><b>PJ/PNJ</b></td>
				<td><b>Damage</b></td>
				<td><b>Delete player</b></td>
				<td><b>Hit Player</b></td>
				<td><b>Up</b></td>
				<td><b>Down</b></td>
			</tr>
		</s:if>
		<s:iterator value="combatlist" status="itStatus">
			<tr align="center">
				<td><s:property value="getInitiative()" /></td>
				<td><i><s:property value="getName()" /></i></td>
				<td><s:property value="getHitpoints()" /></td>
				<td><s:url id="link" action="delete">
						<s:param name="delplayer">
							<s:property value="getName()" />
						</s:param>
					</s:url> <s:a href="%{link}">Kill!</s:a></td>
				<td><a
					href="javascript:hitplayer('<s:property value="getName()" />')">Hit</a></td>

				<td><s:url id="link" action="up_player">
						<s:param name="move_player">
							<s:property value="getName()" />
						</s:param>
					</s:url> <s:a href="%{link}">Up</s:a>
				</td>
				<td><s:url id="link" action="down_player">
						<s:param name="move_player">
							<s:property value="getName()" />
						</s:param>
					</s:url> <s:a href="%{link}">Down</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>
	<s:if test="combatlist.size()>1">
		<table border="1" bgcolor="#EEEEEE">
			<tr>
				<td><s:form action="sort">
						<s:submit value="Sort combat list" />
					</s:form></td>
				<td><s:form action="endcombat">
						<s:submit value="Clear list" />
					</s:form></td>

			</tr>
		</table>
	</s:if>
	<br />
	<div id="hittable" style="display: none; border-top-style: none;">
		<s:if test="combatlist.size()>0">
			<table border="1" bgcolor="#EEEEEE">
				<tr>
					<td><s:form action="hit" id="hitform">
							<s:textfield label="Hit to" name="hitplayer" id="hitplayer"
								onFocus="this.value=''" />
							<s:textfield label="Damage" name="hit" onFocus="this.value=''" />
							<s:submit value="Hit" />
						</s:form></td>
				</tr>
			</table>
		</s:if>
	</div>
	<s:if test="eventlist.size()>0">
		<h4>Combat Events</h4>
		<table border="1" id="eventtable" bgcolor="#EEEEEE">
			<tr>
				<td><b>Time</b></td>
				<td><b>Event</b></td>
			</tr>
			<s:iterator value="eventlist" status="itStatus">
				<tr>
					<td><s:property value="getDate()" /></td>
					<td><s:property value="getEvent()" /></td>
				</tr>
			</s:iterator>

		</table>
	</s:if>
</body>
</html>