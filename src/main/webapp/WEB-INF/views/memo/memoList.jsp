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