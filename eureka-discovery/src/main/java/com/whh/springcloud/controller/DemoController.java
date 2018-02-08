package com.whh.springcloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController
 * Created by xuzhuo on 2018/1/17.
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @RequestMapping("home")
    public String home(@RequestParam String name){
        logger.info(name);
        return "welcome " + name;
    }
}
