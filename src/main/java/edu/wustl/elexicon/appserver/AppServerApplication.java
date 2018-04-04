package edu.wustl.elexicon.appserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
public class AppServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppServerApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext sc) throws ServletException {
		sc.addListener(new RequestContextListener());
	}
}
