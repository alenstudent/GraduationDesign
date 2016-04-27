<%@page pageEncoding="utf-8"%>

<%
	String title = "添加产品";
%>
<%@include file="includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>添加产品</h1>
		</div>

		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">产品的编号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proNum"
						placeholder="请输入产品的编号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proName"
						placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">规格型号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proGgxh"
						placeholder="请输入规格型号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">计量单位</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proUnion"
						placeholder="请输入计量单位">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">累计销售量</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proTotalSaleCount"
						placeholder="请输入累计销售量">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">当前库存量</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proCurrentStock"
						placeholder="请输入当前库存量">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">建议销售价</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proAdviceSalePrice"
						placeholder="请输入建议销售价">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">生产厂商</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="proManufacturer"
						placeholder="请输入生产厂商">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default" value="添加" />
				</div>
			</div>
		</form>

	</div>
</body>
<%@include file="includeJS.jsp"%>
<script src="${context}/js/updateProductPage.js" type="text/javascript"></script>


