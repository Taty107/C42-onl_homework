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

@WebServlet("/minsk")
public class MinskTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ZoneId minskZone = ZoneId.of("Europe/Minsk");
        ZonedDateTime mTimeNow = ZonedDateTime.now(minskZone);
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("HH:mm:ss, EEEE, d MMMM yyyy", new Locale("en"));

        String formattedTime = mTimeNow.format(formatter);
        resp.getWriter().println("Current time in Minsk: " + formattedTime);
    }
}
