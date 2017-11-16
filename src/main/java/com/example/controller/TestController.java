/*
 * All rights Reserved, Designed By CavanLiu
 * Copyright (c) 2017 by Energy Blockchain Labs.
 *
 * @ClassName:     DeployController.java
 * @Description:   Web部署测试controller
 *
 * @author:        CavanLiu
 * @version:       V1.0.0
 * @Date:          17-11-13 下午2:28
 */

package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@SuppressWarnings("unchecked")
@RestController
public class TestController
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/sessionRedis/test")
    public ResponseEntity<?> httpSessionRedisTest(HttpSession httpSession)
    {
        if (httpSession.isNew()) {
            logger.info("Successfully creates a session ，the id of session ：" + httpSession.getId());
            httpSession.setAttribute("key", "hello");
        } else {
            logger.info("session already exists in the server, the id of session ：" + httpSession.getId());
            logger.info(httpSession.getAttribute("key").toString());
        }

        ResponseEntity<?> entity = new ResponseEntity<Object>("Hello world, session id:"
                                                                + httpSession.getId(), HttpStatus.OK);

        return entity;
    }
}
