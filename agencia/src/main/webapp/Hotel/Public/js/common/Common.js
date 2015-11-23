var Common = (function(){
	
	loadHeader = function(){
		$.get('../../../Views/Common/common-header.html', function(result){
			$('main').prepend(result);
		});
	};

	return {
		loadHeader: loadHeader
	}
	
})();