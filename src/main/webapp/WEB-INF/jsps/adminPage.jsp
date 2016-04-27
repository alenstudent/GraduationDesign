<%@page pageEncoding="utf-8"%>

<%
	String title = "产品列表";
%>
<%@include file="includeHeader.jsp"%>
<body>

	<div class="container">
		<div align="center">
			<h1>产品列表</h1>
		</div>
		<div align="center">
			<a href="${context }/product/add/page" class="btn btn-default addProduct">添加产品</a>
		</div>

		<table class="table table-hover productTable">
			<thead>
				<tr>
					<th>产品编号</th>
					<th>名称</th>
					<th>规格型号</th>
					<th>计量单位</th>
					<th>累计销售量</th>
					<th>当前库存量</th>
					<th>建议销售价</th>
					<th>生产厂商</th>
				</tr>
			</thead>
			<tbody>


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
<%@include file="includeJS.jsp"%>
<script src="${context}/js/adminPage.js" type="text/javascript"></script>


