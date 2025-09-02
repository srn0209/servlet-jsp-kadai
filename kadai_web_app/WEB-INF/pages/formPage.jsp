<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Objects" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>課題</title>
</head>
<body>
    <%
        String userName = Objects.toString(request.getAttribute("userName"), "");
        String userEmail = Objects.toString(request.getAttribute("userEmail"), "");
        String userAddress = Objects.toString(request.getAttribute("userAddress"), "");
        String userPhone = Objects.toString(request.getAttribute("userPhoneNumber"), "");
    %>

    <h2>個人情報入力フォーム</h2>
    <form action="<%= request.getContextPath() %>/confirm" method="post">
        <table>
            <tr><td>お名前</td><td><input type="text" name="name" value="<%= userName %>"></td></tr>
            <tr><td>メールアドレス</td><td><input type="text" name="email" value="<%= userEmail %>"></td></tr>
            <tr><td>住所</td><td><input type="text" name="address" value="<%= userAddress %>"></td></tr>
            <tr><td>電話番号</td><td><input type="text" name="phone_number" value="<%= userPhone %>"></td></tr>
        </table>
        <input type="submit" value="送信">
    </form>
</body>
</html>
