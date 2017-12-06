<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<!--
	Verti by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>이벤트 멤버 추가 페이지</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="../resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script type="text/javascript">
	var openWin;
	window.onload = function() {
		document.getElementById("toLeft").onclick = rightToLeft;
		document.getElementById("toRight").onclick = leftToRight;
	}
	var rightToLeft = function() {
		var rightItems = document.getElementById("rightItem");
		var rightItem = rightItems.options[rightItems.selectedIndex];
		var leftItems = document.getElementById("leftItem");
		leftItems.appendChild(rightItem); //select의 자식은 option
	}
	var leftToRight = function() {
		var leftItems = document.getElementById("leftItem");
		var leftItem = leftItems.options[leftItems.selectedIndex];
		var rightItems = document.getElementById("rightItem");
		rightItems.appendChild(leftItem);
	}

	function setChildText() {
		var parent = window.opener;

		var answer = document.getElementById('rightItem').value;

		parent.document.getElementById('get').value = answer;

		var answer2 = document.getElementById('leftItem').value;

		parent.document.getElementById('get2').value = answer2;

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
						<a href="index.html">알뜰총雜</a>
					</h1>
					<span>Kosta 162기 > 가을 MT</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<h2>멤버</h2>
						<hr>
						<div id="move">
							<div class="complete_member">
								<h3>전체 완납 멤버</h3>
								<div class="scroll_complete" id="rightItem">
									<ul >
										<li><c:forEach items="${members }" var="member">
											${member.memberId }
											<button>완납</button>
												<br>
											</c:forEach></li>
									</ul>
								</div>
							</div>
							<div class="btnBox">
								<button id="toLeft">미납</button>
								<br />
								<button id="toRight">완납</button>
							</div>
							<div class="item_event">
								이벤트 <br /> <select id="rightItem" name="rightItem"
									class="item_width" size="8">
									<c:forEach items="${memberss }" var="member">
										<option>${member.memberId }</option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>
					<div class="align_btn">
						<button type="submit" onclick="setChildText()"
							class="record_submit">확인</button>
						<button type="reset" onclick="self.close();" class="record_cancel">닫기</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->

	</div>

</body>
</html>
