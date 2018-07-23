<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

<form action="writeimpl.bc" method="POST">
<div class="container">
	<br>
	<div class="row">
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
		<div class="col-sm-10 col-md-10 col-lg-6">
		<h1 style="font-family: 'Alex Brush', cursive;">Write Page</h1>
		</div>
		
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
		<div class="col-sm-10 col-md-10 col-lg-6">
			<label>Title</label>
			<div class="form-group"> 
				<input type="text" class="form-control" placeholder="Insert title" name="title">
			</div>
			
			<label>Content</label>
			<div class="form-group"> 
				<input type="text" class="form-control" placeholder="Insert contents" name="content">
			</div>
			
			<label>Tag</label>
			<div class="form-group"> 
				<input type="text" class="form-control" placeholder="#JAVA, #PYTHON, #SPRING" name="tag">
			</div>
			
			<div>
				<input  class="form-control" type="submit" value="WRITE">
				<input class="form-control" type="reset" value="RESET">
			</div>
			<br>
			
		</div>
		<div class="col-sm-1 col-md-1 col-lg-3">
		
		</div>
	</div>
</div>

</form>