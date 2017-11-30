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
  </head>
  <body>


      <article class="container">
        <div class="page-header">
          <h1>��� ����</h1>
        </div>
        <div class="col-md-6 col-md-offset-3">
          <form role="form">
            <div class="form-group">
              <label for="InputEmail">���̵�</label>
              <input type="email" class="form-control" id="InputId" placeholder="���̵�">
				<p class="help-block">��� ������ ���̵��Դϴ�.</p>
			</div>
            <div class="form-group">
              <label for="InputPassword1">��й�ȣ</label>
              <input type="password" class="form-control" id="InputPassword1" placeholder="��й�ȣ">
			</div>
            <div class="form-group">
              <label for="InputPassword2">��й�ȣ Ȯ��</label>
              <input type="password" class="form-control" id="InputPassword2" placeholder="��й�ȣ Ȯ��">
				<p class="help-block">��й�ȣ�� ��ġ�մϴ�.</p>
			</div>
            <div class="form-group">
              <label for="username">�̸�</label>
              <input type="text" class="form-control" id="username" placeholder="�̸��� �Է��� �ּ���">
            </div>
            <div class="form-group">
              <label for="InputEmail">�̸��� �ּ�</label>
              <input type="email" class="form-control" id="InputEmail" placeholder="�̸��� �ּ�">
            </div>
            <div class="form-group">
              <label for="username">���¹�ȣ</label><br />
              <select>
                  <option selected> ���� ���� </option>
                  <option>����</option>
                  <option>�츮</option>
                  <option>����</option>
                  <option>����</option>
                  <option>īī��</option>
              </select>
              <input type="text" class="form-control" id="accounting" placeholder="���¸� �Է��� �ּ���">
            </div>
            <div class="form-group">
              <label for="username">�޴��� ��ȣ</label><br />
              <select>
                  <option selected> ��Ż� ���� </option>
                  <option>SKT</option>
                  <option>KT</option>
                  <option>LG</option>
              </select>
              <input type="text" class="form-control" id="accounting" placeholder="- ���� �Է��� �ּ���">
            </div>
					
            <br />
			
            <div class="form-group text-center">
              <button type="submit" class="btn btn-info">�����Ϸ�<i class="fa fa-check spaceLeft"></i></button>
              <button type="button" class="btn btn-warning" onclick="location.href='login.html' ">���<i class="fa fa-times spaceLeft"></i></button>
            </div>
            <br />
          </form>
        </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
