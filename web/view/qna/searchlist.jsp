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
		//open answer func
		function collapseAnswer(answer){
			var qid = $(answer[0]).attr('qid');
			var result = '';
			if($(answer[0]).attr('author')){
				$(answer).each(function(index){
					result+='<div class="card">';
					result+='<h5> 작성자 : ';
					result+=$(this).attr('author');
					result+='</h5>';
					result+='<p>';
					result+=$(this).attr('contents');
					result+='</p>';
					result+='<p> 작성일: ';
					result+=$(this).attr('regdate');
					result+='</p>';
					result+='</div>';
				});
			}
			
			result+='<form class="answer-form" action="answer.bc">'
			result+='<div class="form-group">';
			result+='<label for="comment">답글 남기기:</label>';
			result+='<textarea class="form-control" rows="5" id="comment"></textarea>';   
			result+='<button  class="form-control ansbtn" >답변 등록하기</button>'
			result+='</div>';
			result+='</form>';
			$('#ans'+qid).html(result);
				
			$('.ansbtn').click(function(){
				var sessionId = '<%=session.getAttribute("loginid") %>';
				if(sessionId=='null'){
					location.href="login.bc";
				}else{
					$('.answer-form').submit();			
				}
			});
			
		}
		
		
		//open card function
		function collapseCard(question){
			var tags=[];
			tags = $(question).attr('tags');
			var id = $(question).attr('id');
			var result='';
			result+='<div class="card-body">';
			result+='<p>';
			result+=$(question).attr('contents');
			result+='</p>';
			result+='<p> 작성일: ';
			result+=$(question).attr('regdate');
			result+='</p>';
			
			$(tags).each(function(index){
				result+='<a class="tagbtn">';
				result+='#'+this+'';
				result+='</a>';
			});
			
			result+='<div id="'+id+'" class="alert alert-secondary colans hoverable" data-toggle="collapse" data-target="#ans'+id+'">';
			if($(question).attr('asize')==0){
				result+='답글이 아직 없네요, 답글을 등록 해볼까요?';
			}else{
				result+=$(question).attr('asize')+'개의 답글이 있습니다! 펼쳐볼까요?';
			}
			result+='</div>';
			result+='<div id="ans'+id+'" class="collapse">';
			
			result+='</div>';//collapse
			
			result+='</div>';//card-body
			$('#c'+id).html(result);
			$('.tagbtn').click(function(){
				var tagname = '';
				tagname = $(this).html();
				$('[name=keyword]').val(tagname);
				$('form').submit();
			});
			$('.colans').click(function(){
				var qid = $(this).attr('id');
				var id = {
						"qid" : qid
					};
				$.ajax({
					url : 'alist.bc',
					data : id,
					success : function(data) {
						collapseAnswer(data);
					},
					error : function(request,status,error){
 				        alert("getAnswer AJAX 에러에요!\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				    },
				    dataType: 'json'
				
				});
			});
			
			$('#c'+id).collapse();
			
		}
		
		
		
		
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
		//open card
		$('.content-toggle').click(function(){
			var qid = $(this).parents('div').attr('id');
			
			var id = {
					"qid" : qid
				};
			$.ajax({
				url : 'tlist.bc',
				data : id,
				success : function(data) {
					collapseCard(data);
				},
				error : function(request,status,error){
//				        alert("getTag AJAX 에러에요!\n"+"code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
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

			<div id="${question.id}" class="card mb-1 hoverable">
				<div class="card-header content-toggle" role="tab"
					data-toggle="collapse" data-parent="#accordion"
					href="#c${question.id}" aria-expanded="true"
					aria-controls="collapseOne">
					<h5 class="card-title">${question.title}</h5>
				</div>
				<div id="c${question.id}" class="collapse" role="tabpanel">
				</div>
				<div class="card-footer content-toggle text-muted">작성자 :
					${question.author}
				</div>
			</div>

		</c:forEach>
	</div>
</div>




