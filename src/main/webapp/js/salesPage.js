$(function(){
	AjaxUtil.get("/customer/list/1/10", {}, function(data) {
		debug(data);
		$(".customerTable tbody tr").remove()
		var models = data.returnModel.body;
		for (var i = 0; i < models.length; i++) {
			var model = models[i];
			var tr = "<tr id='" + model.id + "'>";
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
	}, function() {
		
	});
});