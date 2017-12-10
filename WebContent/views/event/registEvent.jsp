<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<title>이벤트 등록</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../resources/assets/css/main2.css" />
</head>
<body class="left-sidebar">
	<%@ include file="../../header/header.jspf"%>
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
					<span>${group.groupName}</span>
				</div>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a
							href="${pageContext.request.contextPath}/memberGroup/main.do">Home</a></li>
						<li><a href="#">Message</a>
							<ul class="ul_accept">
								<c:forEach items="${messages }" var="message">
									<p class="group_invite_list">${message.title }
									<div class="accept_reject">
										<a href="#"
											onclick="window.open('${pageContext.request.contextPath}/message/receivedMessage.do?messageId=${message.messageId }&groupId=${group.groupId }','win','width=700,height=600,toolbar=0,scrollbars=0,resizable=0')">보기</a>
										<a
											href="${pageContext.request.contextPath}/message/deleteMyMessage.do?messageId=${message.messageId }"
											onclick="winClose('${message.memberId }')">삭제</a>
									</div>
									</p>
								</c:forEach>
							</ul></li>
						<li class="current"><a
							href="${pageContext.request.contextPath}/views/member/login.jsp">Logout</a></li>
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
										href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=${event.groupId}"><h2>${group.groupName }</h2></a></li>
									<c:choose>
										<c:when test="${empty events}">
											<a class="list-group-item hidden-xs">개설된 이벤트가 없습니다.</a>
										</c:when>
										<c:otherwise>
											<c:forEach var="event" items="${events }">
												<li><a
													href="${pageContext.request.contextPath}/event/event.do?eventId=${event.eventId }&groupId=${event.groupId}">
														<h3>${event.eventName }
															<a href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }">
																<img class="event_info"
																src="../resources/assets/css/images/info.png" />
															</a>
														</h3>
												</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>

							</section>

						</div>
					</div>
					<div class="8u 12u$(medium) important(medium)">
						<div id="content">
							<div class="col-sm-9 col-lg-9">
								<div>
									<h3>이벤트 등록</h3>
								</div>
								<div class="table-responsive">
									<div class="well">
										<form
											action="${pageContext.request.contextPath}/event/registEvent.do?groupId=${group.groupId}"
											class="bs-example form-horizontal" method="POST">
											<fieldset>
												<div class="form-group">
													<label class="col-lg-2 control-label">
														<h3>이벤트명</h3>
													</label>
													<div class="col-lg-10">
														<input type="text" name="eventName" class="form-control" required="required">
													</div>
												</div>
												<br />
												<div class="form-group">
													<label class="col-lg-2 control-label">
														<h3>이벤트 예산액</h3>
													</label>
													<div class="col-lg-10">
														<input type="text" name="budget" class="form-control" required="required">
													</div>
												</div>
												<br />
												<div class="form-group">
													<label class="col-lg-2 control-label">
														<h3>모임 지원금</h3>
													</label>
													<div class="col-lg-10">
														<input type="text" name="groupSupport"
															class="form-control" required="required">
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-2 control-label">
														<h3>멤버</h3>
													</label> <input type="button" class="btn_invite" value="멤버추가"
														onclick="window.open('${pageContext.request.contextPath}/memberGroup/memberList.do?groupId=${group.groupId }','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')" />
													<div class="col-lg-10">
														<textarea class="form-control" name="get" rows="2"
															id="get"></textarea>
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
					<div class="3u 6u(medium) 12u$(small)"></div>
					<div class="3u 6u$(medium) 12u$(small)"></div>
					<div class="3u 6u(medium) 12u$(small)"></div>
					<div class="3u 6u$(medium) 12u$(small)"></div>
				</div>
				<div class="row">
					<div class="12u">
						<div id="copyright">
							<ul class="menu">
								<li>&copy; Untitled. All rights reserved</li>
								<li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
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
