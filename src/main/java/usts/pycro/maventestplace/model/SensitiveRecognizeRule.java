package usts.pycro.maventestplace.model;

import lombok.Data;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:10
 */
@Data
public class SensitiveRecognizeRule extends BaseEntity {
    private String ruleName;
    private String description;
    private Long templateId;
    private Integer sensitiveDataRange;
    private String sensitiveDataContent;
    private Integer sensitiveDataRequirement;
    private Integer dataTypeCount;

}
