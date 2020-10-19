package pers.czl.spring.transaction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Description:
 * @Author: wb-ccl670938
 * @CreateTime: 2020-10-14 16:05
 * @Version:1.0
 **/
@Configuration
@ConfigurationProperties(prefix = "datasource")
public class DataSourceProperties {
    private String username;
    private String password;
    private String url;
    private String driverClassName;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}