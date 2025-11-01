package org.example.oris_cw_01.Listeners;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.oris_cw_01.Utils.DBConnection;

@WebListener
public class DBContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        try {
            DBConnection.init();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DBConnection.destroy();
    }
}
