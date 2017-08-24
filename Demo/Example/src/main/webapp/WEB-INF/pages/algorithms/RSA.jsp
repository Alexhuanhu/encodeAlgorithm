<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Algorithm Code Test</title>

<link
	href="${pageContext.request.contextPath}/styles/kendoUI/examples-offline.css"
	rel="stylesheet">
	
<link 
	href="${pageContext.request.contextPath}/styles/kendoUI/kendo.common.min.css"
	rel="stylesheet">
	
<link
	href="${pageContext.request.contextPath}/styles/kendoUI/kendo.dataviz.default.min.css"
	rel="stylesheet">
	
<link 
	href="${pageContext.request.contextPath}/styles/kendoUI/kendo.dataviz.min.css"
	rel="stylesheet">
	
<link 
	href="${pageContext.request.contextPath}/styles/kendoUI/kendo.default.min.css"
	rel="stylesheet">
	
<link 
	href="${pageContext.request.contextPath}/styles/kendoUI/kendo.default.mobile.min.css"
	rel="stylesheet">
	
<link
	href="${pageContext.request.contextPath}/Common/kendoUI/styles/kendo.bootstrap.min.css"
	rel="stylesheet">
	
<link
	href="${pageContext.request.contextPath}/Common/kendoUI/styles/kendo.common.min.css"
	rel="stylesheet">

<script
	src="${pageContext.request.contextPath}/Common/kendoUI/js/jquery.min.js"></script>

<script 
	src="${pageContext.request.contextPath}/scripts/jquery-2.1.3.js"></script>

<script 
	src="${pageContext.request.contextPath}/scripts/kendoUI/kendo.all.min.js"></script>

<script
	src="${pageContext.request.contextPath}/Common/bootstrap/js/bootstrap.min.js"></script>


	
<script>
	$(document).ready(function() {
		
		// 初始化表格
		initGrid();
		
		// SHA-1 加密
		$("#submit").click(function(){
			var inputString = $("#inputString").val();
			document.getElementById("outputString").value = "";
			document.getElementById("outputStringLength").value = "";
			
			if (null == inputString || inputString == "") {
				alert("请输入需要加密的明文");
			}
			else {
				$.ajax({
					url: "${pageContext.request.contextPath}/login/encodeSHA.controller",
					type: "POST",
					async: true,
					data: {
						inputString: inputString
					},
					success: function(result) {
						document.getElementById("outputString").value = result;
						
						document.getElementById("outputStringLength").value = result.length;
					}
				});
			}			
		});
		
		// 点击“reset”按钮，重置输入框里面的内容
		$("#reset").click(function() {
			document.getElementById("inputString").value = "";
			document.getElementById("outputString").value = "";
			document.getElementById("outputStringLength").value = "";			
		});
		
		// 测试查询所有算法的按钮
		$("#searchAllAlgorithm").click(function() {
			$.ajax({
				url: "${pageContext.request.contextPath}/login/findAlgorithmResult.controller",
				type: "POST",
				async: true,
				data: {
					
				},
				success: function(result) {
					alert("查询所有算法成功!");
				}
			});
			
		});
		
		// 查询所有的数据，并且填充到表格中
		/*$.ajax({
			url: "",
			type: "POST",
			async: true,
			data: {},
			success: function(result) {

			    // 将json格式的数据转换成object对象，否则无法在grid中显示；此处的grid是用KendoUI控件实现的表格
			    var json = JSON.parse(result);

			    var grid = $("#grid").data("kendoGrid");        // 此处的 grid 是在页面中表格的div中的id
			    var dataSource = new kendo.data.DataSource( {data: json, pageSize: 10});

			    grid.setDataSource(dataSource);
			},
			error: function(result) {
			    alert("传输出错");
			}
		});*/

		// 将数据库中按算法名称查询出的数据填充到表格中
		$("#search").click(function() {
			var inputString = $("#algorithmName").val();
			
			$.ajax({
				url: "${pageContext.request.contextPath}/login/findAlgByName.controller",
				type: "POST",
				async: true,
				data: {
					inputString: inputString
				},
				success: function(result) {
					var grid = $("#grid").data("kendoGrid");
					var dataSource = new kendo.data.DataSource({ data: result, pageSize: 10});
					grid.setDataSource(dataSource);
				}
			});
		});

		$("#excelDownload").click(function() {
			$.ajax({
			   url: "${pageContext.request.contextPath}/login/downloadExcelFile.controller",
				type:"POST",
				async: true,
				data: {},
				success: function(result) {
			       alert("download excel file success!");
				},
				error: function(result) {
			       alert("download excel file failed!");
				}
			});
		});

	});
	
// 初始化表格
function initGrid(){
	$("#grid").kendoGrid({
		height: 400,
		groupable: false,
		sortable: true,
		pageable: {
			pageSize: 10
		},
		columns: [{
			field: "alg",
			title: "算法",
			width: 120,
			headerAttributes: {
				style: "font-weight: bold; font-size: 14px;"
			}
		},{
			field: "rult",
			title: "加密后结果",
			width: 120,
			headerAttributes: {
				style: "font-weight: bold; font-size: 14px;"
			}
		}]
	});
	
	// 将数据库中查出的数据填充到表格中
	$.ajax({
		url: "${pageContext.request.contextPath}/login/findAlgorithmResult.controller",
		type: "POST",
		async: true,
		data: {},
		success: function(result) {
			var grid = $("#grid").data("kendoGrid");
			var dataSource = new kendo.data.DataSource({ data: result, pageSize: 10 });
			grid.setDataSource(dataSource);
		},
		error: function(result) {
			alert("初始化表格失败!");
			console.log(result.status + "-------" + result.statusText);
		}

	});
}

function showSubMenu() {
	var m = document.getElementById("subMenu");
	m.style.display = "block";
}

function hiddenSubMenu() {
	var m = document.getElementById("subMenu");
	m.style.display = "none";
}

</script>

</head>
<body>

	<%--<div id="menu" style="background: #000000; width: 1500px; height: 50px; margin-left: 0px;">
		<img id="logoImg" src="${pageContext.request.contextPath}/images/logoImg1.png" style="float: left;">
	</div>--%>

	<div id="inputArea" style="margin-left: 30px; margin-top: 30px;">
	
		<!-- 设置背景图片 -->
		<%--<div id="backgroundImage" style="position: fixed; width: 100%; height: 100%; z-index: -1; left: 0; top: 0;">
			<img src="${pageContext.request.contextPath}/images/backgroundImage.png" height="100%" width="100%" style="left: 0; top: 0;" />
		</div>--%>
	
		<h1 style="font-family: '黑体'; font-size: 230%; margin-left: 400px; margin-top: 10px;">加密算法测试</h1>
		
		<br><br>
		
		<label>明文: </label>
		<input type="text" id="inputString" name="inputString" value="" style="margin-right: 30px; height: 20px; " />
		
		<label>密文： </label>
		<input type="text" id="outputString" name="outputString" value="" style="width: 500px; margin-right: 30px; height: 20px; " />
		
		<label>密文长: </label>
		<input type="text" id="outputStringLength" name="outputStringLength" value="" style="width: 40px; height: 20px;  margin-right: 30px;" />
		
		<input type="button" id="submit" style="width: 80px; height: 30px; margin-right: 20px;" value="SHA-1" name="SHA-1" />
		<input type="button" id="reset" style="width: 80px; height: 30px;" value="reset" name="reset" />
		
		<br><br>
		
	</div>
	
	<!-- 展示所有算法的表格（从数据库读取并且展示） -->
	<div id="searchAll" style="margin-top: 30px; margin-left: 30px;">
		
		<label>算法名称:  </label>
		<input type="text" id="algorithmName" style="width: 100px; height: 20px; margin-right: 50px;" value="" name="algorithmName" />
		
		<input type="button" id="search" style="width: 80px; height: 30px; " value="search" name="search" />

		<!--
		<input type="button" id="searchAllAlgorithm" style="width: 100px; height: 30px;" value="查询所有算法" name="searchALL">
		<br><br>
		-->

		<input type="button" id="excelDownload" style="margin-left: 30px; width: 100px; height: 50px;" value="excelDownload" name="excelDownload" />

		<input type="button" id="excelUpload" style="margin-left: 40px; width: 100px; height: 50px;" value="excelUpload" name="excelUpload" />

		<br><br>

		<div id="grid"></div>
	</div>


</body>
</html>