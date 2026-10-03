import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/legal_age")
public class LegalAgeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int age = Integer.parseInt(req.getParameter("age"));

        if (age < 18) {
            resp.getWriter().println("You are a minor!");
        } else {
            resp.getWriter().println("You are of legal age.");
        }
    }
}
