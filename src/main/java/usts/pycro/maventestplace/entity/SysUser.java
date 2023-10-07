package usts.pycro.maventestplace.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-10-07 15:46
 */
@Data
@TableName("sys_user")
public class SysUser {
    @TableField("id")
    private Long id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
}
