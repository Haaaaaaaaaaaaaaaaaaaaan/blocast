<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="en">
<html>
<head>
<meta charset="EUC-KR">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>멀티캠퍼스 Blocast</title>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<nav
		class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="main.bc">BLOCAST</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="main.bc">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="codelist.bc">Code</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="qna.bc">QnA</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="about.bc">About</a>
					</li>
			<c:choose>
				<c:when test="${loginid == null }">
					<li class="nav-item"><a class="nav-link" href="login.bc">Login</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="register.bc">SignUp</a>
					</li>
				</c:when>
				<c:otherwise>	
					<li><a href="logout.hw">LOGOUT</a></li>
					<li>${loginid } 님 </li>
				</c:otherwise>
			</c:choose>
				</ul>
			</div>
		</div>
	</nav>
	<section>
		<c:choose>
			<c:when test="${centerpage != null}">
				<jsp:include page="${centerpage}.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="center.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</section>
	  <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Blockchain 1Jo, 2018</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
</html>