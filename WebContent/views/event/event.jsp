<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Event</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../resources/assets/css/main2.css" />
</head>
<body class="left-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="${pageContext.request.contextPath}/memberGroup/main.do">알뜰총雜</a>
					</h1>
					<span>${group.groupName} > ${event.eventName }</span>
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

						<!-- Sidebar -->
						<div id="sidebar">
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
															<a href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"><img
																class="event_info"
																src="../resources/assets/css/images/info.png" /></a>
														</h3>
												</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<a
									href="${pageContext.request.contextPath}/event/registEvent.do?groupId=${group.groupId}"
									class="button icon fa-info-circle">이벤트 추가</a>
							</section>
						</div>

					</div>

					<div class="8u 12u$(medium) important(medium)">
						<div id="content">

							<div>
								<h3>${event.eventName }</h3>
							</div>
							<table>
								<tr class="aa">
									<th class="table_head"><span>번호</span></th>
									<th class="table_head"><span>제목</span></th>
									<th class="table_head"><span>수입/지출</span></th>
									<th class="table_head"><span>금액</span></th>
									<th class="table_head"><span>작성일</span></th>
									<th class="table_head"><span>작성자</span></th>
									<th class="table_head"><span>상태</span></th>
								</tr>

								<c:forEach var="record" items="${records}" varStatus="status">
									<c:set var="count" value="${count + 1 }" />
										<tr>
										<td><c:out value="${count }" /></td>
										<td><a href="${pageContext.request.contextPath}/record/showRecordDetail.do?recordId=${record.recordId}">${record.title}</a></td>
										<td>${record.accounting}</td>
										<td>${record.price}원</td>
										<td>${record.date}</td>
										<td>${record.memberId}</td>
										<td><button
												onclick="location.href='${pageContext.request.contextPath}/record/checkRecord.do?recordId=${record.recordId}'"
												class="current">${record.caution}</button></td>
									</tr>



								</c:forEach>


							</table>
							<div class="text-right">
								<a
									href="${pageContext.request.contextPath}/record/showRegistEventRecord.do?eventId=${event.eventId}">
									<button class="btn_regist">등록</button>
								</a>
							</div>
							<br />
							<!-- 	<form action="${pageContext.request.contextPath}/event/addEventBalanceToGroup.do" method="POST"> -->
							<div class="total_account">
								<input type="hidden" id="event" name="event" value="${event}">
								<h3>총액: ${event.balance}원</h3>
								<button
									onclick="location.href='addEventBalanceToGroup.do?eventId=${event.eventId }'"
									class="add_result">결과합산</button>
							</div>
							<!--</form>  -->
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
								<li>&copy; Untitled. All rights reserved</li>
								<li>Design: HO&MIN</li>
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
