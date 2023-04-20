package com.emdata.ivvs.config;

import com.emdata.ivvs.vo.BaseVo;

/**
 * Created by tanglingxin on 2019/12/23.
 */
public class FtpConfig extends BaseVo{
    /**
     * ftp文件基础目录
      */
    private String basePath;

    /**
     * ftp主机
     */
    private String host;

    /**
     * 端口
     */
    private int port;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * ftp字符集编码
     */
    private String chatSet;


    /**
     * ftp视频格式后缀
     */
    private String videoSuffix;


    /**
     * ftp图片格式后缀
     */
    private String imageSuffix;


    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getVideoSuffix() {
        return videoSuffix;
    }

    public void setVideoSuffix(String videoSuffix) {
        this.videoSuffix = videoSuffix;
    }

    public String getImageSuffix() {
        return imageSuffix;
    }

    public void setImageSuffix(String imageSuffix) {
        this.imageSuffix = imageSuffix;
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

    public String getChatSet() {
        return chatSet;
    }

    public void setChatSet(String chatSet) {
        this.chatSet = chatSet;
    }
}
