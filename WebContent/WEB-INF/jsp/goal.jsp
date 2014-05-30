<%@page import="jp.co.jjs.java_seminar.javabeans.Goal"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>目標登録ページ</title>
    </head>
    <body>
        <center>
        <jsp:include page ="header.jsp"/>
            <h1>今月の目標</h1>
            <%
                ArrayList<Goal> goallist = request.getSession().getAttribute();
            %>
            <form method="post" action="">
                <table>
                    <tr>
                    <th>光熱費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                     <tr>
                    <th>食費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>保険</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>生活雑貨・日用品</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>通信費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>医療費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>交通費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>美容費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>被服費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>住宅費</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <tr>
                    <th>その他</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>全ての支出</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                    <tr>
                    <th>収入</th>
                    <th>:<input type="text" size="30" name="id" value=""></th>
                    </tr>
                </table>
                <table><tr>
                    <th><input type="submit" value="登録"></th>
            </form>
            <form method="post" action="home">
                    <th><input type="submit" value="キャンセル"></th>
                </tr></table>
            </form>
        </center>
    </body>
</html>