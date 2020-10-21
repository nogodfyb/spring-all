package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class DownloadController {
    private static final Logger log = LoggerFactory.getLogger(DownloadController.class);
    @Autowired
    private MockDownloadComponent downloadComponent;

    @GetMapping("/api/download/{type}")
    public String download(@PathVariable String type, HttpServletRequest request) {  // (A)
        HttpSession session = request.getSession();
        String sessionid = session.getId();
        log.info("sessionid=[{}]", sessionid);
        downloadComponent.mockDownload(type, sessionid);  // (B)
        return "success"; // (C)
    }
}
