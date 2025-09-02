package forms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                switch (c.getName()) {
                    case "name":
                        request.setAttribute("userName", c.getValue());
                        break;
                    case "email":
                        request.setAttribute("userEmail", c.getValue());
                        break;
                    case "address":
                        request.setAttribute("userAddress", c.getValue());
                        break;
                    case "phone_number":
                        request.setAttribute("userPhoneNumber", c.getValue());
                        break;
                }
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pages/formPage.jsp");
        dispatcher.forward(request, response);
    }
}
