package homework;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@WebServlet("/washindton")
public class WashingtonTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ZoneId washingtonZone = ZoneId.of("America/New_York");
        ZonedDateTime mTimeNow = ZonedDateTime.now(washingtonZone);
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("HH:mm:ss, EEEE, d MMMM yyyy", new Locale("en"));

        String formattedTime = mTimeNow.format(formatter);
        resp.getWriter().println("Current time in Washington: " + formattedTime);
    }
}
