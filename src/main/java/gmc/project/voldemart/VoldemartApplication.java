package gmc.project.voldemart;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import gmc.project.voldemart.bootstrap.CategoryBootstrap;
import gmc.project.voldemart.bootstrap.ProductBootStrap;

@SpringBootApplication
public class VoldemartApplication implements CommandLineRunner {

	@Autowired
	private CategoryBootstrap categoryBootstrap;

	@Autowired
	private ProductBootStrap productBootStrap;

	@Override
	public void run(String... args) throws Exception {
		categoryBootstrap.execute();
		productBootStrap.execute();
	}

	public static void main(String[] args) {
		SpringApplication.run(VoldemartApplication.class, args);
	}
	
//	@Bean
//	public ServletWebServerFactory servletConnector() {
//		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
//
//			protected void postProcessContext(Context context) {
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//
//				SecurityCollection securityCollection = new SecurityCollection();
//				securityCollection.addPattern("/*");
//
//				securityConstraint.addCollection(securityCollection);
//				context.addConstraint(securityConstraint);
//			}
//
//		};
//		tomcat.addAdditionalTomcatConnectors(redirectConnector());
//		return tomcat;
//	}
//
//	private Connector redirectConnector() {
//		Connector connector = new Connector();
//		connector.setScheme("http");
//		connector.setPort(8080);
//		connector.setRedirectPort(8443);
//		return connector;
//	}

}
