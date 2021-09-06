package cn.com.godliu.shirodemo.cfg;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@ComponentScan
@Configuration
@ConfigurationProperties(prefix="spring.datasource")
/**
 * 数据源配置文件
 */
public class DataSourceConfig {

//    private String url;
//    private String username;
//    private String password;
//    @Bean
//    public DataSource getDataSource(){
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(url);
//        druidDataSource.setUsername(username);
//        druidDataSource.setPassword(password);
//        return druidDataSource;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
