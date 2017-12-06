<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
  </head>
  <body>
  <table id="refreshList">
  <c:forEach items="${signInMemberList }" var="member" varStatus="sts">
															
									<ol ><p class="group_invite_list">${member.memberId }</ol>
								
									<div class="accept_reject">
										<input type="button" value = "수락" onclick="onclickFunction('${group.groupId}','${signIn.memberId }')"> <a href="">삭제</a>
									</div>
									</p>
									
								</c:forEach>
  </table>
  


 
  </body>
</html>
