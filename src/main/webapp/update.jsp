<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/10 0010
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("[value='返回']").click(function () {
                location.href="/selectall"
            });

            $("[value='删除']").click(function () {
                location.href="delete?id="+${air.id};
            });
            // 表单验证
            $("#myform").submit(function () {
                var districtId=$("[name='districtId']").val();
                if (districtId==-1){
                    alert("请选择监测区域");
                    return false;
                }
                var monitorTime=$.trim($("[name='monitorTime']").val());
                if (monitorTime.length==0){
                    alert("请输入监测日期");
                    return false;
                }else{
                    var fag=/^\d{4}[-]\d{2}[-]\d{2}$/;
                    if (!fag.test(monitorTime)){
                        alert("监测日期格式为yyyy-MM-dd");
                        return false;
                    }
                }
                var pm10=$.trim($("[name='pm10']").val());
                if (pm10.length==0){
                    alert("请输入PM10值");
                    return false;
                }else{
                    var fag=/^\d+$/;
                    if (!fag.test(pm10)){
                        alert("PM10的值为数字");
                        return false;
                    }
                }

                var pm25=$.trim($("[name='pm25']").val());
                if (pm25.length==0){
                    alert("请输入PM2.5值");
                    return false;
                }else{
                    var fag=/^\d+$/;
                    if (!fag.test(pm25)){
                        alert("PM2.5的值为数字");
                        return false;
                    }
                }
                var station=$.trim($("[name='monitoringStation']").val());
                if (station.length==0){
                    alert("请输入监测站");
                    return false;
                }
            });

        });

    </script>
    <style type="text/css">
        .div1{
            width: 500px;
            margin: 0px auto;
        }
        table{
            line-height: 30px;
        }
    </style>
</head>
<body>
<div class="div1">
    <div align="center">
        <h2>空气质量信息维护界面</h2>
    </div>
    <div align="center">
        <form action="update" method="post" id="myform">
            <input type="hidden" name="id" value="${air.id}">
            <table>
                <tr>
                    <td align="right">监测区域:</td>
                    <td>
                        <select name="districtId">
                            <option value="-1">--请选择--</option>
                            <c:forEach items="${dis}" var="d">
                                <option value="${d.id}" ${d.id==air.districtId?'selected':''}>${d.name}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">监测日期:</td>
                    <td><input type="text" name="monitorTime"
                               value="<fmt:formatDate value='${air.monitorTime}' pattern="yyyy-MM-dd"/> "></td>
                </tr>
                <tr>
                    <td align="right">PM10值:</td>
                    <td><input type="text" name="pm10" value="${air.pm10}"></td>
                </tr>
                <tr>
                    <td align="right">PM2.5值:</td>
                    <td><input type="text" name="pm25" value="${air.pm25}"></td>
                </tr>
                <tr>
                    <td align="right">监测站:</td>
                    <td><input type="text" name="monitoringStation" value="${air.monitoringStation}"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="保存">
                        <input type="reset" value="删除">
                        <input type="button" value="返回">
                    </td>
                </tr>
            </table>

        </form>
    </div>

</div>

</body>
</html>
