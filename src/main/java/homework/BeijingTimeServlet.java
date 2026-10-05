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

@WebServlet("/beijing")
public class BeijingTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ZoneId beijingZone = ZoneId.of("America/New_York");
        ZonedDateTime mTimeNow = ZonedDateTime.now(beijingZone);
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("HH:mm:ss, EEEE, d MMMM yyyy", new Locale("en"));

        String formattedTime = mTimeNow.format(formatter);
        resp.getWriter().println("Current time in Beijing: " + formattedTime);
    }
}
