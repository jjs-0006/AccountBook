<%@page import="jp.co.jjs.java_seminar.javabeans.Data"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修正画面</title>
    </head>
    <center>
        <h1>修正画面</h1>
    </center>
    <body>
        <center>
            <%
                Data data = (Data)request.getSession().getAttribute("data");
            %>
            <jsp:include page ="header.jsp"/>
            <form method="post" action="revisionlist">
                <select name="grouping">
                    <form method="post" action="">
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
                        <option value="12">すべての支出</option>
                        <option value="13">収入</option>
                    </select></th>
                金額:<input type="text" size="10" name="id" value="<%= data.getMoney() %>"></br>
                備考:<input type="text" size="30" name="id" value="<%= data.getNote() %>"></br>
                <input type="submit" value="決定">
            </center>
        </form>
    </body>
</html>