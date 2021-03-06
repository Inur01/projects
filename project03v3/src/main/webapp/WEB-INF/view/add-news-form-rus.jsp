<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Форма добавления новостей</title>
<style>
   <%@include file='css-news-managment.css' %>
</style>
</head>
<body>
	<div id="languagesForAdd" style="display: inline-block;">
		<div style="display: inline-block;">
			<a href="add">English</a>
		</div>
		&nbsp;
		<div style="display: inline-block;">
			<a href="add-rus">Russian</a>
		</div>
	</div>
	<%request.setCharacterEncoding("utf-8"); %>
	<br/>
	<form:form action="processAddNews-rus" modelAttribute="addNewsModel" method="post">
	
		Заглавие: <form:input placeholder="newsTitle" path="newsTitle" />
				<form:errors path="newsTitle" cssClass="error" />
		<br />
		<br />

		Дата: <form:input placeholder="Date" path="newsDate"/>
					<form:errors path="newsDate" cssClass="error" /> (дд/мм/гггг) <!--<c:out value="${Date.date}"/>-->
		<br />
		<br />
		<!--  <input  name='fieldSearch' id='fieldSearch' type='text' value='<%=request.getParameter("fieldSearch")%>' size=45 /><input type='button' value='Поиск' onclick='goSearch()' />-->
		
		Кратко:	<br/><form:textarea  style="width:740px; height:80px" placeholder="brief" path="brief" />					 
					<form:errors path="brief" cssClass="error" /> 
		<br />
		<br />
		Детально: <br/><form:textarea style="width:740px; height:80px" placeholder="content" path="content" />
					<form:errors path="content" cssClass="error" />
		<br />
		<br />
		<input type="submit" value="Сохранить" />

	</form:form>

	<br />
<form action="mainpage-rus" ><button type="submit">Назад</button></form>
</body>
</html>