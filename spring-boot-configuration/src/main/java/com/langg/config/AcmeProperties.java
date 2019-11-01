package com.langg.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * acme配置类
 *
 * @author zhuhao
 * @date 2019/11/1 22:39
 * @since 1.0.0
 **/
@Component
@ConfigurationProperties("acme")
public class AcmeProperties {
    private boolean enabled;

    private InetAddress remoteAddress;

    private final Security security = new Security();

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public InetAddress getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(InetAddress remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public Security getSecurity() {
        return this.security;
    }

    public static class Security {

        private String username;

        private String password;

        private List<String> roles = new ArrayList<>(Collections.singleton("USER"));

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

        public List<String> getRoles() {
            return roles;
        }

        public void setRoles(List<String> roles) {
            this.roles = roles;
        }

        @Override
        public String toString() {
            return "Security{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", roles=" + roles +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AcmeProperties{" +
                "enabled=" + enabled +
                ", remoteAddress=" + remoteAddress +
                ", security=" + security +
                '}';
    }
}
