package usts.pycro.maventestplace.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-21 10:04 AM
 */
@SpringBootTest
@EnableConfigurationProperties(CommonProperties.class)
public class CommonPropertiesTest {
    @Autowired
    private CommonProperties commonProperties;

    @Test
    public void testGetProperties() {
        // commonProperties.user()
        //         .username("Pycro")
        //         .password("1234456")
        //         .address("Suzhou")
        //         .email("123@46.com");
        System.out.println(commonProperties.getUser());

    }

}
