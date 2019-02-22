<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="UTF-8" %>

<html>
<head>
	<title>Home</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#aa").click(function(){
		var data = {"targetid":"user1","sender":"user2","message":"Hello"};
		$.ajax({
			type:"POST",
			url:"/controller/messages/", //프로젝트 이름.. "browswer"에서 실제로 타고가는 이름이다 -> 확인할려면 tomcat 들어가서 module 들어가서 보면 됨
			contentType:"application/json;charset=UTF-8",
			dataType:"JSON",
			data:JSON.stringify(data), //JSON 형태의 data를 String으로 변환 하는 것 
			success:function(data){
				
			},
			error:function(e){
			}
		})
	})
})//document.ready
	
</script> 
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="sample/ex01?name=AAA&age=10">ex01</a>
<a href="sample/ex02?name=BBB&age=20">ex02</a>
<a href="sample/ex021?name=CCC&age=30">ex021</a>
<a href="sample/ex02List?ids=111&ids=222&ids=333">ex02List</a>
<a href="sample/ex04?name=DDD&age=40&page=1">ex4</a>
<a href="sample/ex041?name=EEE&age=50&page=2">ex41</a>
<a href="sample/ex06">ex06(json)</a>
<a href="sample/ex07">ex07(responseEntity)</a><br><br><br><br>
<a href="testTx">testTx</a>
<button id="aa">클릭</button>
</body>
</html>
