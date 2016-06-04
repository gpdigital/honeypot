function registerPage() {
	// $.ajax({
	// url : "registerPage",
	// type : 'POST',
	// data : $("#formRegister").serialize(),
	// success : function(data) {
	// alert(data);
	// },
	// error : function(data) {
	// alert("error: " + data + " status: " + status + " er:" + er);
	// }
	// });
	window.location = "registerPage";
}
function registerUser() {
	if ($("#newBrand").val().trim() == "") {
		$("#errorBrandName").html("Must Provide Brand Name");
	} else {
		$("#errorBrandName").html("");
		$("#newBrand").val($("#newBrand").val().trim());
	}
	if ($("#newUsername").val().trim() == "") {
		$("#errorUsername").html("Must Provide FB Page Name");
	} else {
		$("#errorUsername").html("");
		$("#newUsername").val($("#newUsername").val().trim());
	}
	if ($("#newPassword").val().trim() == "") {
		$("#errorPassword").html("Must Provide FB Page Name");
	} else {
		$("#errorPassword").html("");
		$("#newPassword").val($("#newPassword").val().trim());
	}
	var brand = $("#newBrand").val().trim();
	var username = $("#newUsername").val().trim();
	var password = $("#newPassword").val().trim();

	if ((brand != "") && (username != "") && (password != "")) {
		$("#addUserBrand").val(brand);
		$("#addUserUsername").val(username);
		$("#addUserPassword").val(password);
		$.ajax({
			url : "addUser",
			type : 'POST',
			data : $("#formRegisterUser").serialize(),
			success : function(data) {
				if (data == "success") {
					alert("Registered Successfully!");
					window.location = "index";
				}
			},
			error : function(data) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
		//		$("#tableFBPages").load("addFBPage");
	}
}
function addFBPage() {
	if ($("#newBrand").val().trim() == "") {
		$("#errorBrandName").html("Must Provide Brand Name");
	} else {
		$("#errorBrandName").html("");
		$("#newBrand").val($("#newBrand").val().trim());
	}
	if ($("#newFBPage").val().trim() == "") {
		$("#errorFBPage").html("Must Provide FB Page Name");
	} else {
		$("#errorFBPage").html("");
		$("#newFBPage").val($("#newFBPage").val().trim());
	}
	var brand = $("#newBrand").val().trim();
	var fbName = $("#newFBPage").val().trim();

	if ((brand != "") && (fbName != "")) {
		$("#addFbPageBrand").val(brand);
		$("#addFbPageName").val(fbName);
		$.ajax({
			url : "addFBPage",
			type : 'POST',
			data : $("#formAddFBPage").serialize(),
			success : function(data) {
				url = "updateFBPages/"+brand;
				$("#tableFBPages").load(url);
			},
			error : function(data) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
		//		$("#tableFBPages").load("addFBPage");
	}

}