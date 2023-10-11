package usts.pycro.maventestplace.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *  实体类。
 *
 * @author Pycro
 * @since 2023-10-11
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "article")
public class Article implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Long id;

    private Long accountId;

    private String title;

    private String content;

}
