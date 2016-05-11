
<%@page pageEncoding="utf-8"%>

<%
	String title = "产品列表";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>产品列表</h1>
			<a href="${context }/user/logout" class="btn btn-primary col-md-2 col-md-offset-5" >注销</a>
		</div>
		<div style="clear: both;"></div>
		<div class="tool_div">
			<div style="float: left;">
				<input class="btn btn-warning" type="button" value="编辑" onclick="edit()" />
				<input class="btn btn-info" type="button" value="详情" onclick="info()" />
				<input class="btn btn-danger" type="button" value="删除" onclick="del()" />
			</div>
			<div style="float: right;">
				<a href="${context }/product/add/page" class="btn btn-default addCustomer"><span class="glyphicon glyphicon-plus"></span></a>
			</div>
			<div style="clear: both;"></div>
		</div>

		<table class="table table-hover productTable">
			<thead>
				<tr>
					<th>#</th>
					<th>产品编号</th>
					<th>产品名称</th>
					<th>规格型号</th>
					<th>计量单位</th>
					<th>累计销售量</th>
					<th>当前库存</th>
					<th>建议销售价</th>
					<th>生产厂商</th>
					<!-- <th>创建时间</th>
					<th>更新时间</th>
					<th>更新人</th> -->
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	<div align="center">
		<ul class="pagination">
		</ul>
	</div>
	
	
</body>
<%@include file="../includeJS.jsp"%>
<script type="text/javascript">
	var currentPage = 1;
	var pageCount = 0;
	var pageSize = 10;
	$(function() {
		list();
	});

	function list() {
		AjaxUtil.post("/product/list", {"currentPage": currentPage, "pageSize": pageSize}, function(data) {
			debug(data);
			$("table.productTable tbody tr").remove()
			var models = data.returnModel.body;
			for (var i = 0; i < models.length; i++) {
				var model = models[i];
				var tr = "<tr id='" + model.id + "'>";
						tr += "<td><input type=\"checkbox\"></td>";
						tr += "<td>" + model.proNum + "</td>";
						tr += "<td>" + model.proName + "</td>";
						tr += "<td>" + model.proGgxh + "</td>";
						tr += "<td>" + model.proUnion + "</td>";
						tr += "<td>" + model.proTotalSaleCount + "</td>";
						tr += "<td>" + model.proCurrentStock + "</td>";
						tr += "<td>" + model.proAdviceSalePrice + "</td>";
						tr += "<td>" + model.proManufacturer + "</td>";
						/* tr += "<td>" + model.proCraeteTime + "</td>";
						tr += "<td>" + model.proUpdateTime + "</td>";
						tr += "<td>" + model.proUpdateUser + "</td>"; */
				tr += "</tr>";
				$("table.productTable tbody").append(tr);
			}
			
			$(".pagination li").remove();
			pageCount = data.returnModel.pageCount;
			currentPage = data.returnModel.currentPage;
			initPaginationBar();
		});
	}
	
	function pageChanged(currentPage_) {
		currentPage = currentPage_
		list();
	}
	function edit() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要编辑的记录");
		} else if (ids.length > 1) {
			alert("只能选择一条记录进行编辑");
		} else {
			open("product/edit/page", {"id": ids[0]});
		}
	}
	function info() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要查看的记录");
		} else if (ids.length > 1) {
			alert("只能选择一条记录进行查看");
		} else {
			open("product/info/page", {"id": ids[0]});
		}
	}
	function del() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要删除的记录");
			return;
		}
		confirm("确定删除吗", function() {
			AjaxUtil.post("/product/del", {"ids": ids.join(",")}, function(data){
				if (data.returnModel.code == 200) {
					list();
				} else {
					alert(data.returnModel.msg);
				}
			});
		});
	}
	function getSelectedRows() {
		var ids = [];
		$("table.productTable tbody tr").each(function() {
			if ($(this).find("td:eq(0) input").is(":checked")) {
				ids.push($(this).attr("id"));	
			}
		});
		return ids;
	}
</script>


