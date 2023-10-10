package usts.pycro.maventestplace.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.ColumnMask;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:31
 */
@Data
@Table("account")
public class Account {
    @Id
    private Long id;

    @Column("account_name")
    private String accountName;

    @Column("age")
    private Integer age;

    @Column("password")
    @ColumnMask("pycro_sensitive_rule")
    private String password;

    @Column("email")
    private String email;
}
