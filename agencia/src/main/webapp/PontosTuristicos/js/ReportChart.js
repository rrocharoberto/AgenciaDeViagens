$(document).ready(function(){
	
	var dateInicio = $("#dataInicio").val();
	var dateFim = $("#dataFim").val();
	
	var data =  $("#reportData").val();
	var dataJson = JSON.parse(data)
	
	var dataChart = new Array(dataJson.length);
	for(var i=0;i<dataJson.length;i++){
		dataChart[i] = [dataJson[i].pontoTuristico,dataJson[i].totalVisitas];
	}
	
    $('#container').highcharts({
    	
        chart: {
            type: 'column'
        },
        title: {
            text: 'Pontos Turísticos mais visitados entre ' + dateInicio + ' e ' + dateFim
        },
        xAxis: {
            type: 'category',
            labels: {
                rotation: -45,
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Número de pessoas'
            }
        },
        legend: {
            enabled: false
        },
        series: [{
            name: 'nº de pessoas',
            data: dataChart,
            dataLabels: {
                enabled: true,
                rotation: -90,
                color: '#FFFFFF',
                align: 'right',
                format: '{point.y:.1f}', // one decimal
                y: 10, // 10 pixels down from the top
                style: {
                    fontSize: '13px',
                    fontFamily: 'Verdana, sans-serif'
                }
            }
        }]
    });
});