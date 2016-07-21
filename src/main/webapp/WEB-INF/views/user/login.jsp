<%@ page import="com.Remento.Common.RementoCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= RementoCommon.appName %> - 로그인</title>
<%
	String ctx = request.getContextPath();
%>
<c:set value="<%= ctx %>" var="ctx"/>

</head>
<body>

로그인 페이지 <br>

<form name="login" method="post" action="loginProcess">

	<label>아이디</label><input type="text" name="id">
	<label>비밀번호</label><input type="text" name="pw">
	
	<input type="submit" value="로그인"/>

</form>


<!-- contextPath variable declare -->
<script type="text/javascript">
	var ctx = "<%= request.getContextPath() %>";
</script>

<%-- common js include file --%>
<%@include file="/WEB-INF/views/js/common-lib.jsp" %>

<script type="text/javascript"></script>
</body>
</html>