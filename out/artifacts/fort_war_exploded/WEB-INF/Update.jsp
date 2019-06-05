<%--
  Created by IntelliJ IDEA.
  User: yangxuan
  Date: 2019-05-24
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<form action="" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input name="username" value="${user.username}"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input name="pwd" value="${user.pwd}"></td>
        </tr>

            <td><input type="submit" name="update" value="保存" formaction="index.action" ></td>
        </tr>


    </table>


</form>
</body>
</html>
