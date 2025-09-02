package sj;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // JSPから送られたnameパラメータを取得
    String name = request.getParameter("name");

    // メッセージを生成
    String message = name + "さん、こんにちは！";

    // リクエストスコープに格納
    request.setAttribute("message", message);

    // JSPへフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
    dispatcher.forward(request, response);
  }
}
