<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Verti by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>이벤트 상세 페이지</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="no-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="main.do">알뜰총雜</a>
					</h1>
					<span>${group.groupName} > ${event.eventName }</span>
				</div>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="main.do">Home</a></li>
						<li><a href="main.do">Message</a>
							<ul class="ul_accept">
								<p class="group_invite_list">제목
								<div class="accept_reject">
									<a href="">보기</a> <a href="">삭제</a>
								</div>
								</p>
								<p class="group_invite_list">제목
								<div class="accept_reject">
									<a href="">보기</a> <a href="">삭제</a>
								</div>
								</p>
							</ul></li>
						<li class="current"><a href="login.do">Logout</a></li>
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
						<h2>이벤트정보</h2>
						<hr>
						<table id="group_info">
							<tbody>
								<tr>
									<th class="info_first">이벤트 명</th>
									<td class="info_detail_first"><a
										href="${pageContext.request.contextPath}/event/event.do?eventId=${event.eventId }&groupId=${event.groupId}">${event.eventName }</td>
								</tr>
								<tr>
									<th class="info">이벤트 예산액</th>
									<td class="info_detail">${event.budget }원</td>
								</tr>

								<tr>
									<th class="info">모임 지원금</th>
									<td class="info_detail">${event.groupSupport }원</td>
								</tr>
								<tr>
									<th class="info">인원</th>
									<td class="info_detail">${members.size() }명</td>
								</tr>
								<tr>
									<th class="info">총 모금액(예산액-지원금)</th>
									<td class="info_detail">${event.collection }원</td>
								</tr>
								<tr>
									<th class="info">1인당 모금액(총 모금액/인원)</th>
									<td class="info_detail">${event.collection/members.size() }원</td>
								</tr>
								<tr>
									<th class="info">실시간 모금액</th>
									<td class="info_detail">0원</td>
								</tr>
							</tbody>
						</table>
						<div class="btn_hor">
							<a
								href="${pageContext.request.contextPath}/event/eventStats.do?eventId=${event.eventId }&groupId=${event.groupId }"><button
									class="btn_graph">통계</button></a> <a
								href="${pageContext.request.contextPath}/event/modifyEvent.do?eventId=${event.eventId }&groupId=${event.groupId }"><button
									class="btn_modify">수정</button></a> <a
								href="${pageContext.request.contextPath}/event/remove.do?eventId=${event.eventId}&groupId=${event.groupId }"><button
									class="btn_delete">삭제</button></a>
						</div>
					</div>
					<div id="box3">
						<h2>이벤트 멤버</h2>
						<hr>
						<div class="scroll" id="get">
							<ul>
								<c:forEach items="${members }" var="member">
									<li>${member.memberId }</li>
								</c:forEach>
							</ul>
						</div>
						<div class="btn_hor">
							<button class="btn_modify"
								onclick="window.open('${pageContext.request.contextPath}/event/collectionDetail.do?eventId=${event.eventId }','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">모금액</button>
							<button class="btn_invite"
								onclick="window.open('${pageContext.request.contextPath}/event/addMemberToEvent.do?eventId=${event.eventId }&groupId=${event.groupId }','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">멤버추가/제외</button>
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

	<script src="../resources/assets/js/jquery.min.js"></script>
	<script src="../resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="../resources/assets/js/skel.min.js"></script>
	<script src="../resources/assets/js/util.js"></script>
	<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
	<script src="assets/js/main.js"></script>

</body>
</html>
