package com.example.demo.tomcatColumn.lecture28.custom_web_container;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

/**
 * @author Alan Yin
 * @date 2020/7/20
 */
@Component
public class MyTomcatCustomizer implements WebServerFactoryCustomizer<TomcatServletWebServerFactory> {

    @Override
    public void customize(TomcatServletWebServerFactory factory) {
        factory.setPort(8081);
        factory.setContextPath("/test28");
        factory.addEngineValves(new TraceValve());
    }

}
