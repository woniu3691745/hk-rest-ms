package com.team.hk.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by lidongliang on 2017/6/27.
 * 通过yml获得参数
 */
@Component
@ConfigurationProperties(prefix = "connection")
public class ConnectionProperties {

    private String username;
    private String remoteAddress;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }
}
