package com.example.demo.tomcatColumn.lecture28.custom_web_container;

import org.apache.catalina.Valve;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * 定制Web容器方式2: 结合 MyTomcatCustomizer
 * <p>
 * 通过特定Web容器的工厂比如TomcatServletWebServerFactory来进一步定制。
 * 下面的例子里，我们给Tomcat增加一个Valve，这个Valve的功能是向请求头里添加 traceId，用于分布式追踪。
 *
 * @author Alan Yin
 * @date 2020/7/20
 */

public class TraceValve extends ValveBase {
    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        request.getCoyoteRequest()
                .getMimeHeaders()
                .addValue("traceId")
                .setString("1234xxxxabcd");
        Valve next = getNext();
        if (null == next) {
            return;
        }
        next.invoke(request, response);
    }
}
