<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Страница редактирования</title>
<style>
   <%@include file='css-news-managment.css' %>
</style>
</head>
<body>

<div style='display:non' id="test2" class="toggle">
<br/>
<br/>
<div id="startlanguagesEdit">
		<div id="english" style="display: inline-block;">
			<form action="/project03v3/startpage/edit" method="get">	
				<button title="edit" id="editButtonField" name="id" type="submit" value="${editModel.id}">English</button>
			</form>
		</div>
		<div style="display: inline-block;">
			<form action="/project03v3/startpage/edit-rus" method="get">	
				<button title="edit" id="editButtonField" name="id" type="submit" value="${editModel.id}">Russian</button>
			</form>
		</div>
	</div>
<form:form action="show-edited-content-rus" modelAttribute="editModel" method="get">

		<!-- ID: ${editModel.id}  
		
		<br />-->
		<br />
		Заголовок: <form:input placeholder="Title" path="newsTitle" />
				<form:errors path="newsTitle" cssClass="error" />
		<br />
		<br />
	
		Дата: <form:input  placeholder="Date" path="newsDate" />
					<form:errors path="newsDate" cssClass="error" />(dd/mm/yyyy) 
		<br />
		<br />
		Кратко: <br />
				<form:textarea style="width:400px; height:80px" placeholder="brief" path="brief"/>					 
					<form:errors path="brief" cssClass="error" />
		<br />
		<br />
		Детально: <br/>
		<br/>
		<form:textarea style="width:400px; height:80px" placeholder="details" path="content"/>	
					 <form:errors path="content" cssClass="error" />
		<br />
		<br />
		<button type="submit" id="backToStartPage" name="idForUpdate" value="${editModel.id}">Сохранить</button>
</form:form>
	<br/>
<form action="/project03v3/startpage/mainpage-rus"><button type="submit">Отменить</button></form>
</div>

</body>
</html>