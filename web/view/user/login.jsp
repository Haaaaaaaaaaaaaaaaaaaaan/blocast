<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

<script>

var resultt = "<%=(String)request.getAttribute("resultt")%>"

if(resultt != 'null') {
	if(resultt == 'asdf') {
		alert("id 혹은 password가 틀렸습니다. 다시 입력하세요.");
	}
}
</script>

<style>
.pass_show{position: relative} 

.pass_show .ptxt { 

position: absolute; 

top: 50%; 

right: 10px; 

z-index: 1; 

color: #f36c01; 

margin-top: -10px; 

cursor: pointer; 

transition: .3s ease all; 

} 

.pass_show .ptxt:hover{color: #333333;} 

</style>
<script>
$(document).ready(function(){
$('.pass_show').append('<span class="ptxt">Show</span>');  
});
  

$(document).on('click','.pass_show .ptxt', function(){ 

$(this).text($(this).text() == "Show" ? "Hide" : "Show"); 

$(this).prev().attr('type', function(index, attr){return attr == 'password' ? 'text' : 'password'; }); 

});  
</script>


<form action="loginimpl.bc" method="POST">
<div class="container">
	<br>
	<div class="row">
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
		<div class="col-sm-10 col-md-10 col-lg-6">
		<h1 style="font-family: 'Alex Brush', cursive;">Login Page</h1>
		</div>
		
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
		<div class="col-sm-10 col-md-10 col-lg-6">
			<label>ID</label>
			<div class="form-group pass_show"> 
				<input type="text" class="form-control" placeholder="Insert id" name="id">
			</div>
			
			<label>PWD</label>
			<div class="form-group pass_show"> 
				<input type="password" class="form-control" placeholder="Insert password" name="pwd">
			</div>
			
			<div>
				<input  class="form-control" type="submit" value="LOGIN">
			</div>
			<br>
			
		</div>
		
		<div class="col-sm-1 col-md-1 col-lg-3">
		</div>
	</div>
</div>
</form>