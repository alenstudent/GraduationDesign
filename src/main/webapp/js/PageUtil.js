
function initPaginationBar() {
	$(".pagination li").remove();
	var li = "";
	if (currentPage <= 1) {			
		li += "<li name='<' class='disabled'><a href='javascript:void(0);'>&laquo;</a></li>";
	} else {
		li += "<li name='<' class='disabled'><a href='javascript:pageChanged(" + (currentPage - 1) + ");'>&laquo;</a></li>";
	}
	if (currentPage * 5 < pageCount) {
		for (var i = currentPage - 2; i <= currentPage + 2; i++) {
			if (i == currentPage) {
				li += "<li name='" + i + "' class='active'><a href='javascript:void(0);'>" + i + "</a></li>";
			} else {					
				li += "<li name='" + i + "'><a href='javascript:pageChanged("+i+");'>" + i + "</a></li>";
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
				li += "<li name='" + i + "'><a href='javascript:pageChanged("+i+");'>" + i + "</a></li>";
			}
		}
	}
	if (currentPage >= pageCount) {			
		li += "<li name='>' class='disabled'><a href='javascript:void(0);'>&raquo;</a></li>";
	} else {
		li += "<li name='>'><a href='javascript:pageChanged(" + (currentPage + 1) + ");'>&raquo;</a></li>";
	}
	$(".pagination").append(li);
}