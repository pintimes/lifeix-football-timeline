package com.lifeix.football.timeline;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableAsync;

import com.lifeix.football.timeline.util.ProfileUtil;

//same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
@EnableAsync
public class Application {

    /**
     * @check jar tvf target/designer-0.0.1-SNAPSHOT.jar 查看这个jar包里面的内容
     * @description -t 显示jar中的内容列表 -v 生成详细的报造，并输出至标准设备 -f 指定jar包的文件名
     * 
     * @run1 java -jar target/designer-0.0.1-SNAPSHOT.jar
     * @run2 mvn spring-boot:run (at project root)
     * 
     *       开启远程调试 参见SpringBoot 19.2章节 java -Xdebug
     *       -Xrunjdwp:server=y,transport=dt_socket,address=8000,suspend=n \ -jar
     *       target/myproject-0.0.1-SNAPSHOT.jar
     * 
     * @param args
     */
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);
        logger.info("command line:{}", Arrays.deepToString(args));
        SpringApplication app = new SpringApplication(Application.class);
        /**
         * 应用程序事件,一般情况处理ApplicationContext 没有初始化的事件 e.g ApplicationStartedEvent
         * ApplicationEnvironmentPreparedEvent 初始化后，可以使用@Bean
         */
        ApplicationListener<?> listeners = new ApplicationListener<ApplicationEvent>() {

            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                logger.info(event.toString());
            }
        };
        app.addListeners(listeners);
        /**
         * 所有环境都必须加载的配置我们约定为common，参见application-common.properties 环境变量的命名 ENV_PROFILE_项目名
         * 通过环境变量获得加载相应的配置文件
         */
        String[] profiles = ProfileUtil.getProfiles("PROFILE_ENV");
        app.setAdditionalProfiles(profiles);
        app.run(args);
    }

}
