
<%@page pageEncoding="utf-8"%>

<%
	String title = "编辑产品";
%>
<%@include file="../includeHeader.jsp"%>
<body>
	<c:choose>
		<c:when test="${returnModel.code != 200 }">
			<div class="container">
				<div align="center">
					<h1>网络繁忙，请返回重试</h1>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="container">
				<div align="center">
					<h1>编辑 ${returnModel.body.proName} 信息</h1>
				</div>
		
		
				<form class="form-horizontal productForm" role="form">
					<input type="hidden" class="productInput" value="${returnModel.body.id }" id="id" />
					<div class="form-group">
						<label for="proNum" class="col-sm-2 control-label">产品编号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proNum"
								placeholder="请输入产品编号" value="${returnModel.body.proNum}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proName" class="col-sm-2 control-label">产品名称</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proName"
								placeholder="请输入产品名称" value="${returnModel.body.proName}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proGgxh" class="col-sm-2 control-label">规格型号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proGgxh"
								placeholder="请输入规格型号" value="${returnModel.body.proGgxh}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proUnion" class="col-sm-2 control-label">计量单位</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proUnion"
								placeholder="请输入计量单位" value="${returnModel.body.proUnion}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proTotalSaleCount" class="col-sm-2 control-label">累计销售量</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proTotalSaleCount"
								placeholder="请输入累计销售量" value="${returnModel.body.proTotalSaleCount}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proCurrentStock" class="col-sm-2 control-label">当前库存</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proCurrentStock"
								placeholder="请输入当前库存" value="${returnModel.body.proCurrentStock}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proAdviceSalePrice" class="col-sm-2 control-label">建议销售价</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proAdviceSalePrice"
								placeholder="请输入建议销售价" value="${returnModel.body.proAdviceSalePrice}" />
						</div>
					</div>
					<div class="form-group">
						<label for="proManufacturer" class="col-sm-2 control-label">生产厂商</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proManufacturer"
								placeholder="请输入生产厂商" value="${returnModel.body.proManufacturer}" />
						</div>
					</div>
					<%-- <div class="form-group hidden">
						<label for="proCraeteTime" class="col-sm-2 control-label">创建时间</label>
						<div class="col-sm-10">
						
							<input type="text" class="form-control productInput" id="proCraeteTime"
								placeholder="请输入创建时间" value="<fmt:formatDate value='${returnModel.body.proCraeteTime}' pattern='yyyy-MM-dd HH:mm:ss' />" />
						</div>
					</div> --%>
					<%-- <div class="form-group">
						<label for="proUpdateTime" class="col-sm-2 control-label">更新时间</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proUpdateTime"
								placeholder="请输入更新时间" value="${returnModel.body.proUpdateTime}" />
						</div> 
					</div>--%>
					<%-- <div class="form-group hidden">
						<label for="proUpdateUser" class="col-sm-2 control-label">更新人</label>
						<div class="col-sm-10">
							<input type="text" class="form-control productInput" id="proUpdateUser"
								placeholder="请输入更新人" value="${returnModel.body.proUpdateUser}" />
						</div>
					</div> --%>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="button" class="btn btn-default productEditBtn" value="修改" />
						</div>
					</div>
			
				</form>
			
			</div>
		</c:otherwise>
	</c:choose>
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
$(function(){
	$("input.productEditBtn").click(editProduct);
});

var canEdit = true;
function editProduct() {
	if (!canEdit) return;
	var button = $(this);
	canEdit = false;
	$(button).addClass("disabled");
	var param=$("form.productForm input.productInput").map(function(){
		 return ($(this).attr("id")+'='+$(this).val());
		}).get().join("&") ;
	AjaxUtil.post("/product/update", param, function(data){
		debug(data);
		if (data.returnModel.code == 200) {			
			alert("修改成功");
		} else {
			alert(data.returnModel.msg);
		}
		$(button).removeClass("disabled");
		canEdit = true;
	}, function() {
		$(button).removeClass("disabled");
		canEdit = true;
	});
}
</script>


