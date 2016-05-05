package com.lifeix.football.timeline;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    /**
     * we can get main method args by ApplicationArguments
     * 
     * @param args
     */
    @Autowired
    public AppConfig(ApplicationArguments args) {
        List<String> files = args.getNonOptionArgs();
        System.out.println(files.toString());
    }

    private String name;

    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}