package usts.pycro.maventestplace.dto;

import com.mybatisflex.annotation.ColumnMask;
import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-11 17:45
 */
@Data
public class ArticleDTO {
    private Long id;

    private Long accountId;

    private String title;

    private String content;

    // 用户相关字段
    private String accountName;

    private Integer age;

    private String email;

    @ColumnMask("pycro_sensitive_rule")
    private String passwd;
}
