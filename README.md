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
```
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.Ssl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SslConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        Ssl ssl = new Ssl();
        ssl.setEnabled(true);
        ssl.setKeyStore("classpath:file.jks");
        ssl.setKeyStoreType("JKS");
        ssl.setKeyStorePassword("");  // <- empty string here
        ssl.setKeyAlias("yourAliasHere");

        factory.setSsl(ssl);
        return factory;
    }
}
```


```
keytool -genkeypair -alias mycert -keyalg RSA -keysize 2048 -storetype JKS -keystore keystore.jks -validity 3650

server.port=8443
server.ssl.enabled=true
server.ssl.key-store=classpath:keystore.jks
server.ssl.key-store-password=yourpassword
server.ssl.key-store-type=JKS
server.ssl.key-alias=mycert


@Configuration
public class WebServerConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        return server -> {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setPort(8080);
            connector.setScheme("http");
            connector.setSecure(false);
            connector.setRedirectPort(8443);
            server.addAdditionalTomcatConnectors(connector);
        };
    }
}

package com.example.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpToHttpsRedirectConfig {

    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> containerCustomizer() {
        return factory -> {
            Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
            connector.setScheme("http");
            connector.setPort(8080); // HTTP port
            connector.setSecure(false);
            connector.setRedirectPort(8443); // HTTPS port
            factory.addAdditionalTomcatConnectors(connector);
        };
    }
}

```
```
server.tomcat.relaxed-path-chars=<>[]^`{}|\\
server.tomcat.relaxed-query-chars=<>[]^`{}|\\
```


```
import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpToHttpsRedirectConfig {

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    private Connector httpConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(80); // You can use any port for HTTP, e.g., 8081
        connector.setSecure(false);
        connector.setRedirectPort(8080); // This is your HTTPS port
        return connector;
    }
}
```

```
set-pipeline-name:
  stage: show-info
  script:
    - |
      if [[ "$RUN_DEPLOY" == "false" && "$RUN_RELEASE" == "false" ]]; then
        NEW_NAME="$CI_COMMIT_MESSAGE"
      elif [[ "$RUN_RELEASE" == "true" && "$RUN_DEPLOY" == "false" ]]; then
        NEW_NAME="Release created with revision $revision"
      elif [[ "$RUN_DEPLOY" == "true" && "$RUN_RELEASE" == "false" ]]; then
        NEW_NAME="With TAG: $revision ACTION: $ACTION INVENTORY: $INVENTORY_NAME"
      elif [[ "$RUN_DEPLOY" == "true" && "$RUN_RELEASE" == "true" ]]; then
        NEW_NAME="RELEASE + DEPLOY — Revision $revision, ACTION: $ACTION, INVENTORY: $INVENTORY_NAME"
      else
        NEW_NAME="Unknown pipeline state"
      fi

      echo "Setting pipeline title to: $NEW_NAME"

      curl --request PUT \
        --header "PRIVATE-TOKEN: $GITLAB_TOKEN" \
        --header "Content-Type: application/json" \
        --data "{\"name\": \"$NEW_NAME\"}" \
        "https://gitlab.com/api/v4/projects/$CI_PROJECT_ID/pipelines/$CI_PIPELINE_ID"
  rules:
    - when: always

```
