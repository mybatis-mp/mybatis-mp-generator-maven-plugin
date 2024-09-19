package cn.mybatis.mp.plugin.generator.configuration;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * @title: DataSourceConfig
 * @author: trifolium.wang
 * @date: 2024/9/18
 */
public class DataSourceConfig {

    /**
     * 数据库连接字符串
     */
    @Parameter(property = "mybatis.mp.generator.jdbcUrl")
    private String jdbcUrl;

    /**
     * 数据库用户名
     */
    @Parameter(name = "mybatis.mp.generator.username")
    private String username;

    /**
     * 数据库密码
     */
    @Parameter(name = "mybatis.mp.generator.password")
    private String password;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
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
