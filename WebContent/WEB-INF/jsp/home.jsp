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
    </body>
</html>