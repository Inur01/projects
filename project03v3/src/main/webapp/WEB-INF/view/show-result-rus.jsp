<%@ page language='java' contentType='text/html; charset=UTF-8' pageEncoding='UTF-8'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Обновлённая новость</title>
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

<div style='display:none' id="test" class="toggle">
<h1>Updated news</h1>
 Title:   ${editModel.newsTitle}  <!--  Login: ${loginData.login}-->
 <br/>
 <br/>
 Date:  ${editModel.newsDate}
  <br/>
  <br/>
 Brief:  ${editModel.brief}
   <br/>
   <br/>
 Details:  ${editModel.content}
   <br/>
   <br/>
 ${editModel.id}
 
<form action="/project03v3/startpage/mainpage"><button type="submit">Back</button></form>
</div>
<!-- ______________________________________________ -->
<div style='display:non' id="test2" class="toggle">
<h1>Обновлённая новость</h1>
 Заголовок:   ${editModel.newsTitle}  <!--  Login: ${loginData.login}-->
 <br/>
 <br/>
 Дата:  ${editModel.newsDate}
  <br/>
  <br/>
 Кратко:  ${editModel.brief}
   <br/>
   <br/>
 Детально:  ${editModel.content}
   <br/>
   <br/>
 ${editModel.id}
 
<form action="/project03v3/startpage/mainpage-rus"><button type="submit">Назад</button></form>
</div>

<script type="text/javascript">
		function toggle_show(id) {
	   	var toggleElements = document.querySelectorAll(".toggle");
	   	var toogledElement = document.querySelector("#" + id);
	   	for(var i = 0; i< toggleElements.length; i++) {
	     toggleElements[i].style.display = "none"; // скрываем все
	   		}
	   toogledElement .style.display = toogledElement .style.display == 'none' ? 'block' : 'none'; // работаем с нужным блоком
		}
</script>
</body>
</html>