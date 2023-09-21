package usts.pycro.maventestplace.config;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-21 9:52 AM
 * 与SpringBoot配置文件绑定属性的类，不可以设置@Accessors(fluent = true),
 * SpringBoot自动配置寻找setFiledName()方法，
 * 而配置@Accessors(fluent = true)后，方法都变成FieldName()，无法匹配到!
 */
@Component
@EnableConfigurationProperties
@ConfigurationProperties("common")
@Data
@Accessors(chain = true)
public class CommonProperties {

    private User user;
    private String hostname;
    private FtpInfo defaultFtp;

    @Getter
    @Setter
    @ToString
    static class User {
        private String username;
        private String password;
        private String address;
        private String email;
    }

    @Getter
    @Setter
    static class FtpInfo {
        private String host;
        private Integer ip;
        private String user;
        private String password;
    }
}
