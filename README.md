# Voldemart
This is an Professonal ecommerce app build using spring boot.

# Note:
Back-end is perfectly fine the Front-end need some modifications.

[see live Application](https://voldemart-3d.herokuapp.com/)

## Want to Add Product ?

```bash
UserName: reddy 
Password: reddy
```
```
server.port=8443
server.ssl.key-store=classpath:keystore.jks
server.ssl.key-store-password=your_keystore_password
server.ssl.key-store-type=JKS
server.ssl.key-alias=myalias
```
```
keytool -genkeypair -alias mysslcert -keyalg RSA -keysize 2048 \
  -storetype PKCS12 -keystore keystore.p12 -validity 3650
```
```
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpsRedirectConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
        return factory;
    }

    private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(8080); // HTTP port
        connector.setSecure(false);
        connector.setRedirectPort(8443); // Redirect to HTTPS
        return connector;
    }
}
```
