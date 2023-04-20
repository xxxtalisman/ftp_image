package com.emdata.ivvs;

import com.emdata.ivvs.service.impl.HandleFtpDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring boot 启动类
 * 
 * @author txw
 * @date 2019/12/10
 */

@SpringBootApplication
@RestController
@EnableAutoConfiguration
@ComponentScan
@ImportResource(locations = {"classpath:application-*-*.xml"})
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class DataFtpImageApplication extends SpringBootServletInitializer {

    /**
     * tomcat启动方式
     */
    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(DataFtpImageApplication.class);
    }

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(DataFtpImageApplication.class);
        builder.headless(false).run(args);
    }

    @Autowired
    private HandleFtpDataService handleFtpDataService;

    @RequestMapping("/111")
    public String test() {
        handleFtpDataService.handleRemoteFile("111");
        return "111";
    }

}
