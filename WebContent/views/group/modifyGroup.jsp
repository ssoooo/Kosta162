<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>모임 수정 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main2.css" />
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script>
		var bank;
		
		$(document).ready(function(){
		    $("select option[value='${bank }']").attr("selected", true);
			bank = $('option:selected', $(this)).val();
		});
		
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
							<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
							<span>${group.groupName }</span>
						</div>

						<!-- Nav -->
							<nav id="nav">
							  <ul>
								<li><a href="main.html">Home</a></li>
								<li>
									<a href="main.html">Message</a>
									<ul class="ul_accept">
									<c:forEach items="${messages }" var="message" >
										<p class="group_invite_list">
											${message.title }
											<div class="accept_reject">
												<a href="">보기</a>
												<a href="">삭제</a>
											</div>
										</p>
									</c:forEach>
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
									<h2>모임 수정</h2>
									<div class="table-responsive">
										<div class="well">
											<form action="${pageContext.request.contextPath}/memberGroup/modifyGroup.do"
													id="frm" class="bs-example form-horizontal" method="POST" enctype="multipart/form-data">
												<fieldset>
													<div class="form-group">
														<h3>모임 명</h3>
														<div class="col-lg-10">
															<input type="text" value="${group.groupName }" readonly name="groupName" class="form-control">
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
															<input type="text" id="accountNum" name="accountNum" value="${accountNum }" class="form-control">
														</div>
														<input type="hidden" id="account" name="account" /> 
													</div>
													<br/>
													<script>
														function inputBankVals() {
															bank = $('option:selected', $(this)).val();
														}
														
														$("#selectBank").change(inputBankVals); 
														inputBankVals();
													</script>
													<div class="form-group">
														<h3>모임 소개</h3>
														<div class="col-lg-10">
															<textarea class="form-control" name="groupIntroduce" rows="2" id="textArea">${group.groupIntroduce }</textarea>
														</div>
													</div>
													<br/>
													<div class="form-group">
														<div class="col-lg-10 col-lg-offset-2">
															
															<h3>대표 사진</h3>
																
																<input type="file" name="imgFile" onchange="readURL(this);"/>
																<input type="hidden" name="groupImage" value="${group.groupImage }"/>
															<div class="col-lg-10">
																  <img id="imgHere" src="${group.groupImage }" style="max-width:400px;"/>
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
														<input type="hidden" name="groupId" value="${group.groupId }" /> 
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

			<script src="../resources/assets/js/jquery.min.js"></script>
			<script src="../resources/assets/js/jquery.dropotron.min.js"></script>
			<script src="../resources/assets/js/skel.min.js"></script>
			<script src="../resources/assets/js/util.js"></script>
			<script src="../resources/assets/js/main.js"></script>

	</body>
</html>
