package com.whh.springcloud.server;

import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.config.environment.PropertySource;
import org.springframework.cloud.config.server.environment.SvnKitEnvironmentRepository;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * DemoSvnRepository
 * Created by xuzhuo on 2018/1/19.
 */
@Component
public class DemoSvnRepository extends SvnKitEnvironmentRepository {
    public DemoSvnRepository(ConfigurableEnvironment environment) {
        super(environment);
    }

    @Override
    public synchronized Environment findOne(String application, String profile, String label) {
        Environment environment = super.findOne(application, profile, label);
        Properties properties = new Properties();
        PropertySource propertySource = new PropertySource("profile", properties);
        environment.add(propertySource);

        File workingDirectory = this.getWorkingDirectory();
        String profilePath = workingDirectory.getPath() + "/" + application + "/" + profile;
        try (FileInputStream fileInputStream = new FileInputStream(profilePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return environment;
    }

}
