
	
function applyVoucher(){
	
	var code = $("#voucherInput").val();
	
	$.ajax({
		async : true,
		type : "GET",
		url : ACC.config.encodedContextPath+'/checkout/multi/summary/addVoucher',
		data : "code=" + code,

		success : function(data) {
			if(data){
				
				
				$("#voucherResult").text(data);
				location.reload();
				}
		}
	});
	
	
}	
