function summaryChange(index){
	var firstElement = ['Male','Motolite','FHM','FHM'];
	var secondElement = ['Female','Male','Male','Motolite'];
//	var firstPercentage = ['30','51','21','21'];
//	var secondPercentage = ['60','30','30','51'];
//	$('#summaryBody').html("<div class='row' style='padding-top: 100px;'>"
//			+"	<div class='col-lg-3'>"
//			+"		<div>"+firstElement[index]+"</div>"
//			+"	</div>"
//			+"	<div class='col-lg-9 progress'"
//			+"		style='padding-right: 0px; padding-left: 0px;'>"
//			+"		<div class='progress-bar progress-bar-success' role='progressbar'"
//			+"			aria-valuenow='"+firstPercentage[index]+"' aria-valuemin='0' aria-valuemax='100'"
//			+"			style='width: "+firstPercentage[index]+"%;'>"
//			+"			<span class='sr-only'>40% Complete (success)</span>"
//			+"		</div>"
//			+"	</div>"
//			+"</div>"
//			+"<div class='row' style='padding-top: 10px;'>"
//			+"	<div class='col-lg-3'>"
//			+"		<div>"+secondElement[index]+"</div>"
//			+"	</div>"
//			+"	<div class='col-lg-9 progress'"
//			+"		style='padding-right: 0px; padding-left: 0px;'>"
//			+"		<div class='progress-bar progress-bar-danger' role='progressbar'"
//			+"			aria-valuenow='"+secondPercentage[index]+"' aria-valuemin='0' aria-valuemax='100'"
//			+"			style='width: "+secondPercentage[index]+"%;'>"
//			+"			<span class='sr-only'>40% Complete (success)</span>"
//			+"		</div>"
//			+"	</div>"
//			+"</div>");
	//$('#buttonSummary').text(firstElement[index]+" vs "+secondElement[index]);
	
	//alert(url);
	
	
	
}

function sum(){
	url = "getSummary";
	alert(url);
	$("#listahantab").load(getSummary);
}

function sum2(){
	url = "getSummary";
	$("#listahantab").load(url);
}