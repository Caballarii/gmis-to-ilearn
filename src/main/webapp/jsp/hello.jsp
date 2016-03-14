<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>API test</title>
<script type="text/javascript" src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$("#btnGet").click(function(){
		var userName=$("#userName").val();
		$.ajax({
			url:"http://localhost:8080/gmis-to-ilearn/gmis/v1/user/"+userName,
			type:'GET',
			dataType:'json'
		}).done(function(data,status,xhr){
			if(data.msg!="success"){
				alert(data.msg);
			}
			$("#userId").val(data.userId);
			$("#password").val(data.passwordHash);
		}).fail(function(xhr,status,error){
			alert("查无此用户");
		});
	});
	
	$("#btnDelete").click(function(){
		var userId=$("#userId").val();
		$.ajax({
			url:"http://localhost:8080/gmis-to-ilearn/gmis/v1/user/"+userId,
			type:'DELETE',
			dataType:'json'
		}).done(function(data,status,xhr){
			alert(data.msg);
		}).fail(function(xhr,status,error){
			alert("删除失败");
		});
	});
	$("#btnAdd").click(function(){
		$.ajax({
			url:"http://localhost:8080/gmis-to-ilearn/gmis/v1/user",
			type:'POST',
			dataType:'json',
			data:{userName:$("#userName").val(),passwordHash:$("#password").val()}
		}).done(function(data,status,xhr){
			if(data.msg=="success"){
				$("#userId").val(data.userId);
			}
			else{
				alert(data.msg);
			}
		}).fail(function(xhr,status,error){
			alert("删除失败");
		});
	});
	$("#btnUpdate").click(function(){	
		var saveData={"userId":$("#userId").val(),"userName":$("#userName").val(),"passwordHash":$("#password").val()};
		$.ajax({
			url:"http://localhost:8080/gmis-to-ilearn/gmis/v1/user",
			type:'PATCH',
			dataType:'json',
			contentType:"application/json",
			//data:{_method:"put","userId":$("#userId").val(),"userName":$("#userName").val(),"passwordHash":$("#password").val()}
			data:JSON.stringify(saveData)
		}).done(function(data,status,xhr){
			alert(data.msg);
		}).fail(function(xhr,status,error){
			alert("更新失败");
		});
	});
});
</script>
</head>
<body>
<a href="#" id="btnGet">查询</a>&nbsp;&nbsp;<a href="#" id="btnDelete">删除</a>&nbsp;&nbsp;<a href="#" id="btnAdd">添加</a>&nbsp;&nbsp;<a href="#" id="btnUpdate">更新</a><br/>
userId:<input type="text" name="userId" id="userId"/><br/>
userName:<input type="text" name="userName" id="userName"/><br/>
password:<input type="text" name="password" id="password"/><br/>
</body>
</html>