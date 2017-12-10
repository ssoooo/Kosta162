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
<title>tradeGrade</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
</head>
<body class="no-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
					<span>${group.groupName }</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">
					<!-- Content -->

					<div id="box3">
						<h2>멤버</h2>
						<hr>
						<div class="scroll">
							<ul>
								<c:forEach items="${memberList }" var="member">
									<li>${member.memberId }
									<a href="tradeGrade.do?memberId=${member.memberId}&groupId=${group.groupId }&managerId=${managerId }&grade1=총무&grade2=멤버"><button onclick="closeWindowAndTradeGrade()">위임</button></a>
									<!-- <a onclick="closeWindowAndTradeGrade()" href="tradeGrade.do?memberId=${member.memberId}&groupId=${groupId }&managerId=${managerId }&grade1=총무&grade2=멤버">위임</a> -->
										<!-- <button onclick="javascript:closeWindowAndTradeGrade();">위임</button> -->
										
									</li>
									<input type="hidden" id="grade" name="grade" value="총무" />
									<script type="text/javascript">
										function closeWindowAndTradeGrade() {
											//window.location.href = "tradeGrade.do?memberId=${member.memberId }&groupId=${groupId }&grade1=총무&grade2=멤버&managerId=${managerId }";
											alert("${member.memberId}님이 총무가 되셨습니다.");
											window.close();
											opener.location.reload();
											
										}
									</script>
								</c:forEach>

							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>

		<!-- Footer -->


	</div>



</body>
</html>
