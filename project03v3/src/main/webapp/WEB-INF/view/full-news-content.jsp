<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
<style>
   <%@include file='css-news-managment.css' %>
</style>
</head>
<body>
<div style='display:non' id="test" class="toggle">
<h1>Title: ${viewModel.newsTitle}</h1>
	<div id="startlanguages">
		<div id="english" style="display: inline-block;">
			<form action="/project03v3/startpage/view" method="get">	
				<button title="edit" id="editButtonField" name="id" type="submit" value="${viewModel.id}">English</button>
			</form>
		</div>
		<div style="display: inline-block;">
			<form action="/project03v3/startpage/view-rus" method="get">	
				<button title="edit" id="editButtonField" name="id" type="submit" value="${viewModel.id}">Russian</button>
			</form>
		</div>
	</div>
<br/>
Date:  ${viewModel.newsDate }
<br/>
<br/>
Brief: <div>${viewModel.brief }</div>
<br/>
<br/>
Detail info: <div>${viewModel.content }</div>
<br/>
<br/>
<table>
	<tr>
		<td id="editBackButtoms" style="width:80%;">
			<div style="display: inline-block;">
				<form action="/project03v3/startpage/edit" method="get">	
					<button title="edit" id="editButtonField" name="id" type="submit" value="${viewModel.id}">Edit</button>
				</form>
			</div>
			<div style="display: inline-block;">
				<form action="/project03v3/startpage/mainpage"><button type="submit">Back</button></form>
			</div>
		</td>	
		<td>
			<form:form  action="/project03v3/startpage/processCheckbox" modelAttribute="DeleteList">
				<form:checkbox id="checkboForHide" checked="checked" path="checkedId" value="${viewModel.id}"/>
				<input title="delete"  name="id" type="submit" value="Delete"/>		
			</form:form>
		</td>
	</tr>
</table>
</div>
</body>
</html>