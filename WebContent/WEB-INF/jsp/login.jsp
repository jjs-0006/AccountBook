<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>ログインページ</title>
    </head>
    <body>
        <form method="post" action="Entry">
            <Div Align="right"><input type="submit" value="新規登録"></Div>
        </form>
        <form method="post" action="loginquery">
            <center>
                <h1>家計簿ログインページ</h1>
                <table>
                <%
                    if(request.getSession().getAttribute("massage") != null){
                %>
                <%= request.getSession().getAttribute("massage") %>
                <%
                    }
                %>
                    <tr>
                        <th>ID</th>
                        <th>:<input type="text" size="30" name="id"></th></br>
                    </tr>
                    <tr>
                        <th>パスワード</th>
                        <th>:<input type="text" size="30" name="pass"></th></br>
                    </tr>
                </table>
                <input type="submit" value="ログイン">
            </center>
        </form>
    </body>
</html>