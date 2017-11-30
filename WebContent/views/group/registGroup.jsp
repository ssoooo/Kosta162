<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>모임 생성 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
	</head>
	<body class="no-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
						<div id="logo">
							<h1><a href="index.html">알뜰총雜</a></h1>
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
									<h2>모임 생성</h2>
									<div class="table-responsive">
										<div class="well">
											<form action="${pageContext.request.contextPath}/article/regist.do"
													class="bs-example form-horizontal" method="POST">
												<fieldset>
													<div class="form-group">
														<h3>모임 명</h3>
														<div class="col-lg-10">
															<input type="text" name="title" class="form-control">
														</div>
													</div>
													<br/>
													<div class="form-group">
														
															<h3>총무 계좌</h3>
															<select>
																<option selected> 은행 선택 </option>
																<option>국민</option>
																<option>우리</option>
																<option>신한</option>
																<option>농협</option>
																<option>카카오</option>
															</select>
																													<br/>
														<div class="col-lg-10">
																<input type="text" name="title" placeholder="계좌를 입력해주세요" class="form-control">
														</div>
													</div>
													<br/>
													<div class="form-group">
														<h3>모임 소개</h3>
														<div class="col-lg-10">
															<textarea class="form-control" name="contents" rows="2" id="textArea"></textarea>
														</div>
													</div>
													<br />
													<div class="form-group">
														
															<h3>멤버</h3>
															<input type="button" class="btn_invite" value="멤버초대" onclick="window.open('inviteMember.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')"/>
														
														<div class="col-lg-10">
															<textarea class="form-control" name="contents" rows="2" id="textArea"></textarea>
														</div>
													</div>
													<br/>
													<div class="form-group">
														<div class="col-lg-10 col-lg-offset-2">
															
																<h3>대표 사진</h3>

															<form action="uploadFile.do" method="post"enctype="multipart/form-data">
																<input type="file" name="file" />
															</form>
															<div class="col-lg-10">
																  <img src="assets/css/images/bonobono.jpg" style="max-width:800px;"/>
															</div>
														</div>
													</div>
										
													<br/>
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
			<script src="assets/js/main.js"></script>

	</body>
</html>