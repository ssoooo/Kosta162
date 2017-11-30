<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>모금액 현황</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="../../resources/assets/css/grade.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
								납부 현황
							</h2>
							<hr>
							<div id="paymemt">
								<div class="complete_member">
									<h3>전체 완납 멤버</h3>
									<div class="scroll_complete">
									<ul>
										<li>
											백민지<button>완납</button>
										</li>
										<li>
											이호정<button>완납</button>
										</li>
										<li>
											양희수<button>완납</button>
										</li>
										<li>
											성우형<button>완납</button>
										</li>
										<li>
											백민지<button>완납</button>
										</li>
									</ul>
									</div>
								</div>
								<div class="notYet_member">
									<h3><input type="checkbox" id="checkedAll">전체 미납 멤버</h3>
									<div class="scroll_notYet">
									<ul>
										<li>
											<input name="subCheck" type="checkbox" value=0>백민지<button class="button2">미납</button>
										</li>
										<li>
											<input name="subCheck" type="checkbox" value=1>이호정<button class="button2">미납</button>
										</li>
										<li>
											<input name="subCheck" type="checkbox" value=2>양희수<button class="button2">미납</button>
										</li>
										<li>
											<input name="subCheck" type="checkbox" value=3>성우형<button class="button2">미납</button>
										</li>
										<li>
											<input name="subCheck" type="checkbox" value=4>백민지<button class="button2">미납</button>
										</li>
									</ul>
									</div>
								</div>
							</div>
						</div>
						<button class="btn_send" onclick="window.open('messageWrite.html','win','width=600,height=600,toolbar=0,scrollbars=0,resizable=0')">메시지 전송</button>
						</div>
					</div>
				</div>

			<!-- Footer -->

			</div>

	</body>
</html>