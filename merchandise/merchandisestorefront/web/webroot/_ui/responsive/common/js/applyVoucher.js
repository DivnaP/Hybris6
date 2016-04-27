
	
function applyVoucher(){
	
	var code = $("#voucherInput").val();
	
	$.ajax({
		async : true,
		type : "GET",
		url : '/merchandisestorefront/electronics/en/checkout/multi/summary/addVoucher',
		data : "code=" + code,

		success : function(data) {
			if(data){
				
				
				$("#voucherResult").text(data);
				location.reload();
				}
		}
	});
	
	
}	
