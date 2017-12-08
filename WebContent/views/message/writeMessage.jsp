<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>메시지</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="no-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="index.html">Verti</a>
					</h1>
					<span>Kosta 162기 > 가을 MT</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<h2>메시지</h2>
						<hr>
						<form>
							<table id="message">
								<tbody>
									<tr>
										<th>발신인</th>
										<td>백민지</td>
									</tr>
									<tr>
										<th>수신인</th>
										<td>이호정, 양희수, 성우형</td>
									</tr>
									<tr>
										<th>제목</th>
										<td><input class="input_title" type="text" name="title"></td>
									</tr>
									<tr>
										<div id="input_content">
											<th>내용</th>
											<td><textarea rows="4" cols="50" style="resize: none"></textarea>
											</td>
										</div>
									</tr>
								</tbody>
							</table>
							<input class="btn_send" type="submit" value="전송">
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->


	</div>

</body>
</html>
