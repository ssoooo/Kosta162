<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>모임 생성 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script type="text/javascript">
		var bank;
		
		window.onload=function(){
			var input = document.querySelector('#imgFile');
			
			if (input.files.length === 0) {
				var ranPic = "pic0" + Math.floor((Math.random() * 3) + 1) + ".jpg";
				$('#groupImage').val("${pageContext.request.contextPath}/resources/images/" + ranPic); 
			}
		}
		
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				
				reader.onload = function (e) {
					$('#imgHere').attr('src', e.target.result); 
				}
				reader.readAsDataURL(input.files[0]); 
			} 
		} 
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
							<h1><a href="${pageContext.request.contextPath}/memberGroup/main.do">알뜰총雜</a></h1>
							<span>알뜰한 총무의 잡다한 가계부</span>
						</div>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li>
										<a href="">Invitation</a>
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
													id="frm" class="bs-example form-horizontal" method="POST" enctype="multipart/form-data">
												<fieldset>
													<div class="form-group">
														<h3>모임 명</h3>
														<div class="col-lg-10">
															<input type="text" name="groupName" class="form-control" required="required">
														</div>
													</div>
													<br/>
													<div class="form-group">
														
														<h3>총무 계좌</h3>
														<select id="selectBank" name="selectBank">
															<option value="미선택">은행 선택</option>
															<option value="국민">국민</option>
															<option value="우리">우리</option>
															<option value="신한">신한</option>
															<option value="농협">농협</option>
															<option value="카카오">카카오</option>
														</select>
														<br/>
														<div class="col-lg-10">
															<input type="text" id="accountNum" name="accountNum" placeholder="계좌를 입력해주세요" class="form-control">
														</div>
														<input type="hidden" id="account" name="account" /> 
													</div>
													<br/>
													<script>
														function inputBankVals() {
															bank = $("#selectBank option:selected").text();
														}
														
														$("#selectBank").change(inputBankVals); 
														
														inputBankVals();
													</script>
													<div class="form-group">
														<h3>모임 소개</h3>
														<div class="col-lg-10">
															<textarea class="form-control" name="groupIntroduce" rows="2" id="textArea"></textarea>
														</div>
													</div>
													<br/>
													<div class="form-group">
														<div class="col-lg-10 col-lg-offset-2">
															
															<h3>대표 사진</h3>

																<input type="file" id="imgFile" name="imgFile" onchange="readURL(this);"/>
																<input type="hidden" id="groupImage" name="groupImage" value=""/>
															<div class="col-lg-10">
																  <img id="imgHere" src="" style="max-width:400px;"/>
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
															
															if($('option:selected', $(this)).val('미선택')){
																$('#account').val("미선택/" + accountNum);
															}
															
															var accountNum = $('#accountNum').val();
															$('#account').val(bank + "/" + accountNum);
															
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
