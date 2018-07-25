<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
				result+='<div class="card mb-1 hoverable">';
				result+='<div class="card-header" role="tab" data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="true" aria-controls="collapseOne">';
				result+='<h5 class="card-title">';
				result+=$(this).attr('title');
				result+='</h5>';
				result+='</div>';//card-header
				result+='<div class="card-body">';
				result+=$(this).attr('author');
				result+='</div>';//card-body
				result+='<div id="c'+index+'" class="collapse" role="tabpanel">';
				result+='<div class="card-body">';
				result+=$(this).attr('contents');
				result+='</div>';//card-body
				result+='</div>';//collapse
				result+='<div class="card-footer text-muted">작성자 : ';
				result+=$(this).attr('regdate');
				result+='</div>';//card-footer
				result+='</div>';//card
				
			  
				
			    
			});
			$('.qnas').html(result);
		}

		
	});
</script>






<!-- Page Content -->
<div class="container">

	<!-- Page Heading/Breadcrumbs -->
	<h1 class="mt-4 mb-3">
		QnA <small>검색결과 보여드릴게요~!</small>
	</h1>

	<div class="col">
		<div class="input-group">
			<form action="qsearch.bc">
				<input type="text" class="form-control" name="keyword" placeholder="또 검색해보세요!"> 
				<span class="input-group-btn">
					<button class="btn btn-default search">검색하기</button>
				</span>
			</form>
		</div>
	</div>

	<!-- Content Row -->
	<div class="col mb-4 qnas" id="accordion" role="tablist" aria-multiselectable="true">
	<c:if test="${fn:length(qlist) == 0}">
		검색결과가 없어요ㅠㅠ 질문을 등록하실래요?<br>
		<button class="btn btn-default qbtn" type="button">질문하기</button>
	</c:if>
	
	<c:forEach var="question" items="${qlist}">
		<div class="card mb-1 hoverable">
			<div class="card-header" role="tab" data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="true" aria-controls="collapseOne">
				<h5 class="card-title">${question.title}</h5>
			</div>
			<div class="card-body">${question.author}</div>
			<div id="c" class="collapse" role="tabpanel">
				<div class="card-body">${question.contents}</div>
			</div>
			<div class="card-footer text-muted">작성일 : </div>
		</div>
	</c:forEach>
	</div>
</div>




