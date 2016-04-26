function wishClick(code){
	
	$.ajax({
		async : true,
		type : "GET",
		url : '/merchandisestorefront/addToWishlist',
		data : "code=" + code,

		success : function(data) {
		if(data){
			
			location.reload();
		}
		}
	});
	
	
}	
