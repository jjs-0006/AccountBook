<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>家計簿ホーム画面</title>
        <link rel="stylesheet" type="text/css" href="css/dc.css" />
    </head>
    <body>
        <jsp:include page ="header.jsp"/>

        <div id="chart"></div>

        <script type="text/javascript" src="js/underscore-min.js"></script>
        <script type="text/javascript" src="js/d3.js"></script>
        <script type="text/javascript" src="js/crossfilter.js"></script>
        <script type="text/javascript" src="js/dc.js"></script>
        <script type="text/javascript">
           var chart = dc.pieChart("#chart"),
               allData, ndx, dimension, sumGroup, expenses;

           allData = [
           <c:forEach var="d" items="${data}">
             {typeNum: ${d.type_number}, type: "${d.typeName}", money: ${d.money}, date: ${d.date}},
           </c:forEach>
           ];
           expenses = _.filter(allData, function(data) {
             return data.typeNum !== 12;
           });
           ndx = crossfilter(expenses);
           dimension = ndx.dimension(function(d) { return d.type; });

           sumGroup = dimension.group().reduceSum(function(d) {
             return d.money;
           });

           chart
             .width(300)
             .height(300)
             .innerRadius(30)
             .minAngleForLabel(0)
             .dimension(dimension)
             .group(sumGroup)
             .legend(dc.legend());

           chart.render();

        </script>
        収支登録<br>
        <table>
        <tr><th><select name="grouping">
                <option value="1">光熱費</option>
                <option value="2">食費</option>
                <option value="3">保険</option>
                <option value="4">生活雑貨・日用品</option>
                <option value="5">通信費</option>
                <option value="6">医療費</option>
                <option value="7">交通費</option>
                <option value="8">美容費</option>
                <option value="9">被服費</option>
                <option value="10">住宅費</option>
                <option value="11">その他</option>
                <option value="12">収入</option>
                <option value="13">すべての支出</option>
       </select></th>
       <th><input type="text" size="10" name="money">円</th>
       <th> </th>
       </tr>
       </table>
    </body>
</html>