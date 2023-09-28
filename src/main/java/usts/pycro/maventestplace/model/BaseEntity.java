package usts.pycro.maventestplace.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:16
 */
@Data
public class BaseEntity implements Serializable {
    private Long id;
    private Long createUser;
    private Long updateUser;
    private Date createTime;
    private Date updateTime;
    private Long tenantId;
    private Integer deleteFlag;
}
