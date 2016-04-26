
	
function wishRemoveClick(code){
	
	
	$.ajax({
		async : true,
		type : "GET",
		url : '/merchandisestorefront/removeFromWishlist',
		data : "code=" + code,

		success : function(data) {
			if(data){
				
			location.reload();
				}
		}
	});
	
	
}	
