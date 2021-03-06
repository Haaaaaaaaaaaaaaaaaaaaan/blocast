<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic|Source+Sans+Pro" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>

</script>

<style>
</style>
<script>
	$('#upload').bind("click",function(){
		
		var code = $('#preview').html().split('&lt;').join('<').split('&gt;').join('>');
		var filename = $('#filename').val();
		var subject = $('#subject').val();
		var day = $('#day').val();
		$.ajax({
			url:'codeupload.bc',
			method:'POST',
			data: {'code': code,
				   'filename': filename,
				   'subject': subject,
				   'day': day
			},
			success:function(data){
				var str = '';
				for(var i=0; i<data.length;++i){
 					var code = data[i].code.split('<').join('&lt;').split('>').join('&gt;');
					

 					str+='<div class="card"><div class="card-header" role="tab" id="h'+index+'"><h5 class="mb-0">';
 					str+='<a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="false" aria-controls="c'+index+'">';
 					str+=data[i].fileName;  
 					str+='</a></h5></div><div id="c'+index+'" class="collapse" role="tabpanel" aria-labelledby="h'+index+'><div class="card-body">';
 					str+=data[i].code.split('<').join('&lt;').split('>').join('&gt;'); 
 					str+='</div></div></div>';
 					index++;
				//$('#getcode').html(code);
				}
 				$(str).appendTo($('.mb-4'));
				//alert(data[0].code);
// 				$(data).each(function(index){
// 					alert(data[i].fileName);
// 					alert(data[i].code.split('<').join('&lt;').split('>').join('&gt;'));
// 					alert(data[i].folder);
// 				});
// 				var str =''

// 				str+='<div class="card"><div class="card-header" role="tab" id="h'+index+'"><h5 class="mb-0"><a data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="false" aria-controls="c'+index+'" class="collapsed">';
// 				str+=data[0].filename;
// 				str+='</a></h5></div>';
// 				str+='<div id="c'+index+'" class="collapse" role="tabpanel" aria-labelledby="h'+index+'" style=""><div class="card-body"><pre>';
// 				str+=data[0].code.split('<').join('&lt;').split('>').join('&gt;');
// 				str+='</pre></div></div></div>';
				
// 				str+='<div class="card"><div class="card-header" role="tab" id="h'+index+'"><h5 class="mb-0"><a data-toggle="collapse" data-parent="#accordion" href="#c'+index+'" aria-expanded="false" aria-controls="c'+index+'" class="collapsed">'+data[0].filename+'</a></h5></div>';
// 				str+='<div id="c'+index+'" class="collapse" role="tabpanel" aria-labelledby="h'+index+'" style=""><div class="card-body"><pre>';
// 				str+= data[0].code.split('<').join('&lt;').split('>').join('&gt;');
// 				str+='</pre></div></div></div>';
				//$('#getcode').html(data[0].code.split('<').join('&lt;').split('>').join('&gt;'));
				//$('#accordion').html(str);
				//$().appendTo();
				//$(str).appendTo($('.mb-4'));
				//index++;
			},
			error:function(request,status,error){
                alert("ajax통신 실패!!!");
            },
			dataType:'json'
		});
	});
});
</script>

<div class="container">
 <!-- Page Heading/Breadcrumbs -->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="index.html">Home</a>
        </li>
        <li class="breadcrumb-item active">Code</li>
        <li class="breadcrumb-item active">BlockChain</li>
        <li class="breadcrumb-item active">Day01</li>
      </ol>
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
              <a href="blockchainday01.bc" id="day01">day01</a><br>
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
              <a href="bigdatanocode.bc" style="font-family: 'Nanum Gothic', sans-serif;">아직 올라온 코드가 없습니다 ㅠ_ㅠ</a>
						
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
              <a href="iotnocode.bc" style="font-family: 'Nanum Gothic', sans-serif;">아직 올라온 코드가 없습니다 ㅠ_ㅠ</a>
						
            </div>
          </div>
        </div>
        
                 <div class="card">
         <div class="card-header" role="tab" id="headingThree">
         </div>
         </div>
        
        	</div>
	</div>
        
        <div class="col-sm-8">
			<ol class="breadcrumb">
	 <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	 <div class="card">
          <div class="card-header" role="tab" id="headingFour">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour" style="font-family: 'Nanum Gothic', sans-serif;">LGTV.java
              </a>
            </h5>
          </div>
          <div id="collapseFour" class="collapse" role="tabpanel" aria-labelledby="headingFour">
            <div class="card-body">
	<pre>
	package tv;

	public class LGTV {
	public void powerOn() {
		System.out.println("LGTV On");
	}
	public void powerOff() {
		System.out.println("LGTV Off");
	}
	}
	</pre>
             </div>
          </div>
        </div>
        </div>
        
         <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	 <div class="card">
          <div class="card-header" role="tab" id="headingFive">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive" style="font-family: 'Nanum Gothic', sans-serif;">SAMSUNGTV.java
              </a>
            </h5>
          </div>
          <div id="collapseFive" class="collapse" role="tabpanel" aria-labelledby="headingFive">
            <div class="card-body">
	<pre>
	package tv;


	public class SamsungTV{
	public void powerOn() {
		System.out.println("SamsungTV On");
	}
	public void powerOff() {
		System.out.println("SamsungTV Off");
	}

	}

	</pre>
             </div>
          </div>
        </div>
        </div>
        
                 <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	 <div class="card">
          <div class="card-header" role="tab" id="headingSix">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix" style="font-family: 'Nanum Gothic', sans-serif;">TVUSER.java
              </a>
            </h5>
          </div>
          <div id="collapseSix" class="collapse" role="tabpanel" aria-labelledby="headingSix">
            <div class="card-body">
	<pre>
	package tv4;

	import org.springframework.context.support.AbstractApplicationContext;
	import org.springframework.context.support.GenericXmlApplicationContext;

	public class TVUser {

	public static void main(String[] args) {
		// 스프링 이용해서 ioc를 구현해보자(역제어)
		// 먼저 spring container 가동
		System.out.println("Start Application.......");
		AbstractApplicationContext factory = new GenericXmlApplicationContext("spring.xml");
		System.out.println("Start Bean Factory........");
		
		//spring에서 stv를 가져온다. 왜이러냐?
		//여기서 new samsungtv new lgtv 할 필요가 없기 때문!
		//맨날 새로 new 해서 만드는 뻘짓 안해도 된다.
		TV tv = (TV)factory.getBean("stv");
		System.out.println("Maked Bean.......");
		tv.powerOn();
		tv.powerOff();
		//맨날 새로 new 해서 만드는 뻘짓 안해도 된다.
		TV tv2 = (TV)factory.getBean("stv");
		System.out.println("Maked Bean 2.......");
		tv2.powerOn();
		tv2.powerOff();
		//myspring에 scope=singleton 해주면 tv2는 이용 안하고 tv를 두번 이용한다.
		//scope는 컨테이너 운영의 기본 원칙임.
		//init-method="initS" destroy-method="destroyS"
		//lazy-init="true"
	
		factory.close();
	}
	}

	</pre>
             </div>
          </div>
        </div>
        </div>
        
                 <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
	 <div class="card">
          <div class="card-header" role="tab" id="headingSeven">
            <h5 class="mb-0">
              <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven" style="font-family: 'Nanum Gothic', sans-serif;">myspring.xml
              </a>
            </h5>
          </div>
          <div id="collapseSeven" class="collapse" role="tabpanel" aria-labelledby="headingSeven">
            <div class="card-body">
	<xmp>
	<?xml version="1.0" encoding="UTF-8"?>
	<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
			http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="ltv" class="tv4.LGTV"></bean>
	</beans>
	</xmp>
             </div>
          </div>
        </div>
        </div>
        
        
        
        
        
        
      		</ol>
      		<div>
      			<button type="button" class="btn btn-info btn-lg" id="upload" data-toggle="modal" data-target="#myModal">Upload</button>
		  	  	
		  	  	<!-- Modal -->
  			  	<div class="modal fade" id="myModal" role="dialog">
   			 		<div class="modal-dialog">
      			
	      				<!-- Modal content-->
	      				<div class="modal-content">
	        				<div class="modal-header">
	          					<input type="file" id="getfile" accept="text/*">
		          				<button type="button" class="close" data-dismiss="modal">&times;</button>
				  				<input type="hidden" id="filename" name="filename" value="" />
		          				<input type="hidden" id="subject" name="blockchain" value="1"/>
		          				<input type="hidden" id="day" name="day01" value="1"/>
		        			</div>
		        			<div class="modal-body">
		          				<pre id="preview" contenteditable="true" spellcheck="false">소스코드 입력</pre>
		        			</div>
		        			<div class="modal-footer">
		          				<button type="button" class="btn btn-default" id="upload" data-dismiss="modal">업로드</button>
		        			</div>
		      			</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
var file = document.querySelector('#getfile');
file.onchange = function () { 
    var fileList = file.files ;
    // 읽기
    var reader = new FileReader();
    reader.readAsText(fileList [0],"euc-kr");
    //로드 한 후
    reader.onload = function  () {
        document.querySelector('#preview').textContent = reader.result ;
    }; 
    document.querySelector('#filename').value = fileList[0].name;
}; 
</script>
