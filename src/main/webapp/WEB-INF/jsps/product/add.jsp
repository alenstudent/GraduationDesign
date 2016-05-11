
<%@page pageEncoding="utf-8"%>

<%
	String title = "添加产品";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>添加产品</h1>
		</div>


		<form class="form-horizontal productForm" role="form">
			<div class="form-group">
				<label for="proNum" class="col-sm-2 control-label">产品编号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proNum"
						placeholder="请输入产品编号">
				</div>
			</div>
			<div class="form-group">
				<label for="proName" class="col-sm-2 control-label">产品名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proName"
						placeholder="请输入产品名称">
				</div>
			</div>
			<div class="form-group">
				<label for="proGgxh" class="col-sm-2 control-label">规格型号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proGgxh"
						placeholder="请输入规格型号">
				</div>
			</div>
			<div class="form-group">
				<label for="proUnion" class="col-sm-2 control-label">计量单位</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proUnion"
						placeholder="请输入计量单位">
				</div>
			</div>
			<div class="form-group">
				<label for="proTotalSaleCount" class="col-sm-2 control-label">累计销售量</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proTotalSaleCount"
						placeholder="请输入累计销售量">
				</div>
			</div>
			<div class="form-group">
				<label for="proCurrentStock" class="col-sm-2 control-label">当前库存</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proCurrentStock"
						placeholder="请输入当前库存">
				</div>
			</div>
			<div class="form-group">
				<label for="proAdviceSalePrice" class="col-sm-2 control-label">建议销售价</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proAdviceSalePrice"
						placeholder="请输入建议销售价">
				</div>
			</div>
			<div class="form-group">
				<label for="proManufacturer" class="col-sm-2 control-label">生产厂商</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proManufacturer"
						placeholder="请输入生产厂商">
				</div>
			</div>
			<!-- <div class="form-group">
				<label for="proCraeteTime" class="col-sm-2 control-label">创建时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proCraeteTime"
						placeholder="请输入创建时间">
				</div>
			</div>
			<div class="form-group">
				<label for="proUpdateTime" class="col-sm-2 control-label">更新时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proUpdateTime"
						placeholder="请输入更新时间">
				</div>
			</div>
			<div class="form-group">
				<label for="proUpdateUser" class="col-sm-2 control-label">更新人</label>
				<div class="col-sm-10">
					<input type="text" class="form-control productInput" id="proUpdateUser"
						placeholder="请输入更新人">
				</div>
			</div> -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default productAddBtn" value="添加" />
				</div>
			</div>
		</form>




<!-- 
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">客户名称</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusName"
						placeholder="请输入客户名称">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">联系地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusAddress"
						placeholder="请输入联系地址">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">邮政编码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusZipCode"
						placeholder="请输入邮政编码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">联系电话</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusPhone"
						placeholder="请输入联系电话">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">纳税号码</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusTaxNum"
						placeholder="请输入纳税号码">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">开户银行</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusBankAccount"
						placeholder="请输入开户银行">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">银行账号</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="cusBankName"
						placeholder="请输入银行账号">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="button" class="btn btn-default" value="添加" />
				</div>
			</div>
		</form>
 -->
	</div>
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
$(function(){
	$("input.productAddBtn").click(addProduct);
});

var canAdd = true;
function addProduct() {
	if (!canAdd) return;
	var button = $(this);
	canAdd = false;
	$(button).addClass("disabled");
	var param=$("form.productForm input.productInput").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/product/insert", param, function(data){
		debug(data);
		if (data.returnModel.code == 200) {
			alert("添加成功");			
		} else {
			alert(data.returnModel.msg);
		}
		$(button).removeClass("disabled");
		canAdd = true;
		
	}, function() {
		$(button).removeClass("disabled");
		canEdit = true;
	});
}
</script>


