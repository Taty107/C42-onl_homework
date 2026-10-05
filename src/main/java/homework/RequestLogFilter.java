package homework;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebFilter("/*")
public class RequestLogFilter implements Filter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String currentTime = LocalDateTime.now().format(FORMATTER);
        System.out.println("[" + currentTime + "] Request " + httpRequest.getMethod() + " "
                + httpRequest.getRequestURI());
        chain.doFilter(request, response);
    }
}
