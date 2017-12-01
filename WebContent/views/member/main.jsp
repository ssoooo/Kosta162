<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>My Page</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main2.css" />
	</head>
	<body class="homepage">
	<%@ include file="../../header/header.jspf"%>
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
								<h1><a href="main.do">알뜰총雜</a></h1>
								<span>알뜰한 총무의 잡다한 가계부</span>
							</div>

						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li>
										<a href="main.jsp">Invitation</a>
										<ul class="ul_accept">
										<c:forEach items="${groupsInvited }" var="group" >
											<p class="group_invite_list">
												${group.groupName }
												<div class="accept_reject">
													<a href="">수락</a>
													<a href="">거절</a>
												</div>
											</p>
										</c:forEach>
										</ul>
									</li>
									<li><a href="main.html" >logout</a></li>
									<form action="${pageContext.request.contextPath}/memberGroup/searchAllGroups.do" method="post" class="form_search">
										<li class="search_div">
											<input type="text" name="groupNameInput" value="" style="width:160px; height:40px; margin-right:10px; float:left; margin-top:10px;">
											<input class="current" type="submit" style="background-color:#444; height:40px; float:left; margin-top:10px; font-size:9pt;" value="검색">
										</li>
									</form>
								</ul>
							</nav>
					</header>
				</div>

			<!-- Banner -->
				<div id="banner-wrapper">
					<div id="banner" class="box container">
						<div class="row">
							<div class="7u 12u(medium)">
								<h2>알뜰총雜에 오신 것을 환영합니다!</h2>
								<p>feat.니가해라 총무</p>
							</div>
							<div class="5u 12u(medium)">
								<ul>


									<li><a href="${pageContext.request.contextPath}/memberGroup/showRegistGroup.do" class="button big icon fa-arrow-circle-right">모임 생성</a></li>
									<li><a href="${pageContext.request.contextPath}/memberGroup/myDetail.do" class="button alt big icon fa-question-circle">내 정보</a></li>


								</ul>
							</div>
						</div>
					</div>
				</div>

			<!-- Features -->
				<div id="features-wrapper">
					<div class="container">
						<div class="row">
							
							<c:forEach items="${groups }" var="group" >
							<div class="4u 12u(medium)">
							
								<!-- Box -->
									<section class="box feature">
										<a href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=${group.groupId }" class="image featured"><img src="../resources/images/pic01.jpg" alt="" /></a>
										<div class="inner">
											<header><h2>${group.groupName }</h2></header>
										</div>
									</section>

							</div>
							</c:forEach>
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
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../resources/assets/js/main.js"></script>

	</body>
</html>
