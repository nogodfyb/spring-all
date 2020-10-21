package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class MockDownloadComponent {
    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);

    @Async // (A)
    public void mockDownload(String type, String sessionid) {
        for (int i = 0; i < 100; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100); // (B)

                int percent = i + 1;
                String content = String.format("{\"username\":\"%s\",\"percent\":%d}", sessionid, percent); // (C)
                log.info("username={}'s file has been finished [{}]% ", sessionid, percent);

                switch (type) { // (D)
                    case "sse":
                        SseNotificationController.usesSsePush(sessionid, content,percent);
                        break;
                    case "ws":
                        // WebSocketNotificationHandler.usesWSPush(sessionid, content);
                        break;
                    case "stomp":
                        // this.usesStompPush(sessionid, content);
                        break;
                    default:
                        throw new UnsupportedOperationException("");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
