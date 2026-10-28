package com.denniskurilov.ezpz.config;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.tomcat.TomcatWebServer;
import org.springframework.boot.tomcat.servlet.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * The application lives under the /ezpz context path, so nothing answers on "/".
 * This adds a tiny root context to the embedded Tomcat that serves
 * classpath:root/index.html, a static page redirecting to /ezpz/.
 */
@Configuration
public class RootPageConfig {

	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
		return new TomcatServletWebServerFactory() {
			@Override
			protected TomcatWebServer getTomcatWebServer(Tomcat tomcat) {
				Context root = tomcat.addContext("", null);
				Tomcat.addServlet(root, "rootPage", new RootPageServlet());
				root.addServletMappingDecoded("/", "rootPage");
				return super.getTomcatWebServer(tomcat);
			}
		};
	}

	private static class RootPageServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			response.setContentType("text/html;charset=UTF-8");
			try (InputStream page = new ClassPathResource("root/index.html").getInputStream()) {
				page.transferTo(response.getOutputStream());
			}
		}

	}

}
