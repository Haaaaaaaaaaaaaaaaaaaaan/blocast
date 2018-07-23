<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
pre {
    padding: 1em;
    background: rgb(240, 240, 240);
    color: rgb(0, 0, 0);
    border-radius: .5em;
}
#getfile{
	border: .5px solid black;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#upload').bind("click",function(){
		var code = $('#preview').html().split('&lt;').join('<').split('&gt;').join('>');
		var filename = $('#filename').val();
		alert(code);
		alert(filename);
		$.ajax({
			url:'codeupload.bc',
			method:'POST',
			data: {'code': code,
				   'filename': filename
			},
			success:function(data){
				alert("업로드 성공");
			},
			error:function(err){
                alert("ajax통신 실패!!!");
                console.log(err);
            },
			dataType: 'json'
		});
	});
});
</script>
</head>
<body>
<input type="file" id="getfile" accept="text/*">
<input type="hidden" id="filename" name="filename" value="" />
<button id="upload">업로드</button>
<pre id="preview" contenteditable="true" spellcheck="false">
소스코드 입력 
</pre>
</body>
</html>
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