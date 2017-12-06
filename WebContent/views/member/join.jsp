<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>멤버가입 선택</title>
		
		<link rel="stylesheet" href="../../resources/assets/css/style3.css" />
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
</head>

<body>
  <br />
  <br />
  <br />
  <br />
  <br />
  <br />
  <div id="wrapper">
  <h1>잡계부 <span>멤버가입</span></h1>
  <ul>

    <!-- Cook { -->
    <li class="check cook_check">
      <input type="checkbox" id="cookcheck" value="" onclick="location.href='joinMember.jsp' ">
      <label for="cookcheck">OK</label>
      <div class="head_wrap">
        <div class="hat">
          <div class="hat_top"></div>
        </div>
        <div class="face">
          <div class="nose"></div>
          <div class="ear">
            <div class="left"></div>
            <div class="right"></div>
          </div>
        </div>
        <div class="beard_up"></div>
        <div class="beard"></div>
        <div class="body"></div>
      </div>
      <div class="head_wrap">
        <div class="hat">
          <div class="hat_top"></div>
        </div>
        <div class="face">
          <div class="nose"></div>
          <div class="ear">
            <div class="left"></div>
            <div class="right"></div>
          </div>
        </div>
        <div class="beard_up"></div>
        <div class="beard"></div>
        <div class="body"></div>
      </div>
    </li>
    <!-- } Cook -->

    <!-- Mr.T { -->
    <li class="check ba_check">
      <input type="checkbox" id="bacheck" value="" onclick="location.href='joinAdministrator.jsp' ">
      <label for="bacheck">OK</label>
      <div class="head_wrap">
        <div class="hair"></div>
        <div class="face">
          <div class="eyes">
            <span></span>
            <span></span>
          </div>
          <div class="nose"></div>
          <div class="ear">
            <div class="left"></div>
            <div class="right"></div>
          </div>
        </div>
        <div class="beard_up"></div>
        <div class="beard"></div>
        <div class="body">
          <span></span>
        </div>
        <div class="hand">
          <span></span>
          <span></span>
        </div>
      </div>
    </li>
    <!-- } Mr.T -->
    <div class="form-group text-center">
      <input type="text" class="btn btn-info" value="멤버"><i class="fa fa-check spaceLeft"></i></button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" class="btn btn-warning" value="총무"><i class="fa fa-times spaceLeft"></i></button>
    </div>
  </ul>
</div>
 

    <script src="../../resources/assets/js/index.js"></script>

</body>
</html>
