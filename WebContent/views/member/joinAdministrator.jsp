<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>bootstrap template</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="../../resources/assets/css/bootstrap1.min.css" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet"
	href="../../resources/assets/css/font-awesome1.min.css" media="screen"
	title="no title">
<!-- Custom style -->
<link rel="stylesheet" href="../../resources/assets/css/style1.css"
	media="screen" title="no title">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript">
	var bank;
	var phone;
	$(document).ready(function(){
		$("#InputId").keyup(function () {
			var inputId = $("#InputId").val();
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath }/memberGroup/checkId.do',
				data : {
					memberId : inputId
				},
				dataType : 'text',
				success: function(data){
					if(data == "success"){
						$("#idCheck").html("사용가능한 ID입니다.")
						} else{
							$("#idCheck").html("사용중인 ID입니다.")
						}
				},
				error : function(data){
					console.log(data);
					$("#idCheck").html("디비조회실패.")
					
				}
				
			});
		});
		$("#groupName").keyup(function () {
			var inputGroup = $("#groupName").val();
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath }/memberGroup/checkGroup.do',
				data : {
					groupName1 : inputGroup
				},
				dataType : 'text',
				success: function(data){
					var data111 = data
					if(data111){
					$("#groupCheck").html("사용중인 모임명입니다.")
					console.log(data);
					} else{
						$("#groupCheck").html("이건뭔데 정신안차리나.")
					}
					
				},
				error : function(data){
					console.log(data);
					$("#groupCheck").html("사용할수 있는 모임명입니다.")
					
				}
				
			});
		});
		$("#InputPassword2").keyup(function(){
			var password1 = $('#InputPassword1').val();
			var password2 = $('#InputPassword2').val();
			
				if(password1==password2){
				$("#passwordCheck").html("비밀번호가 일치합니다.")
				}else{
				$("#passwordCheck").html("비밀번호가 일치하지않습니다.")
				}
				
			}
		);
		
	});

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#imgHere').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
</script>
</head>
<body>



	<div class="page-header">
		<h1>회원 가입</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form role="form"
			action="${pageContext.request.contextPath }/memberGroup/registGroupAndJoinMember.do" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="InputId">아이디</label> <input type="text"
					class="form-control" id="InputId" name="memberId" placeholder="아이디"
					required="required">
				<p id="idCheck" class="help-block"></p>
			</div>
			<div class="form-group">
				<label for="InputPassword1">비밀번호</label> <input type="password"
					class="form-control" id="InputPassword1" name=password
					placeholder="비밀번호" required="required">
			</div>
			<div class="form-group">
				<label for="InputPassword2">비밀번호 확인</label> <input type="password"
					class="form-control" id="InputPassword2" placeholder="비밀번호 확인"
					required="required">
				<p id="passwordCheck" class="help-block"></p>
			</div>
			<div class="form-group">
				<label for="userName">이름</label> <input type="text"
					class="form-control" id="userName" name="name"
					placeholder="이름을 입력해 주세요" required="required">
			</div>
			<div class="form-group">
				<label for="userNickName">별명</label> <input type="text"
					class="form-control" id="userNickName" name="nickname"
					placeholder="별명을 입력해 주세요" required="required">
			</div>
			<div class="form-group">
				<label for="InputEmail">이메일 주소</label> <input type="email"
					class="form-control" id="InputEmail" name="email"
					placeholder="이메일 주소">
			</div>
			<div class="form-group">
				<label for="InputAccount">계좌번호</label><br /> <select
					id="selectBank" name="selectBank">
					<option selected>은행 선택</option>
					<option>국민</option>
					<option>우리</option>
					<option>신한</option>
					<option>농협</option>
					<option>카카오</option>
				</select>
				<script type="text/javascript">
					function inputBankVals() {
						bank = $("#selectBank option:selected").text();
					}
					$("#selectBank").change(inputBankVals);
					inputBankVals();
				</script>
				<input type="text" class="form-control" id="InputAccount"
					name="InputAccount" placeholder="계좌를 입력해 주세요"> <input
					type="hidden" id="account" name="account">
			</div>
			<div class="form-group">
				<label for="InputPhoneNumber">휴대폰 번호</label><br /> <select
					id="selectPhone" name="selectPhone">
					<option selected>통신사 선택</option>
					<option>SKT</option>
					<option>KT</option>
					<option>LG</option>
				</select>
				<script type="text/javascript">
					function inputPhoneVals() {
						phone = $("#selectPhone option:selected").text();
					}
					$("#selectPhone").change(inputPhoneVals);
					inputPhoneVals();
				</script>
				<input type="text" class="form-control" id="InputPhoneNumber"
					name="InputPhoneNumber" placeholder="- 없이 입력해 주세요"><input
					type="hidden" id="phoneNumber" name="phoneNumber" />
			</div>


			<br />
			<h3>모임 생성</h3>
			<br />
			<div class="form-group">
				<label for="groupName">모임명</label> <input type="text"
					class="form-control" id="groupName" name="groupName"
					placeholder="이름을 입력해 주세요" required="required">
					<p id="groupCheck" class="help-block"></p>
			</div>

			<div class="form-group">
				<label for="groupIntroduce">모임 소개</label>
				<textarea class="form-control" id="groupIntroduce"
					name="groupIntroduce" rows="4"></textarea>
			</div>

			<div class="form-group">
				<b>대표 사진</b> <input type="file" name="imgFile"
					onchange="readURL(this);" />

				<div class="col-lg-10">
					<img id="imgHere" src="#" style="max-width: 400px;" />
				</div>
			</div>
			<br />

			<div class="form-group text-center">
				<button type="submit" id="submit" class="btn btn-info">
					회원가입<i class="fa fa-check spaceLeft"></i>
				</button>
				<button type="button" class="btn btn-warning"
					onclick="location.href='login.html' ">
					가입취소<i class="fa fa-times spaceLeft"></i>
				</button>
			</div>
			<br />
			<script type="text/javascript">
				function accountVals() {
					var accountNum = $('#InputAccount').val();
					$('#account').val(bank + "/" + accountNum);
				}

				$("#submit").click(accountVals);

				accountVals();
				function phoneVals() {
					var phoneNum = $('#InputPhoneNumber').val();
					$('#phoneNumber').val(phone + "/" + phoneNum);
				}

				$("#submit").click(phoneVals);

				phoneVals();
			</script>
		</form>
	</div>


	<script src="../../resources/assets/js/bootstrap.min.js"></script>
</body>
</html>
