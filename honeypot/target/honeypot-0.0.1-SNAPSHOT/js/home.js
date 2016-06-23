$(function() {
	$("h1").animate({
		"margin-left" : "100px"
	}, "slow");

	$(".nav li").on("click", function() {
		$(".nav li").removeClass("active");
		$(this).addClass("active");
		if (this.id == 1) {
			home();
		} else if (this.id == 2) {
			summary();
		} else if (this.id == 3) {
			content();
		}
	});
});

function getusername() {
	$.ajax({
		url : "qweqwe",
		type : 'POST',
		data : $("#formRegisterUser").serialize(),
		contentType : 'application/json',
		dataType : 'json',
		success : function(data) {
			alert(data);
			console.log(data);
		},
		error : function(data) {
			alert("error: " + data + " status: " + status );
			console.log(data);
		}
	});
}

function home() {
	var dum = '<div id="welcome" class="container"><div class="title"><h2>Welcome to Honeypot</h2></div><p>This is <strong>Undeviating</strong>, a free, fully standards-compliant CSS template designed by <a href="http://templated.co" rel="nofollow">TEMPLATED</a>. The photos in this template are from <a href="http://fotogrph.com/"> Fotogrph</a>. This free template is released under the <a href="http://templated.co/license">Creative Commons Attribution</a> license, so youre pretty much free to do whatever you want with it (even use it commercially) provided you give us credit for it. Have fun :) </p></div>';
	$("#main_section").html(dum);
}

function summary() {
	var dum = '<div id="popup" ></div><div id="basic_info_display" ></div><div id="interest_menu" ></div><div id="interest_display" ></div>';
	$("#main_section").html(dum);
	// alert($("#main_section").innerHTML);

//	$("#popup").load('getPopup');
	$("#popup").load('getBasicMenu');
	$("#interest_menu").load('getInterestMenu');
	//summary1();
}

function content() {
	//var dum = '<div id="listahantab" ></div><div id="page_search" style="display:none" ></div><div id="page_info" style="display:none" ></div><div id="page_post" style="display:none" ></div><div id="post_info" style="display:none" ></div><div id="filter_list" style="display:none" ></div><div id="comments_list" style="display:none" ></div><div id="likes_list" style="display:none" ></div><div id="comment_filter" style="display:none" ></div><div id="comment_filter2" style="display:none" ></div><div id="comment_info" style="display:none" ></div><div id="comment_reply" style="display:none" ></div><div id="word_cloud" style="display:none" ><canvas id="test" width="512" height="192" style="border:1px dashed gray;"></canvas><canvas id="cloud" width="512" height="192" style="display: none;"></canvas></div><div style="height: 10px;"></div>';
	//$("#main_section").html(dum);
//	$("#main_section").load('getContentMainSection');
//	$("#listahantab").load('getSummary');
//	$("#page_info").load('getPageInfo');
	
	$("#main_section").load('getContentMainSection', function() {
//		  alert( "Load was performed." );
			$("#listahantab").load('getSummary');
			$("#page_info").load('getPageInfo');
		});
}

function listChange(page){
	$('#buttonSummary').text(page);
	getPageInfo(page);
}

function changeMain(dum) {
	$("#main_section").html(dum);
}
var id1=0;
var id2=0;
var id3=0;
function col1Change(text, id){
	$('#col1Basic').text(text);
	id1 = id;
}
function col2Change(text, id){
	$('#col2Basic').text(text);
	id2 = id;
}
function col3Change(text, id){
	$('#col3Basic').text(text);
	id3 = id;
}

function basicInfo(){
	if(id1>0& id2>0){
		summary1();
		$("#basic_info_display").html('<div class="row"><div class="col-md-4"></div><div class="col-md-8"><div id="loadingbar"></div></div></div>');
		var bar = new ProgressBar.Circle(loadingbar, {
			  strokeWidth: 6,
			  easing: 'easeInOut',
			  duration: 10000,
			  color: '#FFEA82',
			  trailColor: '#eee',
			  trailWidth: 1,
			  svgStyle: null
			});

			bar.animate(1.0);  // Number from 0.0 to 1.0
	}
}

function summary1() {
	data = "wew";
			console.log('basic_info ajax start');
			$.ajax({
				url : "http://gpdigital.twilightparadox.com/api.php?id1="+id1+"&%20id2="+id2,
				type : 'GET',
				success : function(mesg) {
					console.log(mesg);

					var dum = '<div class="container-fluid"><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Top 10 Current Address</div><div class="panel-body"><div class="row"><div id="donut-example" style="height: 250px;"></div></div></div></div></div><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Address to Gender Relation</div><div class="panel-body"><div class="row"><div id="bar-example" style="height: 250px;"></div></div></div></div></div></div>';


					$("#basic_info_display").html(dum);
					var resp = JSON.parse(mesg);
					$
							.getScript(
									'http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js',
									function() {
										$
												.getScript(
														'http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.0/morris.min.js',
														function() {
																console.log('data patch start');
																var donut = [];
																for(var x=0;x < resp.length; x++){
																	var donut_row = {
																			label : resp[x]['col1'],
																			value : resp[x]['total']
																	};
																	donut[x] = donut_row;
																}
																console.log(donut);
																
															Morris
																	.Donut({
																		element : 'donut-example',
																		data : donut,
																		formatter: function (y, data) { return y + '%' }
																	});
																
																console.log('data bar start');
																var bar = [];
																var bar_ykey = []
																var bar_label = [];
																for(var x=0;x < resp.length; x++){
																	var bar_row = {
																			y : resp[x]['col1']	
																		};
																	for(var y=0; y< resp[x]['col2'].length; y++){	
																		console.log("value: " + resp[x]['col2'][y]['value']);
																		console.log("tag: " + resp[x]['col2'][y]['tag']);
																		bar_row['a'+y] = resp[x]['col2'][y]['value'];
																		if(x==0){
																			bar_label[y] = resp[x]['col2'][y]['tag'];
																			bar_ykey[y] = 'a'+y;
																		}
																	}
																	bar[x] = bar_row;
																}
																console.log("bar: " + bar);
																console.log("bar label: " + bar_label);
																console.log("bar ykey: " + bar_ykey);
															Morris
																	.Bar({
																		element : 'bar-example',
																		data : bar,
																		xkey : 'y',
																		ykeys : bar_ykey,
																		labels : bar_label,
																	    hideHover: "auto",
																		stacked: true
																	});

														});
									});
				}
			});
}


function interestInfo(){
	var ctr = 0;
	if(id3>0){
		var page_id = [];
		if(document.getElementById('check1').checked){
			page_id.push('10');
			ctr++;
		}
		if(document.getElementById('check2').checked){
			page_id.push('13');
			ctr++;
		}
		if(document.getElementById('check3').checked){
			page_id.push('14');
			ctr++;
		}
		if(document.getElementById('check4').checked){
			page_id.push('15');
			ctr++;
		}
		if(document.getElementById('check5').checked){
			page_id.push('16');
			ctr++;
		}
		if(document.getElementById('check6').checked){
			page_id.push('17');
			ctr++;
		}
		if(document.getElementById('check7').checked){
			page_id.push('18');
			ctr++;
		}
		if(document.getElementById('check8').checked){
			page_id.push('19');
			ctr++;
		}
		if(document.getElementById('check9').checked){
			page_id.push('20');
			ctr++;
		}
		if(page_id.length){
			
			$("#interest_display").html('<div id="loadingbar"></div>');
			var bar = new ProgressBar.Circle(loadingbar, {
				  strokeWidth: 6,
				  easing: 'easeInOut',
				  duration: 5000*ctr,
				  color: '#FFEA82',
				  trailColor: '#eee',
				  trailWidth: 1,
				  svgStyle: null
				});

				bar.animate(1.0);  // Number from 0.0 to 1.0
			
			var form_data = {
				page_id : page_id,
				info_id : id3
			};
			
			$.ajax({
				url : "http://gpdigital.twilightparadox.com/interest_api.php",
				type : 'POST',
				data : form_data,
				success : function(mesg) {
					console.log(mesg);

					var dum = '<div class="container-fluid"><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Top 10 Current Address</div><div class="panel-body"><div class="row"><div id="donut-example2" style="height: 250px;"></div></div></div></div></div><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Address to Gender Relation</div><div class="panel-body"><div class="row"><div id="bar-example2" style="height: 250px;"></div></div></div></div></div></div>';


					$("#interest_display").html(dum);
					var resp = JSON.parse(mesg);
					$
							.getScript(
									'http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js',
									function() {
										$
												.getScript(
														'http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.0/morris.min.js',
														function() {
																console.log('data patch start');
																var donut = [];
																for(var x=0;x < resp.length; x++){
																	var donut_row = {
																			label : resp[x]['page_name'],
																			value : resp[x]['page_total']
																	};
																	donut[x] = donut_row;
																}
																console.log(donut);
																
															Morris
																	.Donut({
																		element : 'donut-example2',
																		data : donut,
																		formatter: function (y, data) { return y + '%' }
																	});
																
																console.log('data bar start');
																var bar = [];
																var bar_ykey = []
																var bar_label = [];
																for(var x=0;x < resp.length; x++){
																	var bar_row = {
																			y : resp[x]['page_name']	
																		};
																	for(var y=0; y< resp[x]['col2'].length; y++){	
																		console.log("value: " + resp[x]['col2'][y]['value']);
																		console.log("tag: " + resp[x]['col2'][y]['tag']);
																		bar_row['a'+y] = resp[x]['col2'][y]['value'];
																		if(x==0){
																			bar_label[y] = resp[x]['col2'][y]['tag'];
																			bar_ykey[y] = 'a'+y;
																		}
																	}
																	bar[x] = bar_row;
																}
																console.log("bar: " + bar);
																console.log("bar label: " + bar_label);
																console.log("bar ykey: " + bar_ykey);
															Morris
																	.Bar({
																		element : 'bar-example2',
																		data : bar,
																		xkey : 'y',
																		ykeys : bar_ykey,
																		labels : bar_label,
																	    hideHover: "auto",
																		stacked: true
																	});

														});
									});
				}
			});
			
		}
	}
}


function sleep(milliseconds) {
	var start = new Date().getTime();
	for (var i = 0; i < 1e7; i++) {
		if ((new Date().getTime() - start) > milliseconds) {
			break;
		}
	}
}