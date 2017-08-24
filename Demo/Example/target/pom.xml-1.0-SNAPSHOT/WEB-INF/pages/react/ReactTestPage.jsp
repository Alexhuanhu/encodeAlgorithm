<%--
  Created by IntelliJ IDEA.
  User: Alexhu
  Date: 2017/7/19
  Time: 上午8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>React test page</title>
    <!--<script src="https://cdn.bootcss.com/react/15.4.2/react.min.js"></script>
    <script src="https://cdn.bootcss.com/react/15.4.2/react-dom.min.js"></script>
    <script src="https://cdn.bootcss.com/babel-standalone/6.22.1/babel.min.js"></script>-->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.3/react.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/react/0.14.3/react-dom.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.23/browser.min.js"></script>
</head>
<body>

<!--<div id="example"></div>
<script type="text/babel">
    ReactDOM.render(
        <h1>Hello, world!</h1>
        document.getElementById('example')
    );
</script>-->

    <h1>ha ha ha ha</h1>
<div id="content"></div>
<script type="text/babel">
    var MessageBox = React.createClass({
        alertMe: function() {
            alert('你刚才点了我一下!');
        },
        render: function() {
            return (<h1 onClick={this.alertMe()}>Hello world!</h1>)
        }
    });

    React.render(<MessageBox/>),
        document.getElementById('app'),
        function() {
            console.log('渲染完成!');
        }
</script>
<div id="app"></div>

</body>
</html>
