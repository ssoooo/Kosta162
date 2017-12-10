<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
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
								<h2>
									초대
								</h2>
								<hr>
								<table id="search">
									<tbody>
									<form action="${pageContext.request.contextPath}/memberGroup/searchMember.do" method="post">
									<tr>
										<th class="th1">ID</th>
										<td class="td2"><input class="input_id" type="text" name="memberId" /></td>
										<td class="td3"><input type="submit"  value="검색" /></td>
									</tr>
									<input type="hidden" name="groupId" value="${group.groupId }"/> 
									</form>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			<!-- Footer -->

			</div>

	</body>
</html>
