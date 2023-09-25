package usts.pycro.maventestplace.model;

import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-25 14:08
 */
@Data
@Table("single_table")
public class SingleTable {
    @Id(keyType = KeyType.Auto)
    private Integer id;
    @Column("key1")
    private String key1;
    @Column("key2")
    private Integer key2;
    @Column("key3")
    private String key3;
    @Column("key_part1")
    private String keyPart1;
    @Column("key_part2")
    private String keyPart2;
    @Column("key_part3")
    private String keyPart3;
    @Column("common_field")
    private String commonFiled;
}
