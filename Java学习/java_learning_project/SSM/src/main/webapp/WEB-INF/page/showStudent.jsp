
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>显示所有学生页面</title>
</head>
<body>
    <table border="1" cellspacing="0" width="60%">
        <caption><h1 style="color:darkblue">学生表</h1></caption>
        <tr>
            <th>学生号</th><th>姓名</th><th>性别</th><th>主修</th>
        </tr>

        <c:if test="${list != null}">
            <c:forEach items="${list}" var="item">
                <tr>
                    <td style="text-align: center">${item.stuID}</td>
                    <td style="text-align: center">${item.stuName}</td>
                    <td style="text-align: center">${item.stuSex}</td>
                    <td style="text-align: center">${item.stuMajor}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${list == null}">
            <tr>
                <td colspan="4"><font color="red"> No Matching </font></td>
            </tr>
        </c:if>
    </table>

</body>
</html>
