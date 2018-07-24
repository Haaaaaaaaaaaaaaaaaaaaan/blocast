<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<style>
.hoverable:hover{
	box-shadow: 0 0 0 2px rgba(0, 0, 0, 0.2);
	transition: all 200ms ease-out;
}
</style>
<script>
	$(document).ready(function() {
		
		
		$('.search').click(function(e){
			e.preventDefault();
			var keyword = $('[name=keyword]').val();
			if(keyword==''){
				alert('검색어를 입력하지 않으셨어요!');
				return;
			}
			$('form').submit();
		});
		
		
		$('.qbtn').click(function(){
			location.href="write.bc";
		});
		
		function display(data) {
			var result = '';
			
			$(data).each(function(index) {
				result+='<div id="'+$(this).attr('id')+'"class="card mb-1 hoverable">';
				result+='<div class="card-header" role="tab" data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="true" aria-controls="collapseOne">';
				result+='<h5 class="card-title">';
				result+=$(this).attr('title');
				result+='</h5>';
				result+='</div>';//card-header
				
				result+='<div id="c'+index+'" class="collapse" role="tabpanel">';
				
				
				result+='</div>';//collapse
				result+='<div class="card-footer text-muted">작성자 : ';
				result+=$(this).attr('author');
				result+='</div>';//card-footer
				result+='</div>';//card
				
			  
				
			    
			});
			$('.qnas').html(result);
			
			$('.card').click(function(){
				var qid = $(this).attr('id');
				var id = {
						"qid" : qid
					};
				$.ajax({
					url : 'tlist.bc',
					data : id,
					success : function(data) {
						alert(data);
					},
					error : function(request,status,error){
				        alert("getTag AJAX 에러에요!\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    },
				    dataType: 'json'
				
				});
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
				error : function(error){
			        //console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			        console.log(error);
			    },
			    dataType: 'json'
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
		<div class="row">
			<div class="col-md-9">
				<div class="input-group">
					<form action="qsearch.bc">
						<input type="text" class="form-control" name="keyword" placeholder="먼저 검색해보세요!">
						<span class="input-group-btn">
							<button class="btn btn-default search")>검색하기</button>
						</span>
					</form>
				</div>
			</div>
			<div class="col-md-3">
				<div class="input-group">
						<button class="btn btn-default qbtn" type="button">질문하기</button>
				</div>
			</div>
		</div>
	</ol>
	

	<!-- Content Row -->
<div class="row">
  <!-- Sidebar Column -->
  <div class="col-md-3 mb-4">
    <div class="list-group">
      <button class="list-group-item cname" name="1">블록체인</button>
      <button class="list-group-item cname" name="2">빅데이터</button>
      <button class="list-group-item cname" name="3">IOT</button>
    </div>
  </div>

  <div class="col-md-9 mb-4 qnas" id="accordion" role="tablist" aria-multiselectable="true">
   
  </div>
</div>
	

</div>



	