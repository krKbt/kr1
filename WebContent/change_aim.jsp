<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>updateAim</title>
</head>
<body align="center">
<h1>
<br><br>
<form action="/kr1/UpdateAim" method="post">
<input type="text" name="newTarget" style="height:30px;width:150px;font-size:25px">のために
<br>
<input type="text" name="newAimMoney" style="height:30px;width:100px;font-size:25px">円
<input type="submit" value ="貯める！" onClick="kakunin()" style="font-size:100px">
</form>
</h1>
<script>
function kakunin() {
	if(confirm("貯金リストがすべて消えますがよろしいですか？")){
		return true;
	}else{
		return false;
	}	
}
</script>
</body>
</html>