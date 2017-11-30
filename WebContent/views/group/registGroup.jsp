<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>모임 생성 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script>
			var bank;
		</script>
	</head>
	<body class="no-sidebar">
		<%@ include file="../../header/header.jspf"%>
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
											<form action="${pageContext.request.contextPath}/memberGroup/registGroup.do"
													id="frm" class="bs-example form-horizontal" method="POST">
												<fieldset>
													<div class="form-group">
														<h3>모임 명</h3>
														<div class="col-lg-10">
															<input type="text" name="groupName" class="form-control">
														</div>
													</div>
													<br/>
													<div class="form-group">
														
														<h3>총무 계좌</h3>
														<select id="selectBank" name="selectBank">
															<option selected> 은행 선택 </option>
															<option value="1">국민</option>
															<option value="2">우리</option>
															<option value="3">신한</option>
															<option value="4">농협</option>
															<option value="5">카카오</option>
														</select>
														<br/>
														<div class="col-lg-10">
															<input type="text" id="accountNum" name="accountNum" placeholder="계좌를 입력해주세요" class="form-control">
														</div>
														<input type="hidden" id="account" name="account" /> 
													</div>
													<br/>
													<div class="form-group">
														<h3>모임 소개</h3>
														<div class="col-lg-10">
															<textarea class="form-control" name="groupIntroduce" rows="2" id="textArea"></textarea>
														</div>
													</div>
													<br />
													<div class="form-group">
														
															<h3>멤버</h3>
															<input type="button" class="btn_invite" value="멤버초대" />
														<script>
														function inputBankVals() {
															bank = $('option:selected', $(this)).text();
														}
														
														$("select").change(inputBankVals); 
														
														inputBankVals();
														</script>
														<div class="col-lg-10">
															<textarea class="form-control" name="membersInvited" rows="2" id="textArea"></textarea>
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
																  <img src="../resources/assets/css/images/bonobono.jpg" style="max-width:800px;"/>
															</div>
														</div>
													</div>
										
													<br/>
													<div class="form-group">
														<div class="align_btn">
															<button id="submit" type="submit" class="record_submit">확인</button>
															<button type="reset" class="record_cancel">취소</button>
														</div>
														<script>
														function accountVals() {
															var accountNum = $('#accountNum').val();
															$('#account').val(bank + " " + accountNum);
														}
														
														$("#submit").click(accountVals); 
														
														accountVals();
														</script>
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
										<li>&copy; Untitled. All rights reserved</li><li>Design: HO&MIN</li>
									</ul>
								</div>
							</div>
						</div>
					</footer>
				</div>

			</div>

		<!-- Scripts -->

			<script src="../../resources/assets/js/jquery.min.js"></script>
			<script src="../../resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="../../resources/assets/js/skel.min.js"></script>
			<script src="../../resources/assets/js/util.js"></script>
			<script src="../../resources/assets/js/main.js"></script>

	</body>
</html>
