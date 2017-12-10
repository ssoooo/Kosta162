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
		function onclickFunction(messageId){
			
			
		    $.ajax({
		        type: "POST",
		        url: "${pageContext.request.contextPath}/message/deleteMyMessage.do",
		        data: {
		        	messageId : messageId,
		        	myId : "${loginedMemberId}"
		        	
		        },
		        dataType: "text",
		        success: function(data) { //여기서 data 안에는 spring 에서 result 한 값이 포함되어 있으며 특정한 목록을 지정해서 보낼 수도있다.
		        	console.log(data);
		        	if(data == "success"){
				        alert("메세지가 삭제되었습니다.");
				        location.reload();
				        
			        }
		        },
		        error : function(data){
		        	console.log(data);
		        	alert("디비실패")
		        }
		    });
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
						<h1><a href="${pageContext.request.contextPath}/memberGroup/main.do">알뜰총雜</a></h1>
						<span>${group.groupName }</span>
					</div>
					
					<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="${pageContext.request.contextPath}/memberGroup/main.do">Home</a></li>
							<li>
								<a href="#">Message</a>
								<ul class="ul_accept">
								<c:forEach items="${messages }" var="message" >
									<p class="group_invite_list">
										${message.title } | ${message.sendMemberId }
										<div class="accept_reject">
											<a href="" onclick="window.open('${pageContext.request.contextPath}/message/receivedMessage.do?messageId=${message.messageId }&groupId=${group.groupId }','win','width=700,height=600,toolbar=0,scrollbars=0,resizable=0')">보기</a>
											<a href="" onclick="onclickFunction(${message.messageId })">삭제</a>
										</div>
									</p>
								</c:forEach>
								</ul>
							</li>
							<li class="current"><a href="${pageContext.request.contextPath}/views/member/login.jsp">Logout</a></li>
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
										<li><a href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=${group.groupId }"><h2>${group.groupName }</h2></a></li>
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
								<a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=${group.groupId}" class="button icon fa-info-circle">이벤트



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
											<!-- <script type="text/javascript">
											var btnval=${record.caution};
											if(btnval.equals("정상")){
												btnval="주의";
											}else{
												btnval="정상";
											}
											
											document.write(btnval+"</button>");
											</script> -->
											
											<td>
											
											<button onclick="location.href='${pageContext.request.contextPath}/record/checkRecord.do?recordId=${record.recordId}'"  class="current">
											${record.caution}
											</button>
											
											</td>
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