<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yangxuan
  Date: 2019-05-20
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form action="" method="post">
        <table>
            <caption>用户登录</caption>
            <tr>
                <td>用户名:</td>
                <td><input type="text"name="username" size="20"></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password"name="pwd" size="20"></td>
            </tr>
            <tr>

                <td><input type="submit" value="登录" formaction="loginCheck.action"></td>
                <td><input type="reset" value="重新输入"></td>
                <td><input type="submit" value="修改" formaction="Up.action"></td>
            </tr>
        </table>

    </form>

</body>
<c:if test="${not empty error }">
    <script type="text/javascript">
        alert('${error}')

        //调用后端传过来的值 通过键值对的方式
    </script></c:if>
<script src="http://cdn.bootcss.com/jquery/3.2.1/jquery.min.js">

</script><script src="http://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script></html>
