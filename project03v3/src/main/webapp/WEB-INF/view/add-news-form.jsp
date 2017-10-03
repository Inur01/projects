<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Add News Form</title>
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
	<form:form action="processAddNews" modelAttribute="addNewsModel" method="post">
	
		Title: <form:input placeholder="newsTitle" path="newsTitle" />
				<form:errors path="newsTitle" cssClass="error" />
		<br />
		<br />

		Date: <form:input placeholder="Date" path="newsDate"/>
					<form:errors path="newsDate" cssClass="error" /> (dd/mm/yyyy)
		<br />
		<br />
		
		Brief:	<br/><form:textarea  style="width:740px; height:80px" placeholder="brief" path="brief" />					 
					<form:errors path="brief" cssClass="error" /> 
		<br />
		<br />
		Details: <br/><form:textarea style="width:740px; height:80px" placeholder="content" path="content" />
					<form:errors path="content" cssClass="error" />
		<br />
		<br />
		<input type="submit" value="Submit" />

	</form:form>

	<br />
<form action="/project03v3/startpage/mainpage"><button type="submit">Back</button></form>
</body>
</html>