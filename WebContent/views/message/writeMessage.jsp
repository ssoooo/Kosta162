<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>�޽���</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script type="text/javascript">
	function sendEventDetail() {
		window.opener.top.location.href = "${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"
		//window.opener.top.location.reload();//���ΰ�ħ
		window.close()
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
					<h1>
						<a href="${pageContext.request.contextPath}/memberGroup/main.do">�˶�����</a>
					</h1>
					<span>${group.groupName} > ${event.eventName }</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<h2>�޽���</h2>
						<hr>
						<form
							action="${pageContext.request.contextPath}/message/sendCollection.do?eventId=${event.eventId}"
							class="bs-example form-horizontal" method="POST">
							<table id="message">
								<tbody>
									<tr>
										<th>�߽���</th>
										<td>${loginedMemberId }</td>
									</tr>
									<tr>
										<th>������</th>
										<td><c:forEach var="member" items="${memberss }">
												<input type=hidden name="memberId3"
													value=${member.memberId }>
												${member.memberId }&nbsp;
											</c:forEach></td>
									</tr>
									<tr>
										<th>����</th>
										<td><input class="input_title" type="text" name="title"
										value="${event.collection/members.size() }"></td>
									</tr>
									<tr>
										<div id="input_content">
											<th>����</th>
											<td><textarea name="content" rows="4" cols="50"
													style="resize: none"></textarea></td>
										</div>
									</tr>
								</tbody>
							</table>
							<input class="btn_send" type="submit" onclick="sendEventDetail()"
								value="����">
						</form>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->


	</div>

</body>
</html>
