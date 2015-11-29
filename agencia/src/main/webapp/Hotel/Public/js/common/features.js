var Features = (function(){
	
	  refreshTable = function(){
		    $.getJSON("http://localhost:8080/agencia/api/hotel/root/getAll", null, function( json )
		    {
		      var table = $("#hotelGrid").dataTable();
		      var oSettings = table.fnSettings();
		       
		      table.fnClearTable(this);
		   
		      for (var i=0; i<json.data.length; i++)
		      {
		        table.oApi._fnAddData(oSettings, json.data[i]);
		      }
		   
		      oSettings.aiDisplay = oSettings.aiDisplayMaster.slice();
		      table.fnDraw();
		    });  
		  };
	
	return {
		refreshTable: refreshTable
	}
	
})();