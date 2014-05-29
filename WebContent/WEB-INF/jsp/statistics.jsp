<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>統計</title>
    </head>
    <body>
        <center><table>
            <tr>
            <th><select name="time">
                <option value="1ヶ月">1ヶ月</option>
                <option value="3ヶ月">3ヶ月</option>
                <option value="1年">1年</option>
            </select></th>

            <th><select name="grouping">
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

            <th><input type="submit" value="表示"></th>
            </tr>
        </table></center>
    </body>
</html>