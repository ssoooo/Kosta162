<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>모임 페이지</title>
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
							<h1><a href="index.html">알뜰총雜</a></h1>
							<span>알뜰한 총무의 잡다한 가계부</span>
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
								<div id="sidebar">

									<!-- Sidebar -->
										<section>
											<h2>이벤트</h2>
											<ul class="style2">
												<li><a href="left-sidebar.html"><h3>전체 보기</h3></a></li>
												<li><a href="event.html"><h3>신입생 환영회<a href="eventDetail.html"><img class="event_info" src="assets/css/images/info.png"/></a></h3></a></li>
												<li><a href="no-sidebar.html"><h3>신입생 엠티</h3></a></li>
												<li><a href="no-sidebar.html"><h3>체육대회</h3></a></li>
											</ul>
												<a href="registEvent.html" class="button icon fa-info-circle">이벤트 추가</a>
											</footer>
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
                                <a href="${pageContext.request.contextPath}/record/showModifyEventRecord.do?recordId=${record.recordId}" style="float:right; margin-left:20px;">수정</a>
                                <a href="${pageContext.request.contextPath}/record/deleteEventRecord.do?=${record.recordId}" style="float:right">삭제</a>
                         </div>
                         <br>
                         <p style="padding:10px">
                             	${record.price} 원
							 <br/>
							 <br/>
							 <img src="${record.image}">
                         </p>
                    
  
                   <table class="table" style="font-size:13px; padding:20px;">
                   <tr>
                     <td>
                       <span style="float:left"><strong>이호정</strong>
                     </td>
                     <td class="text-right">
                       <span style="float:right">2017-11-23&nbsp;
                       <a href="${pageContext.request.contextPath}/comment/remove.do?articleId=${article.articleId}&commentId=${comment.commentId}">수정</a>
                     </td>
                   </tr>
                   <tr>
                     <td colspan="2">
                       <span style="float:left"><p class="txt">배고파요</p>
                     </td>
                   </tr>
                   </table>

                </div>
                <div class="panel-footer">
                	<div class="write_area">
                		<form action="${pageContext.request.contextPath}/comment/regist.do">
                			<div class="comment_write">
                				<textarea class="input_write_comment" name="comments" placeholder="댓글쓰기"></textarea>
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
