package com.langg.web;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketEndpoint
 *
 * @author zh
 * @date 2019/11/14 17:22
 * @since 1.0.0
 */
@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketEndpoint {

    /**
     * 存放回话session
     */
    private static ConcurrentHashMap<String, Session> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 连接建立成功调用的方法
     *
     * @param username 用户名
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value = "username") String username, Session session) {
        webSocketSet.put(session.getId(), session);

        sendAll("[" + username + "]加入聊天");
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        webSocketSet.remove(session.getId());

        sendAll("[" + username + "]离开聊天");
    }

    /**
     * 接收客户端消息
     *
     * @param username 用户名
     * @param message 消息内容
     */
    @OnMessage
    public void onMessage(@PathParam("username") String username, String message) {

        sendAll(username + ":" + message);
    }

    /**
     * 发送消息给所有会话
     *
     * @param message 消息内容
     */
    private void sendAll(String message) {
        webSocketSet.forEach((sessionId, session) -> {
            sendMessage(session, message);
        });
    }


    /**
     * 处理异常
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {

    }

    /**
     * 发送消息
     * @param session 会话session
     * @param message 消息内容
     */
    public void sendMessage(Session session, String message) {
        //同步发送
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //异步发送
        //this.session.getAsyncRemote().sendText(message);
    }
}
