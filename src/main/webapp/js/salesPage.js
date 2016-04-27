
var pageModel = {"pageSize": 10, "currentPage": 1};

$(function(){
	$(".pagination").on("click", "li", pageNumClicked);
//	$(".customerTable").on("click", "tbody tr", rowClicked);
	listMyCustomers();
});


function listMyCustomers() {
	AjaxUtil.get("/customer/list/" + pageModel.currentPage + "/" + pageModel.pageSize, {}, function(data) {
		debug(data);
		$(".customerTable tbody tr").remove()
		var models = data.returnModel.body;
		for (var i = 0; i < models.length; i++) {
			var model = models[i];
			var tr = "<tr id='" + model.id + "'>";
					tr += "<td><input type=\"checkbox\"></td>";
					tr += "<td>" + model.cusName + "</td>";	
					tr += "<td>" + model.cusAddress + "</td>";
					tr += "<td>" + model.cusZipCode + "</td>";
					tr += "<td>" + model.cusPhone + "</td>";
					tr += "<td>" + model.cusTaxNum + "</td>";
					tr += "<td>" + model.cusBankAccount + "</td>";	
					tr += "<td>" + model.cusBankName + "</td>";
			tr += "</tr>";
			$("table.customerTable tbody").append(tr);
		}
		
		$(".pagination li").remove();
		var pageCount = data.returnModel.pageCount;
		var currentPage = data.returnModel.currentPage;
		var li = "";
		if (currentPage == 1) {			
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
		if (currentPage == pageCount) {			
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
	listMyCustomers();
}


function rowClicked() {
	var productId = $(this).attr("id");
	window.location.href = context + "/product/update/" + productId;
}





