package usts.pycro.maventestplace.entity;

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

    private String key1;

    private Integer key2;

    private String key3;

    private String keyPart1;

    private String keyPart2;

    private String keyPart3;

    private String commonFiled;
}
