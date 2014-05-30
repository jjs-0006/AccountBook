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
                ArrayList<Goal> goallist = (ArrayList<Goal>)request.getAttribute("goallist");


            %>
            <form method="post" action="">
                <table>
                    <tr>
                    <th>光熱費</th>
                    <th>:<input type="text" size="30" name="id1" value="<%= goallist.get(0) != null ? goallist.get(0).getMoney(): "" %>"></th>
                    </tr>
                     <tr>
                    <th>食費</th>
                    <th>:<input type="text" size="30" name="id2" value="<%= goallist.get(1) != null ? goallist.get(1).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>保険</th>
                    <th>:<input type="text" size="30" name="id3" value="<%= goallist.get(2) != null ? goallist.get(2).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>生活雑貨・日用品</th>
                    <th>:<input type="text" size="30" name="id4" value="<%= goallist.get(3) != null ? goallist.get(3).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>通信費</th>
                    <th>:<input type="text" size="30" name="id5" value="<%= goallist.get(4) != null ? goallist.get(4).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>医療費</th>
                    <th>:<input type="text" size="30" name="id6" value="<%= goallist.get(5) != null ? goallist.get(5).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>交通費</th>
                    <th>:<input type="text" size="30" name="id7" value="<%= goallist.get(6) != null ? goallist.get(6).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>美容費</th>
                    <th>:<input type="text" size="30" name="id8" value="<%= goallist.get(7) != null ? goallist.get(7).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>被服費</th>
                    <th>:<input type="text" size="30" name="id9" value="<%= goallist.get(8) != null ? goallist.get(8).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>住宅費</th>
                    <th>:<input type="text" size="30" name="id10" value="<%= goallist.get(9) != null ? goallist.get(9).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>その他</th>
                    <th>:<input type="text" size="30" name="id11" value="<%= goallist.get(10) != null ? goallist.get(10).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                    <th>収入</th>
                    <th>:<input type="text" size="30" name="id12" value="<%= goallist.get(11) != null ? goallist.get(11).getMoney(): "" %>"></th>
                    </tr>
                    <tr>
                                    </table>
                <table><tr>
                    <th><input type="submit" value="登録" name="goalentry"></th>
            </form>
            <form method="post" action="home">
                    <th><input type="submit" value="キャンセル"></th>
                </tr></table>
            </form>
        </center>
    </body>
</html>