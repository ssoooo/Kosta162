<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>모금액 현황</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#checkedAll').click(function() {
			// 만약 checkedAll 이 'checked'되어 있다면
			if ($('#checkedAll').prop('checked')) {
				// checkbox 타입의 input 중 name이 subCheck 인 것들의 checked의 prop 값을 true로 변경
				$('input[name=subCheck]:checkbox').each(function() {
					$(this).prop('checked', true);
				});
				// checkedAll 이 checked 되어 있지 않다면
			} else {
				// checkbox 타입의 input 중 name이 subCheck 인 것들의 checked의 prop 값을 false로 변경
				$('input[name=subCheck]:checkbox').each(function() {
					$(this).prop('checked', false);
				});
			}
		})
	});

	function setChildText() {
		var parent = window.opener;

		var answer = document.getElementById('get1').value;

		parent.document.getElementById('get2').value = answer;

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
					<h1>
						<a href="index.html">모금액</a>
					</h1>
					<span>${group.groupName } > {event.eventName }</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->
					<form
						action="${pageContext.request.contextPath}/event/collectionDetail.do?eventId=${event.eventId }"
						class="bs-example form-horizontal" method="POST">
						<fieldset>

							<div class="form-group">
								<label class="col-lg-2 control-label">
									<h3>모임 지원금</h3>
								</label>
								<div class="col-lg-10">
									<ul>
										<li name="get2"><c:forEach items="${memberss }"
												var="member">
												<input name="subCheck" type="checkbox" value=0>
												<input type=hidden name="memberId" value=${member.memberId }>
											${member.memberId }
										<button class="button2" onclick="setChildText()">미납</button>
												<br>
											</c:forEach></li>
									</ul>
								</div>
								<ul>
									<li name="get1"><c:forEach items="${members }"
											var="member">
											${member.memberId }
											<button>완납</button>
											
											<br>
										</c:forEach></li>
								</ul>
							</div>

							<div class="form-group">
								<div class="align_btn">
									<button type="submit" class="record_submit">확인</button>
									<button type="reset" class="record_cancel">취소</button>
								</div>
							</div>
						</fieldset>
					</form>

					<button class="btn_send"
						onclick="window.open('${pageContext.request.contextPath}/message/sendCollection.do','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">메시지
						전송</button>
				</div>
			</div>
		</div>

		<!-- Footer -->

	</div>

</body>
</html>
