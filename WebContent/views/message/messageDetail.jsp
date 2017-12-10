<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../resources/assets/css/grade.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script src="http://code.jquery.com/jquery-1.5.js"></script>
		<script>
		function onclickFunction(){
			
		opener.parent.location.reload('${pageContext.request.contextPath}/message/registMessageRecord.do?messageId=' + ${message.messageId });
		window.close();
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
					<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
					<c:choose>
						<c:when test="${event eq null }">
							<span>${group.groupName }</span>
						</c:when>
						<c:otherwise>
							<span>${group.groupName } > ${event.eventName }</span>
						</c:otherwise>
					</c:choose>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<form
							action="${pageContext.request.contextPath}/record/registEventRecord.do?eventId=${event.eventId}"
							class="bs-example form-horizontal" method="POST"
							enctype="multipart/form-data">
							<h2>메시지</h2>
							<hr>
							<table id="message">
								<tbody>
									<tr>
										<th>발신인</th>
										<td>${event.memberId }</td>
									</tr>
									<tr>
										<th>수신인</th>
										<td>${messages.memberId }</td>
									</tr>
									<tr>
										<th>제목</th>
										<td>${message.title }</td>
									</tr>
									<tr>
										<div id="input_content">
											<th>내용</th>
											<td><textarea name="content" readonly rows="4"
													style="resize: none">${message.content }</textarea></td>
										</div>
									</tr>
								</tbody>
							</table>
							<div id="two_btn">
								<button class="btn_ok" onclick="window.close()">확인</button>
								<button class="btn_regist" onclick="onclickFunction()">등록</button>
							</div>
						</form>
					</div>

				</div>
			</div>
		</div>

		<!-- Footer -->


	</div>



</body>
</html>
