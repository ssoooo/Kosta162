<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main2.css" />
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
									<div><h3>내역 등록</h3></div>
									<div class="table-responsive">
										<div class="well">
											<form action="${pageContext.request.contextPath}/record/modifyRecord.do"
												  class="bs-example form-horizontal" method="POST" enctype="multipart/form-data">
												<fieldset>
													<div class="form-group">
														<label class="col-lg-2 control-label">
														<input type="hidden" id="pastPrice" name="pastPrice" value="${pastPrice}">
														<input type="hidden" id="pastAccounting" name="pastAccounting" value="${pastAccounting}">
															<h3>제목</h3>
														</label>
														<div class="col-lg-10">
															<input type="text" name="title" class="form-control">
														</div>
													</div>
													<br/>
													<div class="form-group">
														<label class="col-lg-2 control-label">
														  <h3>수입 및 지출(단위/원)</h3>
														  <select id="selectAccounting" name="accounting">
																<option selected>수입/지출 선택 </option>
																<option value="수입">수입</option>
																<option value="지출">지출</option>
														  </select>
														</label>
														<div class="col-lg-10">
															<input type="text" name="title" placeholder="(ex. 30,000)" class="form-control">
														</div>
													</div>
													<div class="form-group">
															<label class="col-lg-2 control-label">
															  <h3>카테고리</h3>
															  <select id="selectCategory" name="category">
																	<option selected>카테고리 선택 </option>
																	<option value="교통비">교통비</option>
																	<option value="식비">식비</option>
																	<option value="생필품">생필품</option>
																	<option value="기타">기타</option>
															  </select>
															</label>
															
														</div>
													
													<br/>
													<div class="form-group">
														<label class="col-lg-2 control-label">
															<h3>내용</h3>
														</label>
														<div class="col-lg-10">
															<textarea class="form-control" name="content" rows="2" id="textArea"></textarea>
														</div>
													</div>
													<br />
													<div class="form-group">
														<div class="col-lg-10 col-lg-offset-2">
														 <label class="col-lg-2 control-label">
															<h3>사진</h3>
														</label>
														
															<input type="file" name="imgFile" onchange="readURL(this);"/>
														
														
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
