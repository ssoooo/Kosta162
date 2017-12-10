<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
	<head>
		<title>내 정보</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../resources/assets/css/main.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script>
		function onclickFunction(groupId){
		    $.ajax({
		        type: "POST",
		        url: "acceptInvite.do",
		        data: {
		        	groupId : groupId
		        },
		        dataType: "text",
		        success: function(data) { //여기서 data 안에는 spring 에서 result 한 값이 포함되어 있으며 특정한 목록을 지정해서 보낼 수도있다.
			        if(data == 'success'){
				        alert("모임 가입이 완료되었습니다.");
				        location.reload();
			        }else{
				        alert("모임 가입에 실패하였습니다.");
		        	}
		        }
		    });
		}
		function onclickFunction1(groupId){
		    var loginedMemberId = "${loginedMemberId }";
			$.ajax({
		        type: "POST",
		        url: "denyInvite.do",
		        data: {
		        	groupId : groupId,
		        	memberId : loginedMemberId
		        },
		        dataType: "text",
		        success: function(data) { //여기서 data 안에는 spring 에서 result 한 값이 포함되어 있으며 특정한 목록을 지정해서 보낼 수도있다.
		        	console.log(data);
		        	if(data == "success"){
				        alert("초대가 삭제되었습니다.");
				        location.reload();
				        
			        }else{
				        alert("초대삭제에 실패하였습니다.");
		        	}
		        }
		    });
		}
		</script>
	</head>
	<body class="no-sidebar">
		<div id="page-wrapper">

 <%@ include file="../../header/header.jspf"%>


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
										<a href="main.html">Invitation</a>
										<ul class="ul_accept">
										<c:forEach items="${groupsInvited }" var="group" >
											<p class="group_invite_list">${group.groupName }
												<div class="accept_reject">
														<a href="" onclick="onclickFunction('${group.groupId }')">수락</a>
 													<a href="" onclick="onclickFunction1('${group.groupId }')">거절</a>
												</div>
											</p>
											
										</c:forEach>
										</ul>
									</li>
									
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
							<h2>
								멤버정보
							</h2>
							<hr>
							<table id="group_info">
								<tbody>
								<tr>
									<th class="info_first">아이디</th>
									<td class="info_detail_first">${member.memberId }</td>
								</tr>
								<tr>
									<th class="info">별명</th>
									<td class="info_detail">${member.nickname }</td>
								</tr>
								
								<tr>
									<th class="info">이름</th>
									<td class="info_detail">${member.name }</td>
								</tr>
								<tr>
									<th class="info">이메일</th>
									<td class="info_detail">${member.email }</td>
								</tr>
								<tr>
									<th class="info">계좌번호</th>
									<td class="info_detail">${member.account }</td>
								</tr>
								<tr>
									<th class="info">휴대폰번호</th>
									<td class="info_detail">${member.phoneNumber }</td>
								</tr>
								<tr>
									<th class="info">가입한 모임</th>
									<td class="info_detail">${fn:length(list) }개</td>
								</tr>
								</tbody>
							</table>
							<c:if test="${member.memberId eq loginedMemberId}">
							<div class="btn_hor">
								<a href="showModifyMember.do?memberId=${member.memberId }"><button class="btn_modify">회원 수정</button></a>
								<!-- <a href="deleteMember.do?memberId=${member.memberId }"><button class="btn_delete" onclick="comfirmDelete()">탈퇴</button></a> -->
								<button class="btn_delete" onclick="comfirmDelete()">회원 탈퇴</button>
							</div>
							</c:if>
							<script type="text/javascript">
								function comfirmDelete() {
									var confirmflag = confirm("정말 회원삭제하실건가요");
									if(confirmflag){
										location.href="deleteMember.do?memberId=${member.memberId }";

									}else{
										history.go( 0 );
									}							
								}
							</script>
						</div>

						<br class="clear" />
						
						<div id="box3">
						<h2>보낸 메시지</h2>
						<hr>

								<table id="message_list">
									<tr class="aa">
										<th style="width:20%;"><span>모임</span></th>
										<th style="width:20%;"><span>이벤트</span></th>
										<th style="width:20%;"><span>수신인</span></th>
										<th style="width:20%;"><span>제목</span></th>
										<th style="width:20%;"><span>작성일</span></th>
									</tr>
								</table>
								<div class="member_scroll">
							
								<table id="message_list">
									<c:forEach items="${sendMessages }" var="message" >
									<tr class="ab">
										<td style="width:20%;">${message.groupId }</td>
										<td style="width:20%;">${message.eventId }</td>
										<td style="width:20%;">${message.memberId }</td>
										<td style="width:20%;"><a href="${pageContext.request.contextPath}/message/messageDetail.do?messageId=${message.messageId }">${message.title }</a></td>
										<td style="width:20%;">${message.date }</td>
									</tr>
									</c:forEach>					
								</table>
								</div>
						</div>
						
						
						<div id="box3">
						<h2>멤버 초대</h2>
						<hr>

								<table id="message_list">
									<tr class="aa">
										<th style="width:33%;"><span>모임</span></th>
										<th style="width:33%;"><span>초대 받은 멤버</span></th>
										<th style="width:33%;"><span>초대한 날짜</span></th>
									</tr>
								</table>
								<div class="member_scroll">
							
								<table id="message_list">
									<c:forEach items="${sendMessages }" var="message" >
									<tr class="ab">
										<td style="width:33%;">kostaaaaaaaaaa</td>
										<td style="width:33%;">호정리</td>
										<td style="width:33%;">2017-11-20</td>
									</tr>
									</c:forEach>					
								</table>
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
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="../resources/assets/js/main.js"></script>


	</body>
</html>