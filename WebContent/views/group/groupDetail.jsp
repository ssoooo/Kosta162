<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Group Detail</title>
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
						<a href="main.html">Verti</a>
					</h1>
					<span>${group.groupName }</span>
				</div>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="main.html">Home</a></li>
						<li><a href="main.html">Message</a>
							<ul class="ul_accept">
								<c:forEach items="${messages }" var="message">
									<p class="group_invite_list">${message.title }
									<div class="accept_reject">
										<a href="">보기</a> <a href="">삭제</a>
									</div>
									</p>
								</c:forEach>
							</ul></li>
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
					<div id="box1">
						<h2>모임정보</h2>
						<hr>
						<table id="group_info">
							<tbody>
								<tr>
									<th class="info_first">모임생성일</th>
									<td class="info_detail_first">${group.date }</td>
								</tr>
								<tr>
									<th class="info">모임인원</th>
									<td class="info_detail">${memberNum }명</td>
								</tr>
								<tr>
									<th class="info">총무</th>
									<td class="info_detail">${manager.name }</td>
								</tr>
								<tr>
									<th class="info">총무계좌</th>
									<td class="info_detail">${manager.account }</td>
								</tr>
							</tbody>
						</table>
						<div class="btn_hor">
							<a href="groupStats.html"><button class="btn_graph">통계</button></a>
							<a href="modifyGroup.html"><button class="btn_modify">수정</button></a>
							<a href="#"><button class="btn_delete">삭제</button></a>
						</div>
					</div>
					<div id="box2">
						<h2>모임소개</h2>
						<hr>
						<div class="introduce_content">
							<p>${group.groupIntroduce }</p>
						</div>
					</div>
					<div id="box3">
						<h2>모임멤버</h2>
						<hr>



						<div class="scroll">

							<ul>

								<c:forEach items="${members }" var="member">
									<li><a
										href="${pageContext.request.contextPath}/memberGroup/memberDetail.do?groupId=${member.memberId }">${member.name }</a></li>
								</c:forEach>
							</ul>
						</div>
						<script type="text/javascript">
						 var windowObj;
						 function windowOpen() {
							 window.name = "member1";
							 var settings='width=600,height=620,toolbar=0,scrollbars=0,resizable=0';
						
							 windowObj= window.open("showTradeGrade.do?groupId=${group.groupId}&managerId=${manager.memberId}","tradeGrade",settings);
						 }
					
						</script>

						<div class="btn_hor">
							<button class="btn_trade"
							name = "groupDetailWindow"
							onclick="javascript:windowOpen();">총무위임</button>
							<!-- 	onclick="window.open('showTradeGrade.do?groupId=${group.groupId}','win','width=600,height=620,toolbar=0,scrollbars=0,resizable=0')">총무위임</button> -->
							<button class="btn_invite"
								onclick="window.open('inviteMember.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">멤버초대</button>
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
	<script src="../resources/assets/js/main.js"></script>

</body>
</html>
