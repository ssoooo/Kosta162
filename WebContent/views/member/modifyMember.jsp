<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>bootstrap template</title>

<!-- Bootstrap -->
<link href="../resources/assets/css/bootstrap1.min.css" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet"
	href="../resources/assets/css/font-awesome1.min.css" media="screen"
	title="no title">
<!-- Custom style -->
<link rel="stylesheet" href="../resources/assets/css/style1.css"
	media="screen" title="no title">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
$(document).ready(function(){
    $("#selectBank").val('${bank }').attr("selected", true);
    $("#selectPhone").val('${mobileCarrier }').attr("selected", true);
});

	var bank;
	var phone;
</script>
</head>
<body>



	<div class="page-header">
		<h1>멤버 수정</h1>
	</div>
	<div class="col-md-6 col-md-offset-3">
		<form role="form"
			action="${pageContext.request.contextPath }/memberGroup/modifyMember.do"
			method="post">
			<div class="form-group">


				<b>아이디 : </b> <b>${member.memberId }</b>

			</div>

			<div class="form-group">
				<label for="InputNickName">닉네임</label> <input type="text"
					class="form-control" id="InputNickName" name="nickname"
					placeholder="새 닉네임을 입력하세요" value="${member.nickname }">
				<p class="help-block">사용 가능한 별명입니다.</p>
				<input type="hidden" id="memberId" name="memberId"
					value="${member.memberId }" />
			</div>
			<div class="form-group">
				<label for="InputPassword1">비밀번호</label> <input type="password"
					class="form-control" id="InputPassword1" name="password"
					placeholder="새 비밀번호" required="required">
			</div>
			<div class="form-group">
				<label for="InputPassword2">비밀번호 확인</label> <input type="password"
					class="form-control" id="InputPassword2" placeholder="비밀번호 확인"
					required="required">
				<p class="help-block">비밀번호가 일치합니다.</p>
			</div>
			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" id="username" name="name"
					placeholder="새 이름을 입력하세요" value="${member.name }">
			</div>
			<div class="form-group">
				<label for="InputEmail">이메일 주소</label> <input type="email"
					class="form-control" id="InputEmail" name="email"
					placeholder="새 이메일 주소를 입력하세요" value="${member.email }">
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
					name="InputAccount" placeholder="계좌를 입력해 주세요"
					value="${accountNum }"> <input type="hidden"
					id="account" name="account" />
			</div>

			<div class="form-group">
				<label for="phoneNumber">휴대폰 번호</label><br /> <select
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
					name="InputPhoneNumber" placeholder="- 없이 입력해 주세요"
					value="${phoneNum }"> <input type="hidden"
					id="phoneNumber" name="phoneNumber" />
			</div>

			<br />

			<div class="form-group text-center">
				<button type="submit" id="submit" class="btn btn-info">
					수정완료<i class="fa fa-check spaceLeft"></i>
				</button>
				<button type="button" class="btn btn-warning"
					onclick="location.href='myDetail.do' ">
					취소<i class="fa fa-times spaceLeft"></i>
				</button>
			</div>
			<script>
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

			<br />
		</form>
	</div>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../resources/assets/js/bootstrap.min.js"></script>
</body>
</html>
