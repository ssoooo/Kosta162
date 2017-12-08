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

	$(function() {
		$('#subCheck').click(function() {
			if ($('#subCheck').prop('checked')) {
				$('input[name=subCheck]:checkbox').each(function() {
					$(this).prop('checked', true);
				});
			}
		})
		var valueArr = new Array();
		var list = $('input[name=subCheck]:checkbox]');
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되어 있으면 배열에 값을 저장함
				valueArr.push(list[i].value);
			}
		}

	});

	function setChildText() {
		var parent = window.opener;

		var answer = document.getElementById('get1').value;

		parent.document.getElementById('memberId').value = answer;

		var answer2 = document.getElementById('get2').value;

		parent.document.getElementById('memberId2').value = answer2;

		window.close();

	}
	function sendEventDetail() {
		window.opener.top.location.href = "${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"
		//window.opener.top.location.reload();//새로고침
		window.close()
	}

	function checkSelectedValue() {
		var valueArr = new Array();
		var list = $('input[name=subCheck]:checkbox]');
		for (var i = 0; i < list.length; i++) {
			if (list[i].checked) { //선택되어 있으면 배열에 값을 저장함
				valueArr.push(list[i].value);
			}
		}

		//선택된 체크박스의 값을 콘솔에 출력
		var str = '';
		for ( var i in valueArr) {
			str += valueArr[i] + '<br />';
		}
		$('#dibugConsole').html(str);

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
						<a
							href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }">모금액</a>
					</h1>
					<span>${group.groupName } > ${event.eventName }</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<h2>납부 현황</h2>
						<hr>
						<div id="paymemt">
							<div class="complete_member">
								<h3>전체 완납 멤버</h3>
								<form
									action="${pageContext.request.contextPath}/event/collectionDetail2.do?eventId=${event.eventId }"
									class="bs-example form-horizontal" method="POST">

									<div class="scroll_complete">
										<ul>
											<li name="get1"><c:forEach items="${memberss }"
													var="member">
													<input type=hidden name="memberId2"
														value=${member.memberId }>
											${member.memberId }
											<button onclick="setChildText()">완납</button>

													<br>
												</c:forEach></li>
										</ul>
									</div>
								</form>
							</div>

							<div class="notYet_member">
								<h3>
									<input type="checkbox" id="checkedAll">전체 미납 멤버
								</h3>
								<form
									action="${pageContext.request.contextPath}/event/collectionDetail.do?eventId=${event.eventId }"
									class="bs-example form-horizontal" method="POST">
									<div class="scroll_notYet" id="get">
										<ul>
											<li name="get2"><c:forEach items="${members }"
													var="member">
													<input name="subCheck" type="checkbox" value=0>
													<input type=hidden name="memberId"
														value=${member.memberId }>
											${member.memberId }
										<button class="button2" onclick="setChildText()">미납</button>
													<br>
												</c:forEach></li>
										</ul>
									</div>
								</form>
							</div>
						</div>
					</div>
					<button class="btn_send"
						onclick="window.open('${pageContext.request.contextPath}/message/sendCollection.do?receivedMember=${event.memberId }','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">메시지
						전송</button>
					<button type="submit" onclick="sendEventDetail()"
						class="record_submit">확인</button>
				</div>


				<!-- Footer -->

			</div>
		</div>
	</div>
</body>
</html>
