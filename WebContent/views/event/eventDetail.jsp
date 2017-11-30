<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../../resources/assets/css/main.css" />
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
								<span>Kosta 162기 > 가을 MT</span>
							</div>

						<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="main.html">Home</a></li>
							<li>
								<a href="main.html">Message</a>
								<ul class="ul_accept">
									<p class="group_invite_list">
										제목
										<div class="accept_reject">
											<a href="">보기</a>
											<a href="">삭제</a>
										</div>
									</p>
									<p class="group_invite_list">
										제목
										<div class="accept_reject">
											<a href="">보기</a>
											<a href="">삭제</a>
										</div>
									</p>
								</ul>
							</li>
							<li class="current"><a href="login.html">Logout</a></li>
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
								이벤트정보
							</h2>
							<hr>
							<table id="group_info">
								<tbody>
								<tr>
									<th class="info_first">이벤트 명</th>
									<td class="info_detail_first">가을 MT</td>
								</tr>
								<tr>
									<th class="info">이벤트 예산액</th>
									<td class="info_detail">800,000원</td>
								</tr>
								
								<tr>
									<th class="info">모임 지원금</th>
									<td class="info_detail">260,000원</td>
								</tr>
								<tr>
									<th class="info">인원</th>
									<td class="info_detail">6명</td>
								</tr>
								<tr>
									<th class="info">총 모금액(예산액-지원금)</th>
									<td class="info_detail">540,000원</td>
								</tr>
								<tr>
									<th class="info">1인당 모금액(총 모금액/인원)</th>
									<td class="info_detail">90,000원</td>
								</tr>
								<tr>
									<th class="info">실시간 모금액</th>
									<td class="info_detail">270,000원</td>
								</tr>
								</tbody>
							</table>
							<div class="btn_hor">
								<a href="eventStats.html"><button class="btn_graph">통계</button></a>
								<a href="modifyEvent.html"><button class="btn_modify">수정</button></a>
								<a href="#"><button class="btn_delete">삭제</button></a>
							</div>
						</div>
						<div id="box3">
							<h2>
								이벤트멤버
							</h2>
							<hr>
							<div class="scroll">
							<ul>
								<li class="first">
									백민지
								</li>
								<li>
									이호정
								</li>
								<li>
									양희수
								</li>
								<li>
									성우형 
								</li>
								<li>
									백민지
								</li>
								<li>
									이호정
								</li>
								<li>
									양희수
								</li>
								<li>
									이호정
								</li>
								<li>
									양희수
								</li>
								<li class="last">
									성우형
								</li>
							</ul>
							</div>
							<div class="btn_hor">
								<button class="btn_modify" onclick="window.open('collectionDetail.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">모금액</button>
								<button class="btn_invite" onclick="window.open('eventMember.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">멤버추가/제외</button>
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

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>
