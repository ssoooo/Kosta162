<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<title>내역 상세</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main2.css" />

	</head>
	<body class="left-sidebar">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
						<div id="logo">
							<h1><a href="${pageContext.request.contextPath}/memberGroup/main.do">알뜰총雜</a></h1>
							<span>알뜰한 총무의 잡다한 가계부</span>
						</div>

						<!-- Nav -->
						<nav id="nav">
						  <ul>
							<li><a href="${pageContext.request.contextPath}/memberGroup/main.do">Home</a></li>
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
							<li class="current"><a href="${pageContext.request.contextPath}/views/member/login.jsp">Logout</a></li>
						  </ul>
						</nav>

					</header>
				</div>

			<!-- Main -->
				<div id="main-wrapper">
					<div class="container">
						<div class="row 50%">
							<div class="4u 12u$(medium)">
								<div id="sidebar">

									<!-- Sidebar -->
										<section>
								<h2>게시판</h2>
								<ul class="style2">
									<li><a
										href="${pageContext.request.contextPath}/memberGroup/group.do?groupId=${event.groupId}"><h3>모임보기</h3></a></li>
									<c:choose>
										<c:when test="${empty events}">
											<a class="list-group-item hidden-xs">개설된 이벤트가 없습니다.</a>
										</c:when>
										<c:otherwise>
											<c:forEach var="event" items="${events }">
												<li><a
													href="${pageContext.request.contextPath}/event/event.do?eventId=${event.eventId }&groupId=${event.groupId}">
														<h3>${event.eventName }
															<a href="${pageContext.request.contextPath}/event/eventDetail.do?eventId=${event.eventId }"><img
																class="event_info"
																src="../resources/assets/css/images/info.png" /></a>
														</h3>
												</a></li>
											</c:forEach>
										</c:otherwise>
									</c:choose>
								</ul>
								<a href="${pageContext.request.contextPath}/event/registEvent.do?groupId=${group.groupId}"
									class="button icon fa-info-circle">이벤트 추가</a>
							</section>

								</div>
							</div>
			<div class="8u 12u$(medium) important(medium)">
								<div id="content">
        <div class="col-sm-9 col-lg-9">
            <div>
                <h3>신입생 엠티</h3>
            </div>

            <div class="panel panel-default">
                <div class="panel-heading">
                   	${record.title}
                </div>
                <div class="panel-body">
                         <div class="post">
                              <strong>${record.memberId}</strong>
                              &nbsp;<span class="text-muted">${record.date}</span>
                              &nbsp;<span class="text-muted">${record.accounting}</span>
                                <a href="${pageContext.request.contextPath}/record/showModifyRecord.do?recordId=${record.recordId}" style="float:right; margin-left:20px;">수정</a>
                                <a href="${pageContext.request.contextPath}/record/deleteRecord.do?recordId=${record.recordId}" style="float:right">삭제</a>
                         </div>
                         <br>
                         <p style="padding:10px">
                             	${record.price} 원
							 <br/>
							 <br/>
							 <img src="${record.image}">
                         </p>
                   <script type="text/javascript">
                   
                   </script> 
  
                   <table class="table" style="font-size:13px; padding:20px;">
                   
                   
                   <c:forEach var="comment" items="${comments}" varStatus="status">
                   <tr>
                     <td>
                       <span style="float:left"><strong>${comment.memberId}</strong></span>
                     </td>
                     <td class="text-right">
                       <span style="float:right">${comment.date }&nbsp;
                       
                       <a href="${pageContext.request.contextPath}/comment/commentDelete.do?commentId=${comment.commentId}">삭제</a>
                     </span>
                    
                     </td>
                   </tr>
                   <tr><!-- <span style="float:left">${comment.content}</span>-->
                     <td colspan="2">
                     <form action="${pageContext.request.contextPath}/comment/commentModify.do" method="POST">
                       <div class="panel-footer">
                      	${comment.content}
                      
                			
                			</div>
                			</form>
                     </td>
                   </tr>
                   
                   </c:forEach>
                   
                   </table>

                </div>
                
                <div class="panel-footer">
                	<div class="write_area">
                		<form action="${pageContext.request.contextPath}/comment/commentRegist.do" method="POST">
                			<input type="hidden" name="recordId" value="${record.recordId}">
                			<div class="comment_write">
                				<textarea class="input_write_comment" name="content" placeholder="댓글쓰기"></textarea>
                				<input type="submit" class="comment_submit" value="등록">
                			</div>
                		</form>
                	</div>
                </div>
            </div>

				<div class="back_list">
					 <a href="event.html">
						 <button class="algin_list">목록</button>
					 </a>
				 </div>
        </div>
			 
			 </div></div>
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
