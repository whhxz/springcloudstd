package com.whh.springcloud.service.remote;

import org.springframework.stereotype.Component;

/**
 * DemoRemoteServiceFallBack
 * Created by xuzhuo on 2018/1/19.
 */
@Component
public class DemoRemoteServiceFallBack implements DemoRemoteService {
    @Override
    public String home(String name) {
        return name + " System Error";
    }
}
