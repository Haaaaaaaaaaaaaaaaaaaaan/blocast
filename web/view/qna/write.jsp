<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Alex+Brush" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote-bs4.js"></script>

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
			<div class="form-group"> 
				<select name="classI">
					<c:forEach var="c" items="${classInfo}">
						<option>${c.name}</option>
					</c:forEach>
				</select>
			</div>
		
			<label>Title</label>
			<div class="form-group"> 
				<input type="text" class="form-control" placeholder="Insert title" name="title">
			</div>
			
			<label>Content</label>
			<div class="form-group"> 
				<textarea id="summernote" name="content"></textarea>
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

<script>
	 $('#summernote').summernote({
	        placeholder: 'insert content',
	        tabsize: 2,
	        height: 100
	      });
</script>