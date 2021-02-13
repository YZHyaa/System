var totalRecord;

//页面加载完成后，直接发送一个ajax请求，要到分页数据	
$(function() {
	//去首页
	to_page(1);
});

function to_page(pn) {
	$.ajax({
		url : APP_PATH+"/emps",
		data : "pn=" + pn,
		type : "GET",
		success : function(result) {
			console.log(result);
			//1,解析并显示员工信息
			build_emps_table(result);
			//2，解析并显示分页信息
			build_page_info(result);
			//3,解析显示分页条数据
			build_page_nav(result);
		}
	});
}

//解析显示员工信息
function build_emps_table(result) {
	//清空已有区域
	$("#emps_table tbody").empty();

	var emps = result.extend.pageInfo.list;
	$.each(emps, function(index, item) {
		var empIdTd = $("<td></td>").append(item.empId);
		var empNameTd = $("<td></td>").append(item.empName);
		var genderTd = $("<td></td>").append(
				item.gender == 'M' ? "男" : "女");
		var emailTd = $("<td></td>").append(item.email);
		var deptNameTd = $("<td></td>")
		.append(item.department.deptName);
		//按钮
		var editBtn = $("<button></button>").addClass(
		"btn btn-primary btn-sm").append(
				$("<span></span>").addClass(
				"glyphicon glyphicon-pencil")).append("编辑");
		var delBtn = $("<button></button>").addClass(
		"btn btn-danger btn-sm").append(
				$("<span></span>")
				.addClass("glyphicon glyphicon-trash")).append(
				"删除");
		var btnTd = $("<td></td>").append(editBtn).append(" ").append(
				delBtn);
		//append方法执行完后还是返回原来的元素，可以连续append
		$("<tr></tr>").append(empIdTd).append(empNameTd).append(
				genderTd).append(emailTd).append(deptNameTd).append(
						btnTd).appendTo("#emps_table tbody");
	});
}

//解析显示分页信息 page_info_area
function build_page_info(result) {
	//清空已有区域
	$("#page_info_area").empty();

	$("#page_info_area").append(
			"当前" + result.extend.pageInfo.pageNum + "页，总"
			+ result.extend.pageInfo.pages + "页，总"
			+ result.extend.pageInfo.total + "条记录"); 
	totalRecord = result.extend.pageInfo.total;
}

//解析显示分页条 page_nav_area
function build_page_nav(result) {
	//清空已有区域
	$("#page_nav_area").empty();

	//构建元素
	var ul = $("<ul></ul>").addClass("pagination");

	var firstPageLi = $("<li></li>").append(
			$("<a></a>").append("首页").attr("href", "#"));
	var prePageLi = $("<li></li>").append(
			$("<a></a>").append("&laquo;"));

	//判断有无前一页 无则不能点击
	if (result.extend.pageInfo.hasPreviousPage == false) {
		firstPageLi.addClass("disabled");
		prePageLi.addClass("disabled");
	} else {
		//为元素添加单击事件
		firstPageLi.click(function() {
			to_page(1);
		});
		prePageLi.click(function() {
			to_page(result.extend.pageInfo.pageNum - 1);
		});
	}

	var nextPageLi = $("<li></li>").append(
			$("<a></a>").append("&raquo;"));
	var lastPageLi = $("<li></li>").append(
			$("<a></a>").append("末页").attr("href", "#"));

	//判断有无后一页 无则不能点击
	if (result.extend.pageInfo.hasNextPage == false) {
		lastPageLi.addClass("disabled");
		nextPageLi.addClass("disabled");
	} else {
		//为元素添加单击事件
		nextPageLi.click(function() {
			to_page(result.extend.pageInfo.pageNum + 1);
		});
		lastPageLi.click(function() {
			to_page(result.extend.pageInfo.pages);
		});
	}

	//构造添加首页和前一页的提示
	ul.append(firstPageLi).append(prePageLi);

	//1,2..5遍历给ul中添加页码提示
	$.each(result.extend.pageInfo.navigatepageNums, function(index,
			item) {
		var numLi = $("<li></li>").append($("<a></a>").append(item));
		if (result.extend.pageInfo.pageNum == item) {
			numLi.addClass("active");
		}
		numLi.click(function() {
			to_page(item);
		});
		ul.append(numLi);
	});

	//添加下一页和末页的提示
	ul.append(nextPageLi).append(lastPageLi);

	//把ul加入nav元素
	var navEle = $("<nav></nav>").append(ul);
	navEle.appendTo("#page_nav_area");
}

//===================================模态框=======================================	
//点击新增按钮弹出模态框
$("#emp_add_modal_btn").click(function(){
	//表单重置(数据，样式)
	reset_form("#empAddModal form");
	//发送ajax请求，查出部门信息，显示在下拉列表中
	getDepts();
	//弹出模态框
	$("#empAddModal").modal({
		backdrop:"static"
	});
});

//表单重置
function reset_form(ele){
	$(ele)[0].reset();
	//清空样式
	$(ele).find("*").removeClass("has-error has-success");
	$(ele).find(".help-block").text("");
}

//查出部门信息并显示在下拉列表中
function getDepts(){
	$.ajax({
		url:APP_PATH+"/depts",
		type:"GET",
		success:function(result){
			//console.log(result);
			//显示部门信息在下拉列表中
			//$("#empAddModal select").append("")
			$.each(result.extend.depts,function(){
				var optionEle = $("<option></option>").append(this.deptName).attr("value",this.deptId);
				optionEle.appendTo("#empAddModal select");
			});
		}
	});
}

//=======================================保存按钮==========================================
//模态框填写的表单的数据 提交保存
$("#emp_save_btn").click(function(){
	//1,先对模态框的数据进行校验
	//前端校验
	if (!validate_add_form()) {
		return false;
	}
	//用户名校验
	if($(this).attr("ajax-va")=="error"){
		return false;
	}
	//2,发送Ajax请求保存员工
	$.ajax({
		url : APP_PATH+"/emp",
		type : "POST",
		data : $("#empAddModal form").serialize(),
		success : function(result) {
			//alert(result.msg);
			//员工保存成功后:
			// 1,关闭模态框
			$("#empAddModal").modal("hide");

			// 2，来到最后一页
			// 发送Ajax请求显示最后一页数据
			to_page(totalRecord);
		}
	});
});

//前端校验
function validate_add_form() {
	//使用jq的正则表达式校验 （用户名）
	var empName = $("#empName_add_input").val();
	var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
	if (!regName.test(empName)) {
		//alert("用户名可以是2-5位中文或者5-16位英文的组合");
		show_validate_msg("#empName_add_input","error","用户名必须是是2-5位中文或者6-16位英文和数字的组合");
		return false;
	}else{
		show_validate_msg("#empName_add_input","success","");
	}

	//校验邮箱信息
	var email = $("#email_add_input").val();
	var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	if (!regEmail.test(email)) {
		//alert("邮箱格式不正确");
		show_validate_msg("#email_add_input","error","邮箱格式不正确");
		return false;
	}else{
		show_validate_msg("#email_add_input","success","");
	}

	return true;
}

//显示校验结果
function show_validate_msg(ele,status,msg){
	//清除当前校验状态
	$(ele).parent().removeClass("has-success has-error");
	$(ele).next("span").text("");

	if(status=="success"){
		$(ele).parent().addClass("has-success");
		$(ele).next("span").text(msg);
	}else if(status=="error"){
		$(ele).parent().addClass("has-error");
		$(ele).next("span").text(msg);
	}
}

//后台校验
$("#empName_add_input").change(function(){
	//发送Ajax请求校验用户名是否可用
	var empName = this.value;
	$.ajax({
		url:APP_PATH+"/checkuser",
		data:"empName="+empName,
		type:"POST",
		success:function(result){
			if(result.code==100){
				show_validate_msg("#empName_add_input","success","用户名可用");
				$("#emp_save_btn").attr("ajax-va","success");
			}else{
				show_validate_msg("#empName_add_input","error",result.extend.va_msg);
				$("#emp_save_btn").attr("ajax-va","error");
			}
		}
	});
});
