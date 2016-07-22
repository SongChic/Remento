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
						<li>
							<a>스튜디오 리멘토</a>
						</li>
						<li>
							<a>제작과정</a>
						</li>
						<li>
							<a>3D 스캐너 정보</a>
						</li>
					</ul>
				</li>
				<li>
					<a>갤러리</a>
					<ul class="drop-menu">
						<li>
							<a>3D 모델 갤러리</a>
							<a>제품 갤러리</a>
						</li>
					</ul>
				</li>
				<li>
					<a>피규어제작</a>
					<ul class="drop-menu">
						<li>
							<a>제품구매</a>
						</li>
						<li>
							<a>예약하기</a>
						</li>
						<li>
							<a>방문서비스</a>
						</li>
						<li>
							<a>가격안내</a>
						</li>
						<li>
							<a>상품문의</a>
						</li>
					</ul>
				</li>
				<li><a>스캐닝예약</a></li>
				<li><a>파트너십</a></li>
				<li><a>고객센터</a></li>
				<li>
					<a>로그인</a>
					<ul class="drop-menu">
						<li>
							<a>로그인</a>
						</li>
						<li>
							<a>아이디 찾기</a>
						</li>
						<li>
							<a>비밀번호 찾기</a>
						</li>
						<li>
							<a href="${ctx }/join">회원가입</a>
						</li>
					</ul>
				</li>
<!-- 						<li><a>마이페이지</a></li> -->
			</ul>
		</div>
	</div>
</div>
