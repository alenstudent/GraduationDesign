
<%@page pageEncoding="utf-8"%>

<%
	String title = "";
%>
<%@include file="../includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>标题</h1>
		</div>
		<div class="tool_div">
			<div style="float: left;">
				<input class="btn btn-warning" type="button" value="编辑" onclick="edit()" />
				<input class="btn btn-info" type="button" value="详情" onclick="info()" />
				<input class="btn btn-danger" type="button" value="删除" onclick="del()" />
			</div>
			<div style="float: right;">
				<a href="${context }/myDemo/add/page" class="btn btn-default addCustomer"><span class="glyphicon glyphicon-plus"></span></a>
			</div>
			<div style="clear: both;"></div>
		</div>

		<table class="table table-hover myDemoTable">
			<thead>
				<tr>
					<th>#</th>
					<th>姓名</th>
					<th>年龄</th>
					<th>薪水</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${returnModel.body }" var="item">
					<tr id="${item.id }">
						<td><input type="checkbox"></td>
						<td>${item.name}</td>
						<td>${item.age}</td>
						<td>${item.salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div align="center">
		<ul class="pagination">
			<!-- <li><a href="#">&laquo;</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li> -->
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
		AjaxUtil.post("/myDemo/list", {"currentPage": currentPage, "pageSize": pageSize}, function(data) {
			debug(data);
			$("table.myDemoTable tbody tr").remove()
			var models = data.returnModel.body;
			for (var i = 0; i < models.length; i++) {
				var model = models[i];
				var tr = "<tr id='" + model.id + "'>";
						tr += "<td><input type=\"checkbox\"></td>";
						tr += "<td>" + model.name + "</td>";
						tr += "<td>" + model.age + "</td>";
						tr += "<td>" + model.salary + "</td>";
				tr += "</tr>";
				$("table.myDemoTable tbody").append(tr);
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
			open("myDemo/edit/page", {"id": ids[0]});
		}
	}
	function info() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要查看的记录");
		} else if (ids.length > 1) {
			alert("只能选择一条记录进行查看");
		} else {
			open("myDemo/info/page", {"id": ids[0]});
		}
	}
	function del() {
		var ids = getSelectedRows();
		if (ids.length <= 0) {
			alert("请选择需要删除的记录");
			return;
		}
		confirm("确定删除吗", function() {
			AjaxUtil.post("/myDemo/del", {"ids": ids.join(",")}, function(data){
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
		$("table.myDemoTable tbody tr").each(function() {
			if ($(this).find("td:eq(0) input").is(":checked")) {
				ids.push($(this).attr("id"));	
			}
		});
		return ids;
	}
</script>


