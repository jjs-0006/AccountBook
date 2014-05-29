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
        <table>
            <tr>
            <%

                for(int i = 0; i < list.size(); i++ ){
            %>
                日付
                <br>
                <th>分類・金額・備考
                <th>
                <th><form method="post" action="">
                        <input type="submit" name="<%= i %>>" value="削除">
                    </form></th>
                <th><form method="post" action="">
                        <input type="submit" value="編集">
                    </form></th>
            <%
                }
            %>
            <tr>
        </table>
    </center>
    </body>
</html>