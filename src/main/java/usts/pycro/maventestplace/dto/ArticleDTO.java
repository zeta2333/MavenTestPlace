package usts.pycro.maventestplace.dto;

import lombok.Data;
import usts.pycro.maventestplace.entity.Account;

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
    private Account account;
    // private String accountName;
    //
    // private Integer age;
    //
    // private String email;
    //
    // @ColumnMask("pycro_sensitive_rule")
    // private String passwd;
}
