<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%
    String name = (String) session.getAttribute("name");
    String email = (String) session.getAttribute("email");
    String address = (String) session.getAttribute("address");
    String phone = (String) session.getAttribute("phone_number");

    ArrayList<String> errorList = (ArrayList<String>) request.getAttribute("errorList");
    String disableConfirm = (errorList != null) ? "disabled" : "";
%>
<html>
<head><title>確認画面</title></head>
<body>
    <h2>入力内容をご確認ください。</h2>
    <p>問題なければ「確定」、修正する場合は「キャンセル」をクリックしてください。</p>
    <table border="1">
        <tr><th>項目</th><th>入力内容</th></tr>
        <tr><td>氏名</td><td><%= name %></td></tr>
        <tr><td>メールアドレス</td><td><%= email %></td></tr>
        <tr><td>住所</td><td><%= address %></td></tr>
        <tr><td>電話番号</td><td><%= phone %></td></tr>
    </table>

    <button onclick="location.href='<%= request.getContextPath() %>/complete';" <%= disableConfirm %>>確定</button>
    <button onclick="history.back();">キャンセル</button>

    <% if (errorList != null) { %>
    <ul style="color: red;">
    <% for (String msg : errorList) { %>
        <li><%= msg %></li>
    <% } %>
    </ul>
<% } %>
    