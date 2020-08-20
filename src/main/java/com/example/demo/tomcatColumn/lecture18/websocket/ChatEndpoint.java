package com.example.demo.tomcatColumn.lecture18.websocket;

import lombok.extern.slf4j.Slf4j;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Tomcat 端的实现类加上 @ServerEndpoint 注解，里面的 value 是 URL 路径
 *
 * @author Alan Yin
 * @date 2020/5/12
 */
@ServerEndpoint(value = "/websocket/chat")
@Slf4j
public class ChatEndpoint {

    private static final String GUEST_PREFIX = "Guest";

    private static final AtomicInteger CONNECTION_IDS = new AtomicInteger(0);

    /**
     * 记录当前有多少个用戶加入到了聊天室，它是static全局变量。为了多线程安全使用原子变量 AtomicInteger
     */
    private static final Set<ChatEndpoint> CONNECTIONS = new CopyOnWriteArraySet<>();

    private final String nickname;

    private Session session;

    public ChatEndpoint() {
        nickname = GUEST_PREFIX + CONNECTION_IDS.getAndIncrement();
    }

    /**
     * 新连接到达时，Tomcat 会创建一个 Session,并回调这个函数
     */
    @OnOpen
    public void start(Session session) {
        this.session = session;
        CONNECTIONS.add(this);
        String message = String.format("%s %s", nickname, "has joined");
        broadcast(message);
    }

    /**
     * 浏览器关闭连接时，Tomcat会回调这个函数
     */
    @OnClose
    public void end() {
        CONNECTIONS.remove(this);
        String message = String.format("%s %s", nickname, "has disconnected");
        broadcast(message);
    }

    /**
     * 浏览器发送消息到服务器，tomcat 会回调这个函数
     *
     * @param message
     */
    @OnMessage
    public void incoming(String message) {
        // never trust the client
        String filterMsg = String.format("%s:%s", nickname, message + "coming");
        broadcast(filterMsg);
    }

    /**
     * websocket 连接出错时，会回调这个函数
     *
     * @param t
     * @throws Throwable
     */
    @OnError
    public void onError(Throwable t) throws Throwable {
        log.error("chat error:" + t.toString(), t);
    }

    /**
     * 广播
     *
     * @param message
     */
    private void broadcast(String message) {
        for (ChatEndpoint client : CONNECTIONS) {
            try {
                synchronized (client) {
                    client.session.getBasicRemote().sendText(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static ConcurrentHashMap<String, ChatEndpoint> webSocketMaps = new ConcurrentHashMap<>();

    /**
     * 向指定的客户端发消息
     *
     * @param identify
     * @param message
     * @throws IOException
     */
    public void sendMessage(String identify, String message) throws IOException {
        if (webSocketMaps.get(identify) != null) {
            webSocketMaps.get(identify).sendMessage(message);
        } else {
            log.error("identify is [" + identify + "] websocket is not exist！");
        }
    }

    private void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

}
