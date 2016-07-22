<%@ page import="com.Remento.Common.RementoCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= RementoCommon.appName %> - 회원가입</title>

<c:set value="${pageContext.request.contextPath }" var="ctx"/>
<%@include file="/WEB-INF/views/css/meta.jsp" %>
<link href="${ctx }/css/user/join.css" rel="stylesheet" />
</head>
<body>

<div id="wrap">
	
	<div id="header">
		<%@include file="/WEB-INF/views/include/header.jsp" %>
	</div>
	
	<div id="container">
		<div class="join-container">
			<h2>회원가입</h2>
				<div class="join-wrap">
					<form action="${ctx }/joinProc" id="joinForm" method="post">
						<div class="essential-wrap join-section">
						<h3 class="essential-title">필수항목</h3>
							<div class="join-row btn-input">
								<label>
									<input type="text" id="userId" class="userId" name="userId" placeholder="아이디" />
								</label>
								<button type="button" class="btn btn-default right-btn id-check-btn">중복확인</button>
								
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
							
							<div class="join-row stack-wrap">
								<label>
									<input type="password" id="userPw" class="userPw" name="userPw" placeholder="비밀번호" />
								</label>
								<label>
									<input type="password" id="pwCheck" class="pwCheck" name="pwCheck" placeholder="비밀번호 확인" />
								</label>
								
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
							
							<div class="join-row">
								<label>
									<input type="text" id="userName" class="userName" name="userName" placeholder="이름" />
								</label>
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
							
							<div class="join-row btn-input">
								<label>
									<input type="text" id="userEmail" class="userEmail" name="userEmail" placeholder="이메일" />
								</label>
								<button type="button" class="btn btn-default right-btn">인증코드받기</button>
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
							
							<div class="join-row btn-input">
								<label>
									<input type="text" id="zipCode" class="zipCode" name="zipCode" placeholder="우편번호" />
								</label>
								<button type="button" class="btn btn-default right-btn">우편번호검색</button>
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
							
							<div class="join-row adress-info stack-wrap">
								<label>
									<input type="text" id="adress" class="adress" name="adress" placeholder="우편번호를 먼저 검색해주세요." />
								</label>
								<label>
									<input type="text" id="etcAdress" class="etcAdress" name="etcAdress" placeholder="나머지 주소를 입력해주세요." />
								</label>
								<p class="error-msg hide">필수항목입니다.</p>
							</div>
						</div>
						
						<div class="optional-wrap join-section">
							<h3 class="optional-title">선택항목</h3>
							<div class="join-row">
							</div>
						</div>
						
						<div class="btn-wrap">
							<button type="submit" class="">
								회원가입
							</button>
						</div>
					</form>
				</div>
		</div>
	</div>
	
	<div id="footer">
		<%@include file="/WEB-INF/views/include/footer.jsp" %>
	</div>

</div>

<!-- contextPath variable declare -->
<script type="text/javascript">
	var ctx = "${ctx }";
</script>

<%-- common js include file --%>
<%@include file="/WEB-INF/views/js/common-lib.jsp" %>

<script type="text/javascript">

var idCheckState = false,
	loginState = false,
	$form = $("#joinForm"),
	$input = $form.find("input");

$("#userId").on('keyup', function( event ) {
  var keyCode = event.keyCode || event.which;
  
  if (keyCode === 13) { 
 	event.preventDefault();
  	$(".id-check-btn").trigger("click");
  }
});

$input.on("blur", function ( event ) {
	validation( $(this) );
});

$(".id-check-btn").on("click", function ( event ) {
	event.preventDefault();
	$.ajax({
		cache : false,
		async : false,
		url : ctx + "/rest/idCheck",
		method : "post",
		data : {
			userId : $(this).prev().children("input").val()
		}
	}).done( function ( response ) {
		
		if ( response > 0 ) {
			idCheckState = false;
		} else {
			idCheckState = true;
		}
		
		console.log( response );
		
	}).fail( function ( error ) {
		console.log( error )
	});
	console.log( idCheckState );
});

$('#joinForm').on('keyup keypress', function( event ) {
  var keyCode = event.keyCode || event.which;
  if (keyCode === 13) { 
	  event.preventDefault();
	  return false;
  }
});

$form.submit(function( event ) {
// 	event.preventDefault();
	joinValidation( $(this) );
	var $input = $(this).find("input");
	
	if ( !idCheckState && !loginState ) {
		return false;
	}
	
	
});

function validation ( data ) {
	
	var $target = data.closest(".join-row").find(".error-msg"),
		errorMsg = {
			"commonText" : "필수항목입니다.",
			"lengthCheck" : "아이디는 최소 4자 이상입니다."
		};

	if ( data.hasClass( "userId" ) ) {
		if ( data.val() == null || data.val() == "" ) {
			$target.removeClass("hide").addClass("show").text( errorMsg["commonText"] );
		} else if ( data.val().length < 4 ) {
			$target.removeClass("hide").addClass("show").text( errorMsg["lengthCheck"] );
		}
	}
}

function joinValidation ( form ) {
	$input = form.find(".essential-wrap input");
	for ( var i = 0; i < $input.length; i++) {
		console.log( $input[i] );
		if ( $($input[i]).val() == null || $($input[i]).val() == "" ) {
			loginState = false;
		} else {
			loginState = true;
		}
	}
	
}

</script>

</body>
</html>	