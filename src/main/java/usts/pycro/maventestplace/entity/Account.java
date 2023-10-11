package usts.pycro.maventestplace.entity;

import com.mybatisflex.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-09 9:31
 */
@Data
@Table("account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id(keyType = KeyType.Auto)
    private Long id;

    @Column("account_name")
    private String accountName;

    @Column("age")
    private Integer age;

    @Column("password")
    private String password;

    @Column("email")
    private String email;
}
