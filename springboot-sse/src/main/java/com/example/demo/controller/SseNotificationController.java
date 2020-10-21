package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@RestController
public class SseNotificationController {

    private static final Logger log = LoggerFactory.getLogger(SseNotificationController.class);

    public static final Map<String, SseEmitter> SSE_HOLDER = new ConcurrentHashMap<>(); // (A)

    @GetMapping("/api/sse-notification")
    public SseEmitter files(HttpServletRequest request) {
        long millis = TimeUnit.SECONDS.toMillis(60);
        SseEmitter sseEmitter = new SseEmitter(millis); // (B)
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        SSE_HOLDER.put(sessionid, sseEmitter);
        return sseEmitter;
    }

    /**
     * 通过sessionId获取对应的客户端进行推送消息
     */
    public static void usesSsePush(String sessionid, String content, int percent) {  // (C)
        SseEmitter emitter = SseNotificationController.SSE_HOLDER.get(sessionid);
        if (Objects.nonNull(emitter)) {
            try {
                if(percent==100){
                    emitter.send(content);
                    emitter.complete();
                } else {
                    emitter.send(content);
                }
            } catch (IOException | IllegalStateException e) {
                log.warn("sse send error", e);
                SseNotificationController.SSE_HOLDER.remove(sessionid);
            }
        }
    }

}
