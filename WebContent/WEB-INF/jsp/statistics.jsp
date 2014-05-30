<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>統計</title>
    </head>
    <body>
        <form method="post" action="statistics">
        <jsp:include page ="header.jsp"/>
        <center><table>
            <tr>
            <th><select name="time">
                <option value="1">1ヶ月</option>
                <option value="3">3ヶ月</option>
                <option value="12">1年</option>
            </select></th>

            <th><select name="grouping">
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
                <option value="12">収入</option>
                <option value="13">すべての支出</option>
            </select></th>

            <th><input type="submit" value="表示"></th>
            </tr>
        </table>

        </center>
        </form>
    </body>
</html>