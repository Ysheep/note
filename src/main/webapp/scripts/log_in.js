
var SUCCESS = 0;
var ERROR = 1;
var USER_ID = "loginId";


$(function() {
	console.log("hello log_in.js");
	$("#login").click(checkLogin);
	$("#count").on("blur",checkName).on("focus",function() {
		$("#count_msg").empty();
	}).focus();
	$("#password").on("blur",checkPassword).on("focus",function() {
		$("#password_msg").empty();
	});
});

function checkName() {
	var name = $("#count").val();
	var reg = /^\w{3,10}$/;
	if(name=="") {
		$("#count_msg").empty().append("用户名不能为空");
		return false;
	}
	if(!reg.test(name)) {
		$("#count_msg").empty().append("请输入3-10个字符");
		return false;
	}
	return true;
}

function checkPassword() {
	var password = $("#password").val();
	var reg = /^\w{3,10}$/;
	if(password=="") {
		$("#password_msg").empty().append("密码不能为空");
		return false;
	}
	if(!reg.test(password)) {
		$("#password_msg").empty().append("请输入3-10个字符");
		return false;
	}
	return true;
}

function checkLogin() {
	console.log("checkLogin");
	var name = $("#count").val();
	var password = $("#password").val();
//	console.log(name+","+password);
	var namePass = checkName();
	var passwordPass = checkPassword();
	if(!namePass || ! passwordPass) {
		return false;
	}
	$.ajax({
		url:'account/login.do',
		data:{"name":name,"password":password},
		type:"post",
		dataType:"JSON",
		success:function(result){
			if(result.state == SUCCESS) {
				console.log(result.data);
				console.log("登录成功");
			
				var user = result.data;
				SetCookie(USER_ID, user.id);
				window.location.href="edit.html";
				return;
			}
			var field = result.state;
			console.log(field);
			if(field == 1) {
				//显示用户名错误
				$('#count_msg').empty().append(result.msg);
				return ;
			}
			if(field == 2) {
				$('#count_msg').empty().append(result.msg);
				return ;
			}
		}
	});
}