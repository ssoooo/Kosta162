<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="uploadFile.do" method="post", enctype="multipart/form-data">
	file<input type="file" name="file"/>
	name<input type="text" name="name"/>
	<input type="submit" value="upload"/>
</form>

</body>
</html>