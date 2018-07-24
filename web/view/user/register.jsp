<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro" rel="stylesheet">
<script>

var resultt = "<%=(String)request.getAttribute("resultt")%>"

if(resultt != 'null') {
	if(resultt == 'asdd') {
		alert("이미 있는 id 입니다. 다른 값을 입력해주세요.");
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
<script type="text/javascript">
    function tocheckpw2() {
        var pw = document.getElementById("Pw").value;
        var pwck = document.getElementById("PwCheck").value;
 
        if (pw != pwck) {
            document.getElementById("pwsame").innerHTML = '비밀번호가 틀렸습니다. 다시 입력해 주세요';
            return false;
        }
    }
</script>


<form action="registerimpl.bc" onsubmit="return tocheckpw2()" method="POST">
<div class="container">
	<br>
	<div class="row">
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
		<div class="col-sm-10 col-md-10 col-lg-6">
		<h3 style="font-family: 'Source Sans Pro', sans-serif; position:relative; text-align:center;">Register Page</h3>
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
		<input type="text" class="form-control" placeholder="Insert new id" name="id">
		</div>
		
		<label>PWD</label>
		<div class="form-group pass_show"> 
		<input type="password" id="Pw" class="form-control" placeholder="Insert new pwd" name="pwd">
		
		</div>
		
		<label>PWD CONFIRM</label>
		<div class="form-group pass_show"> 
		<input type="password" id="PwCheck" class="form-control" placeholder="Insert new pwd" name="pwdconfirm">
		</div>
		
		<p id="pwsame" style="color:red;"> </p>
		<br>
		
		<label>NAME</label>
		<div class="form-group pass_show"> 
		<input type="text" class="form-control" placeholder="Insert your name" name="name">
		</div>
		
		<label>GENDER</label>
		<div class="form-group pass_show"> 
		<input type="text" class="form-control" placeholder="Insert gender" name="gender">
		</div>
		
		<label>EMAIL</label>
		<div class="form-group pass_show"> 
		<input type="email" placeholder="Email" class="form-control" placeholder="You can find password and id by using this" name="email">
		</div>
		
		<div>
		<input  class="form-control" type="submit" value="REGISTER">
		</div>
		
		</div>
		<div class="col-sm-1 col-md-1 col-lg-3">
		</div>
		<br>
	</div>
	

</div>
</form>