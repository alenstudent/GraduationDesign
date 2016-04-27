<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>${title }</title>
<link href="${context}/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="${context}/css/bootstrap-dialog.min.css" rel="stylesheet"
	type="text/css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">
	var context = "${context}";
</script>
</head>