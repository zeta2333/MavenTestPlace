package usts.pycro.maventestplace.entity;

import lombok.Data;

import java.util.List;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:10
 */
@Data
public class SensitiveRecognizeRuleVo extends BaseEntity {
    private String ruleName;
    private String description;
    private Long templateId;
    private Integer sensitiveDataRange;
    private List<Integer> sensitiveDataContent;
    private Integer sensitiveDataRequirement;
    private Integer dataTypeCount;
    private List<Integer> intMembers;

}
