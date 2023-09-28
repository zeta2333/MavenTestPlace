package usts.pycro.maventestplace;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Pycro
 */
@SpringBootApplication
@MapperScan("usts.pycro.maventestplace.mapper")
public class MavenTestPlaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenTestPlaceApplication.class, args);
    }

}
