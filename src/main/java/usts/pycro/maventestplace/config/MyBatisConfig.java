package usts.pycro.maventestplace.config;

import com.mybatisflex.core.mask.MaskManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:45
 */
@Configuration
@MapperScan("usts.pycro.maventestplace.mapper")
public class MyBatisConfig {

    static {
        MaskManager.registerMaskProcessor("pycro_sensitive_rule", data -> "(*^▽^*)");
    }
}
