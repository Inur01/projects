<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page    session="false" 
            import="java.util.*"
            errorPage="/news-management.jsp" 
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Управление новостями</title>
<style>
   <%@include file='css-news-managment.css' %>
</style>
</head>
<body>
	<div id="newsHeader"><h2>Управление новостями</h2>
		<div id="startlanguages">
			<div id="english" style="display: inline-block;">
				<a href="mainpage">English</a>
			</div>
			<div style="display: inline-block;">
				<a href="mainpage-rus">Russian</a>
			</div>
		</div>
	</div>
	<%request.setCharacterEncoding("utf-8"); %>
	<div id="block1-rus" style="display: inline-block;">
		<div id="block1a">Новости</div>
			<div id="block1b-rus">
				<ul id="ul1">
					<li id="str1-rus"><a href="/project03v3/startpage/mainpage-rus">Список новостей</a></li>
					<li id="str2-rus"><a href="/project03v3/startpage/add-rus">Добавить новость</a></li>
				</ul>
			</div>
	</div>

	<div id="newscontainer" style="display: inline-block;">
		<form:form  action="/project03v3/startpage/processCheckbox-rus" modelAttribute="DeleteList">	
		<c:forEach items="${firstPageList}" var="list">
			<table id="string">
			<tr id="string">
				<td id="newsTitle"><!-- #${list.id}</br> --><b>Заголовок:    <c:out value="${list.newsTitle}"/></b></td>
				<td id="NewsDate"><u> <br/> <c:out value="${list.newsDate}"/></u></td>
			</tr>
			<tr>
				<td id="brief">Brief:<br/> <c:out value="${list.brief}"/></td>
			</tr>	
			<tr>

				<td id="actions" >
					<div style="display: none;">
						<form action="/project03v3/startpage/view-rus" method="post">
							<button title="view" id="viewButtonField" name="id" type="submit" value="${list.id}">подробнее</button>
						</form>
					</div>
					<div style="display: inline-block;">
						<form action="/project03v3/startpage/view-rus" method="post">
							<button title="view" id="viewButtonField" name="id" type="submit" value="${list.id}">подробнее</button>
						</form>
					</div>
					
					<div style="display: inline-block;">
						<form action="/project03v3/startpage/edit-rus" method="post">	
							<button title="edit" id="editButtonField" name="id" type="submit" value="${list.id}">редактировать</button>
						</form>
					</div>
				</td>
				
				<td>
					<form:checkbox  checked="checked" path="checkedId" value="${list.id}"/>Удалить 
				</td>
				
			</tr>			
			</table>
			<br/>
		</c:forEach>
			<input title="delete"  name="id" type="submit" value="Удалить все отмеченные"/>		
		</form:form>
	</div>

</body>
</html>