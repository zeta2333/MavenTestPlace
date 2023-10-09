package usts.pycro.maventestplace.entity;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-07 15:46
 */
@Data
@Table("sys_user")
public class SysUser {
    @Id(keyType = KeyType.Auto)
    private Long id;
    @Column("name")
    private String name;
    @Column("age")
    private Integer age;
}
