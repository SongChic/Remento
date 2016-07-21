<%@ page import="com.Remento.Common.RementoCommon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= RementoCommon.appName %> - 샘플</title>

<c:set value="${pageContext.request.contextPath }" var="ctx"/>

<link href="${ctx }/css/index.css" rel="stylesheet" />
<%@include file="/WEB-INF/views/css/meta.jsp" %>

</head>
<body>

<div id="wrap">
	<div id="header">
		<%@include file="/WEB-INF/views/include/header.jsp" %>
	</div>
	
	<div id="container">
		<c:forEach items="${test }" var="test">
			${test.user_id }
		</c:forEach>
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

<script type="text/javascript"></script>
</body>
</html>