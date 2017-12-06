<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
	<head>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<title>��� ������</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="../../resources/assets/css/main.css" />
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
							<h1><a href="main.html">�˶�����</a></h1>
							<span>Kosta 162��</span>
						</div>

						<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="main.html">Home</a></li>
							<li>
								<a href="main.html">Message</a>
									<ul class="ul_accept">
										<p class="group_invite_list">
											����
											<div class="accept_reject">
												<a href="">����</a>
												<a href="">����</a>
											</div>
										</p>
										<p class="group_invite_list">
											����
											<div class="accept_reject">
												<a href="">����</a>
												<a href="">����</a>
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
					<li><a href="#your-tab-id-1">���� ���</a></li>
					  <li><a href="#your-tab-id-2">�Ⱓ</a></li>
						 <li><a href="#your-tab-id-3">ī�װ�</a></li>
						 <!--  -->
						  <li> <a href="#your-tab-id-4">�̺�Ʈ</a></li>
						  
						  
						  
						  
						  
					 </ul>


		 <!-- ��1��-->
				 <div class="content_holder">
				  <div id="your-tab-id-1">
					
						<div>
							<br />
						</div>
						<div class="form-group">
								<label class="col-lg-2 control-label"><h2>���� : ${income}��</h2></label>
								<label class="col-lg-2 control-label"><h2>���� : ${outlay}��</h2></label>
								<label class="col-lg-2 control-label"><h2>�հ� : ${groupBalance}��</h2></label>
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
						 data.addColumn('string', 'ī�װ�');
						 data.addColumn('number', '�ݾ�');
						 data.addRows([
							 ['����', ${income}],['����',${outlay}]
						 ]);

						 var options = {
							 title: '���� ���� ����',
							 fontSize: '14',
							 fontName: '����ü',
							 'is3D':true
						 };

						 var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
						 chart.draw(data, options);
					 }
				 </script>
				 </div>


		<!-- ��2��-->
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
 								 title : '�⺰ ���� ���� ���',
 								 width : 500,
 								 height : 400,
 								 bar : {
 									 groupWidth : '50%'
 								 },
 								 isStacked : true
 							 };

 							 function drawChart(){
 								 var data3 = new google.visualization.arrayToDataTable([
 									 ['���', '����', '����'], // ���� �׸��� �׸��
  									['${year4}', ${year4Income}, ${year4Outlay}], // ����� �׸���� �����־�� �մϴ�.
  									['${year3}', ${year3Income}, ${year3Outlay}],
  									['${year2}', ${year2Income}, ${year2Outlay}],
  									['${year1}', ${year1Income}, ${year1Outlay}]
  									]);

									var data4 = new google.visualization.arrayToDataTable([
										['����', '����', '����', '�հ�'],
										['1����', 10, 30, 40],
										['2����', 30, 30, 60],
										['3����', 25, 30, 50],
										['4����', 35, 20, 50],
										['5����', 60, 20, 50],
										['6����', 30, 20, 50],
										['7����', 30, 20, 50],
										['8����', 20, 20, 50],
										['9����', 32, 20, 50],
										['10����', 55, 20, 50],
										['11����', 34, 20, 50],
										['12����', 54, 20, 50]
									]);

 								 var chart3 = new google.visualization.ColumnChart(document.getElementById('chart_div3'));
								 var chart4 = new google.visualization.ColumnChart(document.getElementById('chart_div4'));
 								 chart3.draw(data3, chart_options);
								 chart4.draw(data4, chart_options);
 							 }

 							</script>
					</div>


			<!-- ��3��-->
					 <div id="your-tab-id-3">

						 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
						 <script>
						 	google.charts.load('current', {packages:['corechart']});
						 </script>

						 <div style="display:inline-block;" id="chart_div7"></div>

						 <script type="text/javascript">

						 		 google.charts.setOnLoadCallback(drawChart);

						 		 var chart_options = {
						 			 title : '���� ���� ���',
						 			 width : 500,
						 			 height : 400,
						 			 bar : {
						 				 groupWidth : '50%'
						 			 },
						 			 isStacked : true
						 		 };

						 		 function drawChart(){
						 			 var data7 = new google.visualization.arrayToDataTable([
						 				 ['ī�װ�', '����', '����'],
						 				 ['�ĺ�', ${foodIncome},${foodOutlay}],
						 				 ['�����',${trafficIncome},${trafficOutlay}],
						 				 ['����ǰ',${needsIncome},${needsOutlay}],
						 				 ['��Ÿ',${etcIncome},${etcOutlay}]
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
							data6.addColumn('string', '�ð�');
							data6.addColumn('number', '�ݾ�');
							data6.addRows([
								['�ĺ�', ${foodOutlay}],['�����',${trafficOutlay}],['����ǰ',${needsOutlay}],['��Ÿ',${etcOutlay}]
							]);

							var options = {
								title: 'ī�װ���',
								fontSize: '14',
								fontName: '����ü',
								'is3D':true
							};

							var chart6 = new google.visualization.PieChart(document.getElementById('chart_div6'));
							chart6.draw(data6, options);
						}
					</script>
				</div>


	<!-- ��4��-->
					 <div id="your-tab-id-4">
					 

					<c:forEach var="price" varStatus="status" items="${prices}">
						
						<div class="form-group">
								<label class="col-lg-2 control-label"><h2>���� : ${price.key}��</h2></label>
								<label class="col-lg-2 control-label"><h2>���� : ${price.value}��</h2></label>
								<script type="text/javascript">
								var i = ${price.key};
								var o = ${price.value};
								var b = i-o;
								document.write("<label class='col-lg-2 control-label'><h2>�հ� : ");
								document.write(b);
								document.write("��</h2></label>");
								
								</script>
								
								
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
						 data.addColumn('string', 'ī�װ�');
						 data.addColumn('number', '�ݾ�');
						 data.addRows([
							 ['����', ${price.key}],['����',${price.value}]
						 ]);

						 var options = {
							 title: '���� ���� ����',
							 fontSize: '14',
							 fontName: '����ü',
							 'is3D':true
						 };

						 var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
						 chart.draw(data, options);
					 }
				 </script>
				 </c:forEach>
				 
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
