<%--
  Created by IntelliJ IDEA.
  User: zhouas666
  Date: 2017/12/25
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>文件上传下载</title>
</head>
<body>
<form action="http://139.199.176.173:8080/ssmBillBook/file/upload" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="file" width="120px">
    <input type="submit" value="上传">
</form>
<hr>
<form action="http://139.199.176.173:8080/ssmBillBook/file/down" method="get">
    <input type="submit" value="下载">
</form>
</body>
</body>
</html>