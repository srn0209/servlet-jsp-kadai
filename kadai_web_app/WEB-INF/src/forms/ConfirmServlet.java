package forms;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConfirmServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone_number");

        ArrayList<String> errorList = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            errorList.add("お名前を入力してください。");
        }

        if (email == null || email.trim().isEmpty()) {
            errorList.add("メールアドレスを入力してください。");
        } else if (!email.matches("^[\\w\\.-]+@[\\w\\.-]+$")) {
            errorList.add("メールアドレスの形式が正しくありません。");
        }

        if (address == null || address.trim().isEmpty()) {
            errorList.add("住所を入力してください。");
        }

        if (phone == null || phone.trim().isEmpty()) {
            errorList.add("電話番号を入力してください。");
        }

        if (!errorList.isEmpty()) {
            request.setAttribute("errorList", errorList);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("address", address);
            session.setAttribute("phone_number", phone);

            setCookie(response, "name", name);
            setCookie(response, "email", email);
            setCookie(response, "address", address);
            setCookie(response, "phone_number", phone);
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/confirmPage.jsp");
        dispatcher.forward(request, response);
    }

    private void setCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }
}
