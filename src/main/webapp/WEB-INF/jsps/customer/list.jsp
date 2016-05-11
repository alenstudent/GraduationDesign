
<%@page pageEncoding="utf-8"%>

<%
	String title = "客户列表";
%>
<%@include file="../includeHeader.jsp"%>
<style>
.tool_div {
	padding-top: 20px;
}
.navBar {
	padding-top: 20px;
}
</style>
<body>

	<div class="container">
		<div align="center" class="navBar">
			<ul class="nav nav-pills">
				<li role="presentation" class="active"><a href="${context }/customer/list/page">我的客户列表</a></li>
				<li role="presentation"><a href="${context }/customer/list/product/page">产品列表</a></li>
			</ul>
		</div>
		<div style="clear: both;"></div>
		<div class="tool_div">
			<div style="float: left;">
				<input class="btn btn-warning" type="button" value="编辑"
					onclick="edit()" /> <input class="btn btn-info" type="button"
					value="详情" onclick="info()" /> <input class="btn btn-danger"
					type="button" value="删除" onclick="del()" />
			</div>
			<div style="float: right;">
				<a href="${context }/customer/add/page"
					class="btn btn-default addCustomer"><span
					class="glyphicon glyphicon-plus"></span></a>
					<a href="${context }/user/logout" class="btn btn-default">注销</a>
			</div>
			<div style="clear: both;"></div>
		</div>

		<table class="table table-hover customerTable">
			<thead>
				<tr>
					<th>#</th>
					<th>客户名称</th>
					<th>联系地址</th>
					<th>邮编</th>
					<th>联系电话</th>
					<!-- <th>联系人员</th> -->
					<th>纳税号码</th>
					<th>开户银行账号</th>
					<th>开户银行名称</th>
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
		AjaxUtil.post("/customer/list", {
			"currentPage" : currentPage,
			"pageSize" : pageSize
		}, function(data) {
			debug(data);
			$("table.customerTable tbody tr").remove()
			var models = data.returnModel.body;
			for (var i = 0; i < models.length; i++) {
				var model = models[i];
				var tr = "<tr id='" + model.id + "'>";
				tr += "<td><input type=\"checkbox\"></td>";
				tr += "<td>" + model.cusName + "</td>";
				tr += "<td>" + model.cusAddress + "</td>";
				tr += "<td>" + model.cusZipCode + "</td>";
				tr += "<td>" + model.cusPhone + "</td>";
				/* tr += "<td>" + model.cusBelongTo + "</td>"; */
				tr += "<td>" + model.cusTaxNum + "</td>";
				tr += "<td>" + model.cusBankAccount + "</td>";
				tr += "<td>" + model.cusBankName + "</td>";
				tr += "</tr>";
				$("table.customerTable tbody").append(tr);
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
			open("customer/edit/page", {
				"id" : ids[0]
			});
		}
	}
	function info() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要查看的记录");
		} else if (ids.length > 1) {
			alert("只能选择一条记录进行查看");
		} else {
			open("customer/info/page", {
				"id" : ids[0]
			});
		}
	}
	function del() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要删除的记录");
			return;
		}
		confirm("确定删除吗", function() {
			AjaxUtil.post("/customer/del", {
				"ids" : ids.join(",")
			}, function(data) {
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
		$("table.customerTable tbody tr").each(function() {
			if ($(this).find("td:eq(0) input").is(":checked")) {
				ids.push($(this).attr("id"));
			}
		});
		return ids;
	}
</script>


