<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login page</title>
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
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
            rel="stylesheet">

    <script
            src="${pageContext.request.contextPath}/Common/kendoUI/js/jquery.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/scripts/jquery-2.1.3.js"></script>
    <script
            src="${pageContext.request.contextPath}/scripts/kendoUI/kendo.all.min.js"></script>
    <script
            src="${pageContext.request.contextPath}/Common/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

    <div id="inputArea" align="center" style="margin-top: 80px;">
        <label>用户名：</label>
        <input type="text" id="usrName" name="usrName"><br>

        <label>密码：</label>
        <input type="text" id="password" name="password"><br>

        <label>登录</label>
        <input class="btn btn-default" id="submit" type="submit" value="submit" >

        <label>重置</label>
        <input type="button" id="reset" name="reset" value="reset">
    </div>

</body>
</html>
