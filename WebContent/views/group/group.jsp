<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Group</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../resources/assets/css/main2.css" />
		<script>
		function winClose(memberId){
    		alert(memberId + "님이 보낸 메시지를 삭제했습니다.");
    		opener.location.reload();
		}
		</script>
	</head>
	<body class="left-sidebar">
		<%@ include file="../../header/header.jspf"%>
		<div id="page-wrapper">

			<!-- Header -->
			<div id="header-wrapper">
				<header id="header" class="container">

					<!-- Logo -->
					<div id="logo">
						<h1><a href="main.html">알뜰총雜</a></h1>
						<span>${group.groupName }</span>
					</div>
					
					<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="main.html">Home</a></li>
							<li>
								<a href="#">Message</a>
								<ul class="ul_accept">
								<c:forEach items="${messages }" var="message" >
									<p class="group_invite_list">
										${message.title }
										<div class="accept_reject">
											<a href="#" onclick="window.open('${pageContext.request.contextPath}/message/receivedMessage.do?messageId=${message.messageId }&groupId=${group.groupId }','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">보기</a>
											<a href="${pageContext.request.contextPath}/message/deleteMyMessage.do?messageId=${message.messageId }" onclick="winClose('${message.memberId }')">삭제</a>
										</div>
									</p>
								</c:forEach>
								</ul>
							</li>
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
										<li><a href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=1"><h3>전체 보기</h3></a></li>
										<c:choose>
										<c:when test="${empty events}">
											<a class="list-group-item hidden-xs">개설된 이벤트가 없습니다.</a>
										</c:when>
										<c:otherwise>
											<c:forEach var="event" items="${events }">
												<li><a href="${pageContext.request.contextPath}/event/event.do?eventId=${event.eventId }&groupId=${event.groupId}">
													<h3>${event.eventName }
													<a href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"><img class="event_info"
																src="../resources/assets/css/images/info.png"/></a>
														</h3></a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=1" class="button icon fa-info-circle">이벤트



									추가</a></section>
							</div>
							
						</div>
						
						<div class="8u 12u$(medium) important(medium)">
							<div id="content">

								<div> <h3>${group.groupName }<a href="${pageContext.request.contextPath}/memberGroup/groupDetail.do?groupId=${group.groupId }"><img style="width:20px;" src="../resources/assets/css/images/info.png"/></a></h3></div>
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
										<c:forEach var="record" items="${records}" varStatus="status">
										
										<tr>
											<td>${record.recordId}</td>
											<td><a href="${pageContext.request.contextPath}/record/showRecordDetail.do?recordId=${record.recordId}">${record.title}</a></td>
											<td>${record.accounting}</td>
											<td>${record.price}원</td>
											<td>${record.date}</td>
											<td>${record.memberId}</td>
											<td><input type="checkbox" id="chk_list" name="chk_list" value="list1" /></td>
											</tr>
										
										
										
										</c:forEach>
										
										
									</table>
								<div class="text-right">
								<input type="hidden" id="groupId" name="groupId" value="${group.groupId}">
									<a href="${pageContext.request.contextPath}/record/showRegistGroupRecord.do?groupId=${group.groupId}">
										<button class="btn_regist">등록</button>
									</a>
								</div>
								<br />
								<div class="total_account">
									<h3>총액: ${group.balance}원</h3>
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
			<!--[if lte IE 8]><script src="../../resources/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../resources/assets/js/main.js"></script>

	</body>
</html>