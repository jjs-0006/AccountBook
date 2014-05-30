<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新規登録画面</title>
    </head>
    <body>
        <center>
        <h1>新規登録</h1>
            <table>
                <tr>
                    <th>ID</th>
                    <th>:<input type="text" size="30" name="id"></th>
                </tr>
                <tr>
                    <th>パスワード</th>
                    <th>:<input type="text" size="30" name="pass1"></th>
                </tr>
                <tr>
                    <th>パスワード（確認）</th>
                    <th>:<input type="text" size="30" name="pass2"></th>
                </tr>
                <tr>
                     <th><form method="post" action="entryquery">
                        <input type="submit" value="登録">
                        </form></th>
                     <th><form method="post" action="login">
                        <input type="submit" value="キャンセル">
                        </form></th>
                </tr>
            </table>
        </center>
    </body>
</html>