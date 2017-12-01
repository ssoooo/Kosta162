<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>bootstrap template</title>

    <!-- Bootstrap -->
    <link href="../resources/assets/css/bootstrap1.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link rel="stylesheet" href="../resources/assets/css/font-awesome1.min.css" media="screen" title="no title" charset="utf-8">
    <!-- Custom style -->
    <link rel="stylesheet" href="../resources/assets/css/style1.css" media="screen" title="no title" charset="utf-8">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script>
    	var bank;
    	var phone;
    </script>
  </head>
  <body>


      <article class="container">
        <div class="page-header">
          <h1>��� ����</h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form role="form" action="${pageContext.request.contextPath }/memberGroup/modifyMember.do" method="post" >
            <div class="form-group">
             
              
              <b>���̵� : </b>
              <b>${member.memberId }</b>
				
			</div>
			
            <div class="form-group">
              <label for="InputNickName">�г���</label>
              <input type="text" class="form-control" id="InputNickName" name="nickname" placeholder="�� �г����� �Է��ϼ���" value="${member.nickname }">
				<p class="help-block">��� ������ �����Դϴ�.</p>
				<input type="hidden" id="memberId" name="memberId" value="${member.memberId }"/> 
			</div>
            <div class="form-group">
              <label for="InputPassword1">��й�ȣ</label>
              <input type="password" class="form-control" id="InputPassword1" name="password" placeholder="�� ��й�ȣ" required="required">
			</div>
            <div class="form-group">
              <label for="InputPassword2">��й�ȣ Ȯ��</label>
              <input type="password" class="form-control" id="InputPassword2" placeholder="��й�ȣ Ȯ��" required="required">
				<p class="help-block">��й�ȣ�� ��ġ�մϴ�.</p>
			</div>
            <div class="form-group">
              <label for="username">�̸�</label>
              <input type="text" class="form-control" id="username" name="name" placeholder="�� �̸��� �Է��ϼ���" value="${member.name }">
            </div>
            <div class="form-group">
              <label for="InputEmail">�̸��� �ּ�</label>
              <input type="email" class="form-control" id="InputEmail" name = "email" placeholder="�� �̸��� �ּҸ� �Է��ϼ���" value="${member.email }">
            </div>
            <div class="form-group">
              <label for="InputAccount">���¹�ȣ</label><br />
              <select id="selectBank" name="selectBank">
                  <option selected id="selectedBank" > ���� ���� </option>
                  <option>����</option>
                  <option>�츮</option>
                  <option>����</option>
                  <option>����</option>
                  <option>īī��</option>
              </select>
            <script>
			function inputBankVals() {
				bank = $("#selectBank option:selected").text();
			}
			$("#selectBank").change(inputBankVals);
			inputBankVals();
			</script>
              <input type="text" class="form-control" id="InputAccount" name = "InputAccount" placeholder="���¸� �Է��� �ּ���" value="${member.account }">
       			 <input type="hidden" id="account" name="account" />
            </div>
            
            <div class="form-group">
              <label for="phoneNumber">�޴��� ��ȣ</label><br />
              <!-- <select id="selectPhone" name="selectPhone">
                  <option selected id="selectedPhone" name="selectedPhone"> ��Ż� ���� </option>
                  <option>SKT</option>
                  <option>KT</option>
                  <option>LG</option>
              </select>
               -->
              <input type="hidden" id="InputPhoneNumber" name="InputPhoneNumber" /> 
              <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="- ���� �Է��� �ּ���" value="${member.phoneNumber }">
            </div>
				 	
            <br />

            <div class="form-group text-center">
              <button type="submit" id="submit" class="btn btn-info">�����Ϸ�<i class="fa fa-check spaceLeft"></i></button>
              <button type="button" class="btn btn-warning" onclick="location.href='myDetail.do' ">���<i class="fa fa-times spaceLeft"></i></button>
            </div>
            <script>
			function accountVals() {
				var accountNum = $('#InputAccount').val();
				$('#account').val(bank + "1 " + accountNum);
			}
														
			$("#submit").click(accountVals); 
														
			accountVals();
			</script>
			
            <br />
          </form>
        </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
