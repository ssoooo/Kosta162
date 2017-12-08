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
									<c:choose>
									<c:when test="${member ne null }">
											<c:choose>
											<c:when test="${isGroupMember }">
												<tr class="under">
													<td class="th1"></td>
													<td class="td2">
														<ul id="ul_member">
															<li>
																<a href="${pageContext.request.contextPath}/memberGroup/memberDetail.do?memberId=${member.memberId }" class="member_list">${member.memberId }</a><a href="#"><button onclick="alert('이미 모임에 가입되어 있는 멤버입니다.')">초대</button></a>
															</li>
														</ul>
													</td>
													<td class="td3"></td>
												</tr>
											</c:when>
											<c:otherwise>
												<tr class="under">
													<td class="th1"></td>
													<td class="td2">
														<ul id="ul_member">
															<li>
																<a href="${pageContext.request.contextPath}/memberGroup/memberDetail.do?memberId=${member.memberId }" class="member_list">${member.memberId }</a><a href="${pageContext.request.contextPath}/memberGroup/inviteMember.do?memberId=${member.memberId }&groupId=${group.groupId }"><button onclick="alert('${member.memberId }님을 모임에 초대했습니다.')">초대</button></a>
															</li>
														</ul>
													</td>
													<td class="td3"></td>
												</tr>
											</c:otherwise>
											</c:choose>
									</c:when>
									<c:otherwise>
									<tr class="under">
										<td class="th1"></td>
										<td class="td2">
												<ul id="ul_member">
												<li style="text-align:center;">
													등록된 정보가 없습니다.
												</li>
											</ul>
											</td>
										<td class="td3"></td>
									</tr>
									</c:otherwise>
									</c:choose>
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
