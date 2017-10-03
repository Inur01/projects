<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
<title>Delete confirmation</title>
<style>
   <%@include file='css-news-managment.css' %>
</style>
</head>
<body>
<div id="startlanguagesEdit">
		<div id="english" style="display: inline-block;">
			<div onClick="toggle_show('test')">English  \  </div>
		</div>
		<div style="display: inline-block;">
			<div onClick="toggle_show('test2')">Russian</div>
		</div>
</div>
<div style='display:non' id="test" class="toggle">
<%request.setCharacterEncoding("utf-8"); %>
		<%-- Your login: ${param.login} --%>
	<h2>Do you really want delete all checked information?</h2>
	
	<form:form action="/project03v3/startpage/delete" modelAttribute="confirmedDeletList" method="post">
		<c:forEach items="${checkboxInfo}" var="temp1" >
			<ul>
				<li>
					<b>${temp1.newsTitle}</b>
			    		${temp1.newsDate} 
			    </li>
			    </ul>
		</c:forEach>
		
	<br/>
	
	<button title="" id="viewButtonField" name="id" type="submit" value="${DeleteList.checkedId}">Delete</button>
	</form:form>
	<form action="/project03v3/startpage/mainpage"><button type="submit">Back</button></form>
</div>
<!-- ______________________________________ -->
<div style='display:none' id="test2" class="toggle">
<%request.setCharacterEncoding("utf-8"); %>
		<%-- Your login: ${param.login} --%>
	<h2>Вы действительно хотети удалить выбранную информацию?</h2>
	
	<form:form action="/project03v3/startpage/delete-rus" modelAttribute="confirmedDeletList" method="post">
		<c:forEach items="${checkboxInfo}" var="temp1" >
			<ul>
				<li>
					<b>${temp1.newsTitle}</b>
			    		${temp1.newsDate} 
			    </li>
			    </ul>
		</c:forEach>
		
	<br/>
	
	<button title="" id="viewButtonField" name="id" type="submit" value="${DeleteList.checkedId}">Удалить</button>
	</form:form>
	<form action="/project03v3/startpage/mainpage-rus"><button type="submit">Назад</button></form>
</div>

<script type="text/javascript">
		function toggle_show(id) {
	   	var toggleElements = document.querySelectorAll(".toggle");
	   	var toogledElement = document.querySelector("#" + id);
	   	for(var i = 0; i< toggleElements.length; i++) {
	     toggleElements[i].style.display = "none";
	   		}
	   toogledElement .style.display = toogledElement .style.display == 'none' ? 'block' : 'none';
		}
</script>
</body>
</html>