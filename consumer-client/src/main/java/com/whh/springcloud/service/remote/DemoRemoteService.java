package com.whh.springcloud.service.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * RemoteDemoService
 * Created by xuzhuo on 2018/1/19.
 */
@FeignClient(value = "eureka-discovery", path = "demo", fallback = DemoRemoteServiceFallBack.class)
public interface DemoRemoteService {
    @RequestMapping(value = "home", method = RequestMethod.GET)
    String home(@RequestParam("name") String name);
}
