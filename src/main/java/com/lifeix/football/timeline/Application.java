package com.lifeix.football.timeline;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.lifeix.football.common.ApplicationUtil;

@SpringBootApplication
@EnableAsync
public class Application {

    public static void main(String[] args) {
        ApplicationUtil.run(Application.class, args);
    }

}
