<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Servlet連携テスト</title>
</head>
<body>

  <!-- Servletへのリンク -->
  <a href="LinkServlet?name=侍太郎">名前「侍太郎」をServletに送信</a>

  <br><br>

  <!-- メッセージ表示（Servletからフォワードされたときのみ） -->
  <%
    String message = (String) request.getAttribute("message");
    if (message != null) {
  %>
    <p><strong>Servletからデータを受信しました： </strong><br>
    <%= message %></p>
  <%
    }
  %>
</body>
</html>
