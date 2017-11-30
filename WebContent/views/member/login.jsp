<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Material Login Form</title>

	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">

	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
	<link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

    <link rel="stylesheet" href="../../resources/assets/css/style4.css">


</head>

<body>

<!-- Mixins-->
<!-- Pen Title-->
<div class="pen-title">
</div>
<div class="container">
  <div class="card"></div>
  <div class="card">
    <h1 class="title">Login</h1>
    <form action="login.do" method="post">
      <div class="input-container">
        <input type="text" id="memberId" name="memberId" required="required"/>
        <label for="memberId">Username</label>
        <div class="bar"></div>
      </div>
      <div class="input-container">
        <input type="password" id="userPassword" name="userPassword"required="required"/>
        <label for="userPassword">Password</label>
        <div class="bar"></div>
      </div>
      <div class="button-container">
        <button type="submit"><span>GO</span></button>
      </div>
      <div class="footer"><a href="joinForm.html">처음 방문하셨나요?</a></div>
    </form>
  </div>
  <div class="card alt">
    <div class="toggle"></div>
  </div>
</div>


</body>
</html>
