<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
	</head>
	<body class="no-sidebar">
		<div id="page-wrapper">

 
			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">
 

						<!-- Logo -->
							<div id="logo">
								<h1><a href="main.html">Verti</a></h1>
								<span>알뜰한 총무의 잡다한 가계부</span>
							</div>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li>
										<a href="main.html">Invitation</a>
										<ul class="ul_accept">
											<p class="group_invite_list">
												모임명
												<div class="accept_reject">
													<a href="">수락</a>
													<a href="">거절</a>
												</div>
											</p>
											<p class="group_invite_list">
												보노보노
												<div class="accept_reject">
													<a href="">수락</a>
													<a href="">거절</a>
												</div>
											</p>
										</ul>
									</li>
									<li><a href="main.html" >logout</a></li>
									<form class="form_search">
										<li class="search_div">
											<input type="text" style="width:160px; height:40px; margin-right:10px; float:left; margin-top:10px;">
											<input class="current" type="submit" style="background-color:#444; height:40px; float:left; margin-top:10px; font-size:9pt;" value="검색">
										</li>
									</form>
								</ul>
							</nav>
					</header>
				</div>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div id="content">
							
							<!-- Content -->
							<div id="box1">
							<h2>
								멤버정보
							</h2>
							<hr>
							<table id="group_info">
								<tbody>
								<tr>
									<th class="info_first">아이디</th>
									<td class="info_detail_first">${member.memberId }</td>
								</tr>
								<tr>
									<th class="info">별명</th>
									<td class="info_detail">밍</td>
								</tr>
								
								<tr>
									<th class="info">이름</th>
									<td class="info_detail">백민지</td>
								</tr>
								<tr>
									<th class="info">이메일</th>
									<td class="info_detail">jee@kosta.com</td>
								</tr>
								<tr>
									<th class="info">계좌번호</th>
									<td class="info_detail">123-13-142511</td>
								</tr>
								<tr>
									<th class="info">휴대폰번호</th>
									<td class="info_detail">010-2543-1321</td>
								</tr>
								<tr>
									<th class="info">가입한 모임</th>
									<td class="info_detail"><a href="main.html">5</a>개</td>
								</tr>
								</tbody>
							</table>
							<div class="btn_hor">
								<a href="modifyMember.html"><button class="btn_modify">수정</button></a>
								<a href="#"><button class="btn_delete">탈퇴</button></a>
							</div>
						</div>

						<br class="clear" />
						</div>
					</div>
				</div>

			<!-- Footer -->
				<div id="footer-wrapper">
					<footer id="footer" class="container">
						<div class="row">
							<div class="12u">
								<div id="copyright">
									<ul class="menu">
										<li>&copy; Untitled. All rights reserved</li><li>Design: HO&MIN</li>
									</ul>
								</div>
							</div>
						</div>
					</footer>
				</div>

 
			</div>
 
		<!-- Scripts -->
 

			<script src="../resources/assets/js/jquery.min.js"></script>
			<script src="../resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="../resources/assets/js/skel.min.js"></script>
			<script src="../resources/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../resources/assets/js/main.js"></script>

	</body>
</html>