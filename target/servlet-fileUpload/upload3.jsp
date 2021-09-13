<%--
  Created by IntelliJ IDEA.
  User: r00t4dm
  Date: 2021/9/13
  Time: 2:40 下午
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>File upload</title>
</head>
<body>
<form action="/upload3" enctype="multipart/form-data" method="post">
    <p>
        文件: <input id="file" name="file" type="file"/>
    </p>
    <input name="submit" type="submit" value="Submit"/>
</form>
</body>
</html>