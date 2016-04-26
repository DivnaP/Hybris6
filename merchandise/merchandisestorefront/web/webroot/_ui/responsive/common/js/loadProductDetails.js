
$( document ).ready(function() {
var myValue = $( "#hiddenID" ).val(); 
	
	
	
	$.ajax({
		async : true,
		type : "GET",
		url : '/merchandisestorefront/isProductInWishlist',
		data : "code=" + myValue,

		success : function(data) {
			
			if(data){
				
				$('#wishlistRemoveBtn').prop('disabled', false);
				$('#wishlistRemoveBtn').prop('style', '');
				$('#wishlistBtn').prop('disabled', true);
				$('#wishlistBtn').prop('style', 'background-color:grey');
			}
			else{
				
				
				$('#wishlistRemoveBtn').prop('disabled', true);
				$('#wishlistRemoveBtn').prop('style', 'background-color:grey');
				$('#wishlistBtn').prop('disabled', false);
			}

		}
	});
});