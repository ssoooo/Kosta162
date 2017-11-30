<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Verti by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../../resources/assets/css/grade.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script>
			window.onload = function(){
			  document.getElementById("toLeft").onclick = rightToLeft;
			  document.getElementById("toRight").onclick = leftToRight;
			}
			var rightToLeft = function(){
			  var rightItems = document.getElementById("rightItem");
			  var rightItem = rightItems.options[rightItems.selectedIndex];
			  var leftItems = document.getElementById("leftItem");
			  leftItems.appendChild(rightItem);  //select의 자식은 option
			}
			var leftToRight = function(){
			  var leftItems = document.getElementById("leftItem");
			  var leftItem = leftItems.options[leftItems.selectedIndex];
			  var rightItems = document.getElementById("rightItem");
			  rightItems.appendChild(leftItem);
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
								<h1><a href="index.html">Verti</a></h1>
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
								<h2>
									멤버
								</h2>
								<hr>
								<div id="move">
									<div class="item_group">
										모임
										<br/>
										<select id="leftItem" class="item_width" size="8">
											<option>정민호</option>
											<option>이수진</option>
											<option>김상순</option>
											<option>허유정</option>
										</select>
									</div>
									<div class="btnBox">
										<button id="toLeft">&lt; &lt;</button>
										<br/>
										<button id="toRight">&gt; &gt;</button>
									</div>
									<div class="item_event">
										이벤트
										<br/>
										<select id="rightItem" class="item_width" size="8">
											<option>백민지</option>
											<option>이호정</option>
											<option>양희수</option>
											<option>성우형</option>
											<option>김민수</option>
											<option>이상훈</option>
										</select>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			<!-- Footer -->


			</div>

		

	</body>
</html>