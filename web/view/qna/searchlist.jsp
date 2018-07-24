<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
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
				result+='<div class="card-footer text-muted">�ۼ��� : ';
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
		QnA <small>�˻���� �����帱�Կ�~!</small>
	</h1>

	<div class="col">
		<div class="input-group">
			<form action="qsearch.bc">
				<input type="text" class="form-control" name="keyword" placeholder="�� �˻��غ�����!"> 
				<span class="input-group-btn">
					<button class="btn btn-default" type="submit">�˻��ϱ�</button>
				</span>
			</form>
		</div>
	</div>

	<!-- Content Row -->
	<div class="col mb-4 qnas" id="accordion" role="tablist" aria-multiselectable="true">
	<c:if test="${fn:length(qlist) == 0}">
		�˻������ �����Ф� ������ ����ϽǷ���?<br>
		<button class="btn btn-default qbtn" type="button">�����ϱ�</button>
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
			<div class="card-footer text-muted">�ۼ��� : </div>
		</div>
	</c:forEach>
	</div>
</div>



