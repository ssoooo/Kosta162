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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body class="no-sidebar">
	<%@ include file="../../header/header.jspf"%>
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<h1>
						<a href="main.html">알뜰총雜</a>
					</h1>
					<span>${group.groupName }</span>
				</div>

				<!-- Nav -->
				<nav id="nav">
				
					<ul >
						<li><a href="main.html">Home</a></li>
						<li>
							<a>Message</a>
							<ul class="ul_accept">
							<c:forEach items="${messages }" var="message" >
								<p class="group_invite_list">
									${message.title }
									<div class="accept_reject">
										<a href="">보기</a>
										<a href="">삭제</a>
									</div>
								</p>
							</c:forEach>
							</ul>
						</li>
						<c:if test="${loginedMemberId eq group.memberId }"> 
						<li><a href="main.html">가입신청</a>
							
							<ul id="refresh" class="ul_accept">
							<c:forEach items="${signIns }" var="signIn" varStatus="sts">
								<input type="hidden" id="signInMemberId${sts.count }" value="${signIn.memberId }">
									<p class="group_invite_list">${signIn.memberId }</p>
								<br>
									<div class="accept_reject">
										<a href="" onclick="onclickFunction('${group.groupId}','${signIn.memberId }')">승인</a>
										<a href="" onclick="onclickFunction1('${group.groupId}','${signIn.memberId }')">거절</a>
									</div>
									
								</c:forEach>
							</ul>
						</li>
						</c:if>
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
									<td class="info_detail">${manager.memberId }</td>
								</tr>
								<tr>
									<th class="info">총무계좌</th>
									<td class="info_detail">${group.account }</td>
								</tr>
								</tbody>
							</table>
							<div class="btn_hor">
							
							<script>
							var myGroupIDS=${myGroupIds};
							for(var i=0; i<myGroupIDS.length; i++){
								if(myGroupIDS[i]==${group.groupId}){
									document.write('<a href="${pageContext.request.contextPath}/record/groupStats.do?groupId=${group.groupId}"><button class="btn_graph">통계</button></a>');
									if("${loginedMemberId }" == "${manager.memberId }"){
									document.write('<a href="${pageContext.request.contextPath}/memberGroup/showModifyGroup.do?groupId=${group.groupId }"><button class="btn_modify">수정</button></a>');
									document.write('<a href="${pageContext.request.contextPath}/memberGroup/deleteGroup.do?groupId=${group.groupId }"><button class="btn_delete">삭제</button></a>');
									 document.write('<a href="#" onclick="alert(\'총무는 탈퇴할 수 없습니다. 총무를 위임한 후 탈퇴할 수 있습니다.\')"><button class="btn_delete">탈퇴</button></a>');
									}
									else{
										 document.write('<a href="${pageContext.request.contextPath}/memberGroup/leaveGroup.do?groupId=${group.groupId }"><button class="btn_delete">탈퇴</button></a>');
									 }
								   
								
								
								}
							}
							</script>
								 
							</div>
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
						<script>
						var openWin;
						function windowOpen() {
							openWin= window.open('showTradeGrade.do?groupId=${group.groupId}&managerId=${manager.memberId}','win','width=600,height=620,toolbar=0,scrollbars=0,resizable=0');
						}
						</script>


						<div class="scroll">
							<ul>
								<c:forEach items="${members }" var="member">
									<li><a href="${pageContext.request.contextPath}/memberGroup/memberDetail.do?memberId=${member.memberId }">${member.memberId }</a></li>
								</c:forEach>
							</ul>
						</div>
						

						<div class="btn_hor">
						<script>
							var myGroupIDS=${myGroupIds};
							for(var i=0; i<myGroupIDS.length; i++){
								if(myGroupIDS[i]==${group.groupId}){
									document.write('<c:if test="${loginedMemberId eq manager.memberId }"> ');
									document.write('<button class="btn_trade"');
									document.write('onclick="javascript:windowOpen();">총무위임</button>');
									document.write('<button class="btn_trade" onclick="window.open(\'${pageContext.request.contextPath}/memberGroup/showKickMember.do?groupId=${group.groupId }\',\'win\',\'width=600,height=600,toolbar=0,scrollbars=0,resizable=0\')">멤버추방</button></c:if>');
									document.write('<button class="btn_invite" onclick="window.open(\'${pageContext.request.contextPath}/memberGroup/showSearchMember.do?groupId=${group.groupId }\',\'win\',\'width=600,height=600,toolbar=0,scrollbars=0,resizable=0\')">멤버초대</button>)');
								
								}
							}
							</script>
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
	<script>
		function onclickFunction(groupId,memberId){
		    $.ajax({
		        type: "POST",
		        url: "acceptSignIn.do",
		        data: {
		        	groupId : groupId,
		        	memberId : memberId
		        	
		        },
		        dataType: "text",
		        error : function() {
		        	alert("가입실패했습니다.")
		        },
		        success: function(response) { 
			        	alert("가입이 성공했습니다.")
			        	location.reload();
			        	$("#refresh").load("groupDetail.do?groupId=2 #refresh");
		        }
		    });
		}
		function onclickFunction1(groupId,memberId){
		    $.ajax({
		        type: "POST",
		        url: "denySignIn.do",
		        data: {
		        	groupId : groupId,
		        	memberId : memberId
		        	
		        },
		        dataType: "text",
		        error : function() {
		        	alert("거절실패했다임마")
		        },
		        success: function(response) { //여기서 data 안에는 spring 에서 result 한 값이 포함되어 있으며 특정한 목록을 지정해서 보낼 수도있다.
			        	alert("가입신청을 거절하셨습니다.")
			        	location.reload();
			        	
		        }
		    });
		}
		</script>
</body>
</html>
