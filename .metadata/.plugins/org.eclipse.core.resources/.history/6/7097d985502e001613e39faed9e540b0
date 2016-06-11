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
	var dum = '<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 45%"><span class="sr-only">45% Complete</span></div></div>';
	$("#main_section").html(dum);
	// alert($("#main_section").innerHTML);
	summary1();
}

function content() {
	var dum = 'COMMENTS<br><div id="page_search" style="display:block" >Page Tag: <input type="text" id="page_name"><br><button onclick="getPageInfo()" >Search Page</button></div><div id="page_info" style="display:none" ></div><div id="page_post" style="display:none" ></div><div id="post_info" style="display:none" ></div><div id="filter_list" style="display:none" ></div><div id="comments_list" style="display:none" ></div><div id="likes_list" style="display:none" ></div><div id="comment_filter" style="display:none" ></div><div id="comment_info" style="display:none" ></div><div id="comment_reply" style="display:none" ></div>';
	$("#main_section").html(dum);
}

function changeMain(dum) {
	$("#main_section").html(dum);
}

function summary1() {
	data = "wew";
	$
			.ajax({
				url : "http://gpdigital.crabdance.com/addr_gender.php",
				type : 'GET',
				success : function(mesg) {

					var dum = '<div class="progress"><div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="45" aria-valuemin="0" aria-valuemax="100" style="width: 100%"><span class="sr-only">100% Complete</span></div></div>';
					$("#main_section").html(dum);

					dum = '<div class="container-fluid"><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Top 10 Current Address</div><div class="panel-body"><div class="row"><div id="donut-example" style="height: 250px;"></div></div></div></div></div><div class="col-md-6"><div class="panel panel-default"><div class="panel-heading">Address to Gender Relation</div><div class="panel-body"><div class="row"><div id="bar-example" style="height: 250px;"></div></div></div></div></div></div>';

					// <div class="panel panel-default"><div
					// class="panel-heading">Panel heading without
					// title</div><div class="panel-body"><div class="row"><div
					// class="col-md-6"><div id="donut-example" style="height:
					// 250px;"></div></div></div></div></div>
					// setTimeout(changeMain(dum),5000);

					$("#main_section").html(dum);
					var resp = JSON.parse(mesg);
					// alert(resp[0][0]);
					// document.getElementById('container').innerHTML =
					// JSON.stringify(mesg);
					$
							.getScript(
									'http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js',
									function() {
										$
												.getScript(
														'http://cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.0/morris.min.js',
														function() {

															Morris
																	.Donut({
																		element : 'donut-example',
																		data : [
																				{
																					label : resp[0][0],
																					value : resp[0][1]
																				},
																				{
																					label : resp[1][0],
																					value : resp[1][1]
																				},
																				{
																					label : resp[2][0],
																					value : resp[2][1]
																				},
																				{
																					label : resp[3][0],
																					value : resp[3][1]
																				},
																				{
																					label : resp[4][0],
																					value : resp[4][1]
																				},
																				{
																					label : resp[5][0],
																					value : resp[5][1]
																				},
																				{
																					label : resp[6][0],
																					value : resp[6][1]
																				},
																				{
																					label : resp[7][0],
																					value : resp[7][1]
																				},
																				{
																					label : resp[8][0],
																					value : resp[8][1]
																				},
																				{
																					label : resp[9][0],
																					value : resp[9][1]
																				} ]
																	});

															Morris
																	.Bar({
																		element : 'bar-example',
																		data : [
																				{
																					y : resp[0][0],
																					a : resp[0][3],
																					b : resp[0][4]
																				},
																				{
																					y : resp[1][0],
																					a : resp[1][3],
																					b : resp[1][4]
																				},
																				{
																					y : resp[2][0],
																					a : resp[2][3],
																					b : resp[2][4]
																				},
																				{
																					y : resp[3][0],
																					a : resp[3][3],
																					b : resp[3][4]
																				},
																				{
																					y : resp[4][0],
																					a : resp[4][3],
																					b : resp[4][4]
																				},
																				{
																					y : resp[5][0],
																					a : resp[5][3],
																					b : resp[5][4]
																				},
																				{
																					y : resp[6][0],
																					a : resp[6][3],
																					b : resp[6][4]
																				},
																				{
																					y : resp[7][0],
																					a : resp[7][3],
																					b : resp[7][4]
																				},
																				{
																					y : resp[8][0],
																					a : resp[8][3],
																					b : resp[8][4]
																				},
																				{
																					y : resp[9][0],
																					a : resp[9][3],
																					b : resp[9][4]
																				} ],
																		xkey : 'y',
																		ykeys : [
																				'a',
																				'b' ],
																		labels : [
																				'Male',
																				'Female' ]
																	});

														});
									});
				}
			});
}

function sleep(milliseconds) {
	var start = new Date().getTime();
	for (var i = 0; i < 1e7; i++) {
		if ((new Date().getTime() - start) > milliseconds) {
			break;
		}
	}
}