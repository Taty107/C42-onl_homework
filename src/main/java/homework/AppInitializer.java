package homework;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The app is working!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("The app is stopped!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~");
    }
}
