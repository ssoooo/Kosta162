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
<title>Verti by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/grade.css" />
<!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>
<body class="no-sidebar">
	<div id="page-wrapper">

		<!-- Header -->
		<div id="header-wrapper">
			<header id="header" class="container">

				<!-- Logo -->
				<div id="logo">
					<a href="${pageContext.request.contextPath}/memberGroup/main.do"><img src="${pageContext.request.contextPath}/resources/images/alal.png" width="320px;"/></a>
					<span>알아두면 쓸데있는 신박하고 잡다한 가계부</span>
				</div>

			</header>
		</div>

		<!-- Main -->
		<div id="main-wrapper">
			<div class="container">
				<div id="content">

					<!-- Content -->

					<div id="box3">
						<h2>모임 검색</h2>
						<hr>
						<form
							action="${pageContext.request.contextPath }/memberGroup/searchGroupsByGroupName.do"
							method="post">
							<table id="search">
								<tbody>
									<tr>
										<th class="th1">모임명</th>
										<td class="td2"><input class="input_id" type="text"
											name="groupName"></td>
										<td class="td3"><button>검색</button></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>

					<div id="group_row">

						<!-- Box -->
						<c:forEach items="${groupList }" var="group" varStatus="status">
							<section class="group_box">
							<input type="hidden" name = "groupName" value ="${group.groupName }">
								<img src="${group.groupImage }" alt="noImage" />
								<div class="signIn_group">
									<header>
										<h2 >
											${group.groupName }
												<button name ="groupSelectBtn" class="sign" onclick="setChildText${status.count}();">선택</button> 
										</h2>
										
									</header>
								</div>
							</section>
						<script type="text/javascript">
											function setChildText${status.count }() {
												var parent = window.opener;
												var groupId = ${group.groupId };
												//case1. var groupName1 = ${group.groupName }; 영어이름은 안받아지고 숫자이름만 받아지는데 왜그런건가? 아마도 var타입문제인듯하다.
												//case1. document.getElementById('groupName1+${status.count}');
												
												
												//console.log(groupName);
												var groupName = document.getElementsByName('groupName')[${status.count }].value;
												
												parent.document.getElementById('groupId').value=groupId;

												parent.document.getElementById('groupName').value=groupName;
												// case1.  parent.document.getElementById('groupName').value=groupName1;
												
												window.close();

											}
										</script>
						</c:forEach>
									
						<!-- Box -->
					

					</div>
				</div>
			</div>
		</div>

		<!-- Footer -->


	</div>



</body>
</html>
