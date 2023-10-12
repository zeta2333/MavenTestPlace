package usts.pycro.maventestplace.vo;

import lombok.Data;
import usts.pycro.maventestplace.entity.Article;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-12 13:19
 */
@Data
public class AccountVo {
    private Long id;

    private String accountName;

    private Integer age;

    private String password;

    private String email;

    private List<Article> articles;
}
