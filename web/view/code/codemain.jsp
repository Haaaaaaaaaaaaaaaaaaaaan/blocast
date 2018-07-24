<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<div class="row">
  <div class="col-sm-4">
	 <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	 
	 <div class="card">
          <div class="card-header" role="tab" id="headingOne">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne" style="font-family: 'Nanum Gothic', sans-serif;">블록체인 핀테크 전문가
              </a>
            </h5>
          </div>
          <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne">
            <div class="card-body">
              <a href="blockchainday01.bc">day01</a><br>
              <a href="blockchainday02.bc">day02</a><br>
              <a href="blockchainday03.bc">day03</a><br>
             </div>
          </div>
        </div>
        
	 
	 <div class="card">
          <div class="card-header" role="tab" id="headingTwo">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo" style="font-family: 'Nanum Gothic', sans-serif;">빅데이터 분석 전문가
              </a>
            </h5>
          </div>
          <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo">
            <div class="card-body">
              <a href="" style="font-family: 'Nanum Gothic', sans-serif;">아직 올라온 코드가 없습니다 ㅠ_ㅠ</a>
						
              </div>
          </div>
        </div>
        
        
        <div class="card">
          <div class="card-header" role="tab" id="headingThree">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree" style="font-family: 'Nanum Gothic', sans-serif;">IoT 개발 전문가</a>
            </h5>
          </div>
          <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree">
            <div class="card-body">
              <a href="" style="font-family: 'Nanum Gothic', sans-serif;">아직 올라온 코드가 없습니다 ㅠ_ㅠ</a>
						
            </div>
          </div>
        </div>
	 </div>
  </div>
  		<div class="col-sm-8">
			<h4 style="font-family: 'Nanum Gothic', sans-serif; position:relative; text-align:center;">보고 싶은 코드를 왼쪽에서 고르세영.</h4>
		</div>
</div>
</body>
</html>