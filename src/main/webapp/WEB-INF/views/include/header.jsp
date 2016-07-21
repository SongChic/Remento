<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="lnb">
	<div class="lnb-container">
		<h1 class="logo">
			<a href="${ctx }/">
				<%@ include file="/WEB-INF/views/svg/logo.jsp" %>
			</a>
		</h1>
		
		<div class="s-menu">
			<ul class="menu-nav">
				<li>
					<a>리멘토</a>
					<ul class="drop-menu">
						<li>스튜디오 리멘토</li>
						<li>제작과정</li>
						<li>3D 스캐너 정보</li>
					</ul>
				</li>
				<li><a>갤러리</a></li>
				<li><a>피규어제작</a></li>
				<li><a>스캐닝예약</a></li>
				<li><a>파트너십</a></li>
				<li><a>고객센터</a></li>
				<li>
					<a>로그인</a>
					<ul class="drop-menu">
						<li>로그인</li>
						<li>아이디 찾기</li>
						<li>비밀번호 찾기</li>
						<li><a href="${ctx }/join">회원가입</a></li>
					</ul>
				</li>
<!-- 						<li><a>마이페이지</a></li> -->
			</ul>
		</div>
	</div>
</div>
