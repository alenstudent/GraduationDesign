<%@page pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>01</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
    <script src="js/html5shiv.min.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div class="container">
		<h1></h1>
	
		<form class="form-horizontal" action="${context }/demo/add" method="post">
			<div class="form-group">
				<label class="control-label col-md-3">生日</label>
				<div class="col-md-9">
					<input type="text" name="birthDate" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">名字</label>
				<div class="col-md-9">
					<input type="text" name="name" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">年龄</label>
				<div class="col-md-9">
					<input type="text" name="age" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">工资</label>
				<div class="col-md-9">
					<input type="text" name="salary" class="form-control" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<button type="submit" class="btn btn-default">测试</button>
				</div>
			</div>
		</form>
	</div>




	<script src="js/jquery.min.js" type="text/javascript"></script>
	<script src="js/bootstrap.js" type="text/javascript"></script>
</body>
</html>