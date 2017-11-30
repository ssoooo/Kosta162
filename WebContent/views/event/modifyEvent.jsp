<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
	</head>
	<body class="left-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
							  <h1><a href="main.html">알뜰총雜</a></h1>
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
						<div class="row 50%">
							<div class="4u 12u$(medium)">
								<div id="sidebar">

									<!-- Sidebar -->
										<section>
											<h2>게시판</h2>
											<ul class="style2">
												<li><a href="left-sidebar.html"><h3>전체 보기</h3></a></li>
												<li><a href="event.html"><h3>신입생 환영회<a href="eventDetail.html"><img class="event_info" src="assets/css/images/info.png"/></a></h3></a></li>
												<li><a href="no-sidebar.html"><h3>신입생 엠티</h3></a></li>
												<li><a href="no-sidebar.html"><h3>체육대회</h3></a></li>
											</ul>
												<a href="registEvent.html" class="button icon fa-info-circle">이벤트 추가</a>
											</footer>
										</section>

								</div>
							</div>
							<div class="8u 12u$(medium) important(medium)">
								<div id="content">
									<div class="col-sm-9 col-lg-9">
										<div><h3>이벤트 수정</h3></div>
										<div class="table-responsive">
											<div class="well">
												<form action="${pageContext.request.contextPath}/article/regist.do"
													  class="bs-example form-horizontal" method="POST">
													<fieldset>
														<div class="form-group">
															<label class="col-lg-2 control-label">
																<h3>이벤트명</h3>
															</label>
															<div class="col-lg-10">
																<input type="text" name="title" class="form-control">
															</div>
														</div>
														<br/>
														<div class="form-group">
															<label class="col-lg-2 control-label">
																<h3>이벤트 예산액</h3>
															</label>
															<div class="col-lg-10">
																<input type="text" name="title" class="form-control">
															</div>
														</div>
														<br/>
														<div class="form-group">
															<label class="col-lg-2 control-label">
																<h3>모임 지원금</h3>
															</label>
															<div class="col-lg-10">
																<input type="text" name="title" class="form-control">
															</div>
														</div>
														<br/>
														<div class="form-group">
															<label class="col-lg-2 control-label">
																<h3>멤버</h3>
															</label>
																<input type="button" class="btn_invite" value="멤버추가" onclick="window.open('eventMember.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')"/>
															<div class="col-lg-10">
																<textarea class="form-control" name="contents" rows="2" id="textArea"></textarea>
															</div>
														</div>
														<br />
														<div class="form-group">
															<div class="align_btn">
																<button type="submit" class="record_submit">확인</button>
																<button type="reset" class="record_cancel">취소</button>
															</div>
														</div>
													</fieldset>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
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
									<li>&copy; Untitled. All rights reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
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
