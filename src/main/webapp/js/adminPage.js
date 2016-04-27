
var pageModel = {"pageSize": 10, "currentPage": 1};

$(function(){
	$(".pagination").on("click", "li", pageNumClicked);
	listProducts();
});


function listProducts() {
	AjaxUtil.get("/product/list/" + pageModel.currentPage + "/" + pageModel.pageSize, {}, function(data) {
		debug(data);
		$(".productTable tbody tr").remove()
		var models = data.returnModel.body;
		for (var i = 0; i < models.length; i++) {
			var model = models[i];
			var tr = "<tr id='" + model.id + "'>";
					tr += "<td>" + model.proNum + "</td>";	
					tr += "<td>" + model.proName + "</td>";
					tr += "<td>" + model.proGgxh + "</td>";
					tr += "<td>" + model.proUnion + "</td>";
					tr += "<td>" + model.proTotalSaleCount + "</td>";
					tr += "<td>" + model.proCurrentStock + "</td>";	
					tr += "<td>" + model.proAdviceSalePrice + "</td>";
					tr += "<td>" + model.proManufacturer + "</td>";
			tr += "</tr>";
			$("table.productTable tbody").append(tr);
		}
		
		$(".pagination li").remove();
		var pageCount = data.returnModel.pageCount;
		var pageSize = data.returnModel.pageSize;
		var currentPage = data.returnModel.currentPage;
		var li = "";
		if (currentPage <= 1) {			
			li += "<li name='<' class='disabled'><a href='javascript:void(0);'>&laquo;</a></li>";
		}
		if (currentPage * 5 < pageCount) {
			for (var i = currentPage - 2; i <= currentPage + 2; i++) {
				if (i == currentPage) {
					li += "<li name='" + i + "' class='active'><a href='javascript:void(0);'>" + i + "</a></li>";
				} else {					
					li += "<li name='" + i + "'><a href='javascript:void(0);'>" + i + "</a></li>";
				}
			}
		} else {
			for (var i = pageCount - 5; i <= pageCount; i++) {
				if (i <= 0) {
					continue;
				}
				if (i == currentPage) {
					li += "<li name='" + i + "' class='active'><a href='javascript:void(0);'>" + i + "</a></li>";
				} else {					
					li += "<li name='" + i + "'><a href='javascript:void(0);'>" + i + "</a></li>";
				}
			}
		}
		if (currentPage >= pageCount) {			
			li += "<li name='>' class='disabled'><a href='javascript:void(0);'>&raquo;</a></li>";
		} else {
			li += "<li name='>'><a href='javascript:void(0);'>&raquo;</a></li>";
		}
		$(".pagination").append(li);
	}, function() {
		alert("网络繁忙，请稍候重试");
	});
}


function pageNumClicked() {
	var pageName = $(this).attr("name");
	if (pageName == "<") {
		pageModel.currentPage = pageModel.currentPage - 1; 
	} else if (pageName == ">") {
		pageModel.currentPage = pageModel.currentPage + 1;
	} else {
		pageModel.currentPage = parseInt(pageName);
	}
	listProducts();
}