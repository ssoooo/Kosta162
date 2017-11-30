<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Event</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
</head>
<body class="left-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="main.html">알뜰총雜</a>
					</h1>
					<span>Kosta 162기 > 가을 MT</span>
				</div>

				<!-- Nav -->
				<nav id="nav">
					<ul>
						<li><a href="main.html">Home</a></li>
						<li><a href="main.html">Message</a>
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

						<!-- Sidebar -->
						<div id="sidebar">
							<section>
								<h2>이벤트</h2>
								<ul class="style2">
									<li><a href="group.do"><h3>전체 보기</h3></a></li>
									<c:choose>
										<c:when test="${empty events}">
											<a class="list-group-item hidden-xs">개설된 이벤트가 없습니다.</a>
										</c:when>
										<c:otherwise>
											<c:forEach var="event" items="${events }">
												<li><a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=1&memberId=3">
													<h3>${event.eventName }
													<a href="eventDetail.do"><img class="event_info"
																src="assets/css/images/info.png"/></a>
														</h3></a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=1" class="button icon fa-info-circle">이벤트
									추가</a>
                      
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
									<th class="table_head"><span>주의</span></th>
								</tr>
								
								<tr>
									<td>1</td>
									<td><a href="recordDetail.do">그랜드 리뉴얼 오픈일</td>
									<td>수입</td>
									<td>3000원</td>
									<td>2012/03/05</td>
									<td>이호정</td>
									<td><input type="checkbox" id="chk_list" name="chk_list"
										value="list1" /></td>
								</tr>
							</table>
							<div class="text-right">
								<a href="registRecord.do">
									<button class="btn_regist">등록</button>
								</a>
							</div>
							<br />
							<form>
								<div class="total_account">
									<h3>총액: 3000원</h3>
									<input type="button" value="결과합산" class="add_result" />
								</div>
							</form>
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
