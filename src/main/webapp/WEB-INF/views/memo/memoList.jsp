<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(function(){
		getList(1,'%','%');
		$("#btn").click(function(){
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			memoWrite(writer,contents);
			
		});
	});
	
	
</script>
</head>
<body>
	<form>
 <fieldset>
  <legend>납품자정보</legend>
  1. 납품자명: <input type="text" placeholder="name"><br>
  2. Email: <input type="email" placeholder="answs@naver.com"><br>
  3. 홈페이지: <input type="url" placeholder="http://">
 </fieldset>
</form>
<form>
 <fieldset>
  <legend>납품정보</legend>
   <ul>
   	<li>상품명: <input list="qq"><datalist id="qq"><option label="도그1004">dog1004</option><option label="고양이치킨">catchicken</option><option label="우유">milk</option></datalist><br></li>
   	<li>납품수량: <input type="number" step="10" min="10" max="100" placeholder="최소10이상" ><br></li>
   	<li>납품등급: <input type="range" min="0" max="10" step="2" ><br></li>
   	<li>기타사항: <textarea rows="" cols=""></textarea> <br></li>
   </ul>
  
 </fieldset>
</form>
	


	<div>
		<form action="">
			<p><input type="text" id="writer"></p>
			<p><input type="text" id="contents"></p>
			<input type="button" value="write" id="btn">
		</form>
	</div>
	<div id="result"></div>

</body>
</html>