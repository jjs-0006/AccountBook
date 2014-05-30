<%@page import="jp.co.jjs.java_seminar.javabeans.Data"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修正一覧</title>
    </head>
    <body>
    <center>
        <jsp:include page ="header.jsp"/>
        <table>
            <tr>
            <%
            ArrayList<Data> datalist = (ArrayList<Data>)(request.getSession().getAttribute("datalist"));
                for(int i = 0; i < datalist.size(); i++ ){
            %>
                <br>
                <th>日付</th>
                <th>分類</th>
                <th>金額</th>
                <th>備考</th>
                <th><form method="post" action="revisionlist">
                        <input type="submit" name="<%= i %>" value="削除">
                    </form></th>
                <th><form method="post" action="revision">
                        <input type="submit" name="<%= i %>" value="編集">
                    </form></th></tr>
            <%
                }
            %>
            <tr>
        </table>
    </center>
    </body>
</html>