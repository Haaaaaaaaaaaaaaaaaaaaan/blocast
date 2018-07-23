<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

	
<script>
	$(document).ready(function() {
		function display(data) {
			var result = '';
			$(data).each(function(index) {
				console.log($(this).attr('title'));
			});
		}

		$('.cname').click(function() {

			var cid = $(this).attr('name');
			var classid = {
				"classid" : cid
			};
			$.ajax({
				url : 'qnalist.bc',
				data : classid,
				success : function(data) {
					display(data);
				},
				error : function() {
					alert("error");
				}
			});

		});
	});
</script>






<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<h1 class="mt-4 mb-3">
		QnA <small>Ask Anything!</small>
	</h1>

	<ol class="breadcrumb">
		<div class="col-lg-8">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for...">
				<span class="input-group-btn">
					<button onclick="search();" class="btn btn-default" type="button">검색하기</button>
				</span>
			</div>
		</div>
		<div class="col-lg-3">
			<div class="input-group">
					<button class="btn btn-default" type="button"><a href="write.bc">질문하기</a></button>
			</div>
		</div>
	</ol>

	<!-- Content Row -->
	<div class="row">
		<!-- Sidebar Column -->
		<div class="col-lg-3 mb-4">
			<div class="list-group">
				<button class="list-group-item cname" name="1">블록체인</button>
				<button class="list-group-item cname" name="2">빅데이터</button>
				<button class="list-group-item cname" name="3">IOT</button>
			</div>
		</div>
		
		<div class="col-lg-9 mb-4" id="qnas"></div>
	</div>
	

</div>



<!-- Bootstrap core JavaScript -->

<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>





	