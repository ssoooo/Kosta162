<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<title>Event</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main2.css" />
	</head>
	<body class="left-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
			<div id="header-wrapper">
				<header id="header" class="container">

					<!-- Logo -->
					<div id="logo">
						<h1><a href="main.html">알뜰총雜</a></h1>
						<span>Kosta 162기 > 가을 MT</span>
					</div>

						<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="main.html">Home</a></li>
							<li>
								<a href="main.html">Message</a>
									<ul class="ul_accept">
										<p class="group_invite_list">
											제목
											<div class="accept_reject">
												<a href="">보기</a>
												<a href="">삭제</a>
											</div>
										</p>
										<p class="group_invite_list">
											제목
											<div class="accept_reject">
												<a href="">보기</a>
												<a href="">삭제</a>
											</div>
										</p>
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
									<h2>통계</h2>
									<ul class="style2">
										<li><a href="statsAccounting.html"><h3>정산결과</h3></a></li>
										<li><a href="statsPeriod.html"><h3>기간</h3></a></li>
										<li><a href="statsCategory.html"><h3>카테고리</h3></a></li>
										<li><a href="statsEvent.html"><h3>이벤트</h3></a></li>
									</ul>
								</section>
							</div>
							
						</div>
						
						<div class="8u 12u$(medium) important(medium)">
							<div id="content">

								<div> <h3>정산결과</h3></div>
								<hr/>
								<form>
									<div class="total_account" style="width:100%; padding:5%;">
										<div class="graph_box1" style="display:block; width:100%; border:solid 1px #E6E6E6; margin-bottom:30px;">
											<h3>그래프1</h3>
											
											<!--graph contents-->
											
											<div class="form-group">
													<label class="col-lg-2 control-label"><h2>수입 : 30,000원</h2></label>
													<label class="col-lg-2 control-label"><h2>지출 : 30,000원</h2></label>
													<label class="col-lg-2 control-label"><h2>합계 : 60,000원</h2></label>
											</div>

											<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
											<script>
												google.charts.load('current', {packages:['corechart']});
											</script>

											<div style="display:inline-block; width:500px;" id="chart_div"></div>

											<script type="text/javascript" src="https://www.google.com/jsapi"></script>
											<script type="text/javascript">
											google.load("visualization", "1", {'packages':["corechart"]});
											google.setOnLoadCallback(drawChart);	// pie
											function drawChart() {
												var data = new google.visualization.DataTable();
												data.addColumn('string', '카테고리');
												data.addColumn('number', '금액');
												data.addRows([
													['수입', 6000],['지출', 4000]
												]);

												var options = {
													title: '수입 지출 정산',
													fontSize: '14',
													fontName: '돋움체',
													'is3D':true
												};

												var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
												chart.draw(data, options);
											}
											</script>
											
											<!-- -->
											
										</div>
										
										<div class="graph_box2" style="display:inline-block; width:100%; border:solid 1px #E6E6E6;">
											<h3>그래프2</h3>
											
											<!--graph contents-->
											
											<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
											<script>
											 google.charts.load('current', {packages:['corechart']});
											</script>

											<div id="chart_div3" style="width:500px; margin:0 auto; display:inline-block;"></div>
											<br/>
											<div id="chart_div4" style="width:500px; margin:0 auto; display:inline-block;"></div>

											<script type="text/javascript">
											 google.charts.setOnLoadCallback(drawChart);

											 var chart_options = {
												 title : '년별 수입 지출 통계',
												 width : 500,
												 height : 400,
												 bar : {
													 groupWidth : '50%'
												 },
												 isStacked : true
											 };

											 function drawChart(){
												 var data3 = new google.visualization.arrayToDataTable([
													 ['년대', '수입', '지출', '합계'], // 제목 그리고 항목들
													['2015', 10, 20, 40], // 제목과 항목수를 맞춰주어야 합니다.
													['2016', 15, 30, 20],
													['2017', 20, 25, 30],
													['2018', 10, 30, 50]
													]);

													var data4 = new google.visualization.arrayToDataTable([
														['달', '수입', '지출', '합계'],
														['1월', 10, 30, 40],
														['2월', 30, 30, 60],
														['3월', 25, 30, 50],
														['4월', 35, 20, 50],
														['5월', 60, 20, 50],
														['6월', 30, 20, 50],
														['7월', 30, 20, 50],
														['8월', 20, 20, 50],
														['9월', 32, 20, 50],
														['10월', 55, 20, 50],
														['11월', 34, 20, 50],
														['12월', 54, 20, 50]
													]);

												 var chart3 = new google.visualization.ColumnChart(document.getElementById('chart_div3'));
												 var chart4 = new google.visualization.ColumnChart(document.getElementById('chart_div4'));
												 chart3.draw(data3, chart_options);
												 chart4.draw(data4, chart_options);
											 }

											</script>
											
											<!-- -->
										
										</div>
									</div>
								</form>
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

			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="assets/js/main.js"></script>

	</body>
</html>
