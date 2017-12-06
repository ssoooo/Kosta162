<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../resources/assets/css/grade.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script>
		function winClose(memberId){
    		alert(memberId + "님을 추방하셨습니다.");
    		window.close();
    		opener.location.reload();
		}
		</script>
	</head>
	<body class="no-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
								<h1><a href="index.html">Verti</a></h1>
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
							<h2>
								멤버
							</h2>
							<hr>
							<div class="scroll">
							<ul>
							<c:forEach items="${members }" var="member">
								<li>
									${member.memberId }<a href="${pageContext.request.contextPath}/memberGroup/kickMember.do?memberId=${member.memberId }&groupId=${group.groupId }"><button onclick="winClose('${member.memberId }')">추방</button></a>
								</li>
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