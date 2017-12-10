<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>이벤트 내역 등록</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main2.css" />
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script type="text/javascript">
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
	<body class="left-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
								<h1><a href="${pageContext.request.contextPath}/memberGroup/main.do">알뜰총雜</a></h1>
								<span>${group.groupName} > ${event.eventName }</span>
							</div>

						<!-- Nav -->
							<nav id="nav">
							  <ul>
								<li><a href="${pageContext.request.contextPath}/memberGroup/main.do">Home</a></li>
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
								<li class="current"><a href="${pageContext.request.contextPath}/views/member/login.jsp">Logout</a></li>
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
									<li><a
										href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=${event.groupId}"><h3>모임보기</h3></a></li>
									<c:choose>
										<c:when test="${empty events}">
											<a class="list-group-item hidden-xs">개설된 이벤트가 없습니다.</a>
										</c:when>
										<c:otherwise>
											<c:forEach var="event" items="${events }">
												<li><a
													href="${pageContext.request.contextPath}/event/event.do?eventId=${event.eventId }&groupId=${event.groupId}">
														<h3>${event.eventName }
															<a href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"><img
																class="event_info"
																src="../resources/assets/css/images/info.png" /></a>
														</h3>
												</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=${group.groupId}"
									class="button icon fa-info-circle">이벤트 추가</a>
							</section>
								</div>
							</div>
							<div class="8u 12u$(medium) important(medium)">
								<div id="content">
									<div class="col-sm-9 col-lg-9">
										<div><h3>내역 등록</h3></div>
										<div class="table-responsive">
											<div class="well">
												<form action="${pageContext.request.contextPath}/record/registEventRecord.do"
													  class="bs-example form-horizontal" method="POST" enctype="multipart/form-data">
													<fieldset>
														<div class="form-group">
															<label class="col-lg-2 control-label">
															<input type="hidden" id="event" name="eventId" value="${event.eventId}">
															<input type="hidden" id="memberId" name="memberId" value="${memberId}">
															<input type="hidden" id="groupId" name="groupId" value="${groupId}">
																<h3>제목</h3>
															</label>
															<div class="col-lg-10">
																<input type="text" name="title" class="form-control" required="required">
															</div>
														</div>
														<br/>
														<div class="form-group">
															<label class="col-lg-2 control-label">
															  <h3>수입 및 지출(단위/원)</h3>
															  <select id="selectAccounting" name="accounting" required="required">
																	<option value="수입">수입</option>
																	<option value="지출">지출</option>
															  </select>
															</label>
															<div class="col-lg-10">
																<input type="text" name="price" placeholder="(ex. 30,000)" class="form-control" required="required">
															</div>
														</div>
														
														<div class="form-group">
															<label class="col-lg-2 control-label">
															  <h3>카테고리</h3>
															  <select id="selectCategory" name="category" required="required">
																	<option value="미분류">카테고리 선택</option>
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
		
																<input type="file" name="imgFile" onchange="readURL(this);" />
																<input type="hidden" id="image" name="image" value=""/>
																<div class="col-lg-10">
																	  <img id="imgHere" src="" style="max-width:400px;"/>
																</div>
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
