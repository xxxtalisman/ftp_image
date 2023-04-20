package com.emdata.ivvs.config;

import com.emdata.analysis.service.AnalysisService;
import com.emdata.analysis.service.impl.AnalysisFtpStr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/**
 * Created by tanglingxin on 2019/12/23.
 */
@Configuration
public class BeanConfig {

    @Value("${ftp.basePath}")
    private String basePath;

    /**
     * ftp主机
     */
    @Value("${ftp.ip}")
    private String host;

    /**
     * 端口
     */
    @Value("${ftp.port}")
    private int port;

    /**
     * 用户名
     */
    @Value("${ftp.name}")
    private String username;

    /**
     * 密码
     */
    @Value("${ftp.passWord}")
    private String password;


    /**
     * ftp字符编码
     */
    @Value("${ftp.chatSet}")
    private String charSet;


    /**
     * ftp视频格式后缀
     */
    @Value("${ftp.videoSuffix}")
    private String videoSuffix;


    /**
     * ftp图片格式后缀
     */
    @Value("${ftp.imageSuffix}")
    private String imageSuffix;


    @Bean
    public AnalysisService analysisFtpStr(){
        return new AnalysisFtpStr();
    }



    @Bean(name = "defaultFtpConfig")
    public FtpConfig getFtpConfig() {
        FtpConfig config = new FtpConfig();
        config.setBasePath(this.basePath);
        config.setHost(this.host);
        config.setPassword(this.getPassword());
        config.setPort(this.getPort());
        config.setUsername(this.username);
        config.setChatSet(this.charSet);
        config.setVideoSuffix(this.videoSuffix);
        config.setImageSuffix(this.imageSuffix);
        return config;
    }

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
