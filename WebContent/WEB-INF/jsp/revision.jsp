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
        <form method="post" action="">
            <center>
                <select name="grouping">
                    <form method="post" action="">
                        <option value="光熱費">光熱費</option>
                        <option value="食費">食費</option>
                        <option value="保険">保険</option>
                        <option value="生活雑貨・日用品">生活雑貨・日用品</option>
                        <option value="通信費">通信費</option>
                        <option value="医療費">医療費</option>
                        <option value="交通費">交通費</option>
                        <option value="美容費">美容費</option>
                        <option value="被服費">被服費</option>
                        <option value="住宅費">住宅費</option>
                        <option value="その他">その他</option>
                        <option value="すべての支出">すべての支出</option>
                        <option value="収入">収入</option>
                    </select></th>
                金額:<input type="text" size="10" name="id" value=""></br>
                備考:<input type="text" size="30" name="id" value=""></br>
                <input type="submit" value="決定">
            </center>
        </form>
    </body>
</html>