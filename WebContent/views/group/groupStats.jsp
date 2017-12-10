<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
	
		<title>통계 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<link type="text/css" rel="stylesheet" href="http://onlinehtmltools.com/tab-generator/skins/skin6/top.css"></script>

	</head>
	<body class="no-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
						<div id="logo">
							<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
							<span>Kosta 162기</span>
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
						<div id="content">

							<!-- Content -->

				<div class="tabs_holder">
					 <ul>
					  <li class="tab_selected">
					<li><a href="#your-tab-id-1">정산 결과</a></li>
					  <li><a href="#your-tab-id-2">기간</a></li>
						 <li><a href="#your-tab-id-3">카테고리</a></li>
						
						  
						  
						  
						  
						  
					 </ul>
			

		 <!-- 탭1번-->
				 <div class="content_holder">
				  <div id="your-tab-id-1">
					
						<div>
							<br />
						</div>
						<div class="form-group">
						
						<label class="col-lg-2 control-label"><h2>${groupName} 정산결과</h2></label>
								<label class="col-lg-2 control-label"><h2>수입 : ${income}원</h2></label>
								<label class="col-lg-2 control-label"><h2>지출 : ${outlay}원</h2></label>
								<label class="col-lg-2 control-label"><h2>합계 : ${groupBalance}원</h2></label>
						
						
						</div>

						<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
					 <script>
						 google.charts.load('current', {packages:['corechart']});
					 </script>

					 <div style="display:inline-block;" id="chart_div"></div>

					 <script type="text/javascript" src="https://www.google.com/jsapi"></script>
					 <script type="text/javascript">
					 google.load("visualization", "1", {'packages':["corechart"]});
					 google.setOnLoadCallback(drawChart);	// pie

					 function drawChart() {
						 var data = new google.visualization.DataTable();
						 data.addColumn('string', '카테고리');
						 data.addColumn('number', '금액');
						 data.addRows([
							 ['수입', ${income}],['지출',${outlay}]
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
				 
				 <label class="col-lg-2 control-label">
					 <h2>이벤트별 통계 보러가기</h3>															</label>
					<div >
					 
					이벤트:&nbsp;
					 <c:forEach var="event" items="${events}" varStatus="status">
					 
					<a href="${pageContext.request.contextPath}/record/eventStats.do?eventId=${event.eventId}">${event.eventName}</a>&nbsp;
					  </c:forEach>
					 
				 </div>
				 
				 
				 </div>


		<!-- 탭2번-->
					 <div id="your-tab-id-2">
						 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 							<script>
 							 google.charts.load('current', {packages:['corechart']});
 							</script>

 							<div id="chart_div3"></div>
							<div id="chart_div4"></div>

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
 									 ['년대', '수입', '지출'], // 제목 그리고 항목들
  									['${year3}', ${year3Income}, ${year3Outlay}], // 제목과 항목수를 맞춰주어야 합니다.
  									['${year2}', ${year2Income}, ${year2Outlay}],
  									['${year1}', ${year1Income}, ${year1Outlay}],
  									['${year0}', ${year0Income}, ${year0Outlay}]
  									]); 

									var data4 = new google.visualization.arrayToDataTable([
										['기준', '수입', '지출'],
										['11달전', ${month11Income}, ${month11Outlay}],
										['10달전', ${month10Income}, ${month10Outlay}],
										['9달전', ${month9Income}, ${month9Outlay}],
										['8달전', ${month8Income}, ${month8Outlay}],
										['7달전', ${month7Income}, ${month7Outlay}],
										['6달전', ${month6Income}, ${month6Outlay}],
										['5달전', ${month5Income}, ${month5Outlay}],
										['4달전', ${month4Income}, ${month4Outlay}],
										['3달전', ${month3Income}, ${month3Outlay}],
										['2달전', ${month2Income}, ${month2Outlay}],
										['1달전', ${month1Income}, ${month1Outlay}],
										['이번달', ${month0Income}, ${month0Outlay}]
									]);

 								 var chart3 = new google.visualization.ColumnChart(document.getElementById('chart_div3'));
								 var chart4 = new google.visualization.ColumnChart(document.getElementById('chart_div4'));
 								 chart3.draw(data3, chart_options);
								 chart4.draw(data4, chart_options);
 							 }

 							</script>
					</div>


			<!-- 탭3번-->
					 <div id="your-tab-id-3">

						 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
						 <script>
						 	google.charts.load('current', {packages:['corechart']});
						 </script>

						 <div style="display:inline-block;" id="chart_div7"></div>

						 <script type="text/javascript">

						 		 google.charts.setOnLoadCallback(drawChart);

						 		 var chart_options = {
						 			 title : '수입 지출 통계',
						 			 width : 500,
						 			 height : 400,
						 			 bar : {
						 				 groupWidth : '50%'
						 			 },
						 			 isStacked : true
						 		 };

						 		 function drawChart(){
						 			 var data7 = new google.visualization.arrayToDataTable([
						 				 ['카테고리', '수입', '지출'],
						 				 ['식비', ${foodIncome},${foodOutlay}],
						 				 ['교통비',${trafficIncome},${trafficOutlay}],
						 				 ['생필품',${needsIncome},${needsOutlay}],
						 				 ['기타',${etcIncome},${etcOutlay}]
						 			 ]);

						 			 var chart7 = new google.visualization.ColumnChart(document.getElementById('chart_div7'));
						 			 chart7.draw(data7, chart_options);
						 		 }

						 		</script>


						 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
						<script>
							google.charts.load('current', {packages:['corechart']});
						</script>

						<div style="display:inline-block;" id="chart_div6"></div>

						<script type="text/javascript" src="https://www.google.com/jsapi"></script>
						<script type="text/javascript">
						google.load("visualization", "1", {'packages':["corechart"]});
						google.setOnLoadCallback(drawChart);	// pie

						function drawChart() {
							var data6 = new google.visualization.DataTable();
							data6.addColumn('string', '시간');
							data6.addColumn('number', '금액');
							data6.addRows([
								['식비', ${foodOutlay}],['교통비',${trafficOutlay}],['생필품',${needsOutlay}],['기타',${etcOutlay}]
							]);

							var options = {
								title: '카테고리별 지출',
								fontSize: '14',
								fontName: '굴림체',
								'is3D':true
							};

							var chart6 = new google.visualization.PieChart(document.getElementById('chart_div6'));
							chart6.draw(data6, options);
						}
					</script>
				</div>


					
					 
					 
					 

				  </div>
				</div><!-- /.content_holder -->
			</div><!-- /.tabs_holder -->
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
										<li>&copy; Untitled. All rights reserved</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
									</ul>
								</div>
							</div>
						</div>
					</footer>
				</div>

			
		<!-- Scripts -->
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.10/jquery-ui.min.js"></script>
		<script type="text/javascript" src="http://onlinehtmltools.com/tab-generator/skinable_tabs.min.js"></script>
		 <script type="text/javascript">
			$('.tabs_holder').skinableTabs({
				effect: 'basic_display',
				skin: 'skin6',
				position: 'top'
			});
		</script> 
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script> 

			</body>
</html>
