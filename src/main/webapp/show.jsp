<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10 0010
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .div1{
            width: 600px;
            margin: 0px auto;
        }
    </style>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("tr:even").css("background","#79CDCD");
            $("tr:odd").css("background","#00B2EE");
            $("tr:eq(0)").css("background","white")
        })

    </script>

</head>
<body>
<div class="div1">
    <div align="center">
        <form action="/selectall" method="post">
        <h1>空气质量监测信息库</h1>
        <table>
            <tr>
                <td>
                    按区域查询:<select name="did">
                    <option value="-1">--请选择--</option>
                    <c:forEach items="${dlist}" var="d">
                        <option value="${d.id}" ${d.id==did?'selected':''}>${d.name}</option>
                    </c:forEach>
                </select>
                    <input type="submit" value="查找">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </td>
                <td><a href="/finddistrict">添加空气质量信息</a> </td>
            </tr>
        </table>
        </form>
    </div>

    <div align="center">
        <table cellspacing="0" border="1" width="600px">
            <tr class="trs">
                <td>序号</td>
                <td>区域</td>
                <td>监测时间</td>
                <td>PM10数据</td>
                <td>PM2.5数据</td>
                <td>监测站</td>
            </tr>
            <c:forEach items="${info.list}" var="ai" varStatus="a1">
                <tr class="trs">
                    <td>${a1.count}</td>
                    <td><a href="/findair?id=${ai.id}">${ai.district.name}</a></td>
                    <td><fmt:formatDate value="${ai.monitorTime}" pattern="yyyy-MM-dd"/> </td>
                    <td>${ai.pm10}</td>
                    <td>${ai.pm25}</td>
                    <td>${ai.monitoringStation}</td>
                </tr>
            </c:forEach>
            <tr align="center">
                <td colspan="6" valign="center">
                    <a href="/selectall?did=${did}">首页|</a>
                    <a href="/selectall?did=${did}&index=${info.prePage==0?1:info.prePage}">&lt;&lt;上一页|</a>
                    <a href="/selectall?did=${did}&index=${info.nextPage==0?info.pages:info.nextPage}">下一页&gt;&gt;</a>
                    <a href="/selectall?did=${did}&index=${info.pages}">|尾页</a>
                    第${info.pageNum}页/共${info.pages}页(${info.total}条)
                </td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
