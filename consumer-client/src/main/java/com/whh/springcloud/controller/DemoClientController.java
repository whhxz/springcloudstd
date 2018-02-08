package com.whh.springcloud.controller;

import com.whh.springcloud.service.remote.DemoRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * DemoClientController
 * Created by xuzhuo on 2018/1/18.
 */
@RestController
@RequestMapping("client")
public class DemoClientController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DemoRemoteService demoRemoteService;

    @RequestMapping("home")
    public String home() {
        return restTemplate.getForObject("http://EUREKA-DISCOVERY/demo/home?name=whh", String.class);
    }

    @RequestMapping("feignHome")
    public String feignHome(){
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 100; j++) {
                    System.out.println(demoRemoteService.home("whh"));
                }
            }).start();
        }
        return demoRemoteService.home("whh");
    }
}
