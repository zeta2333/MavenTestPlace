package usts.pycro.maventestplace.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usts.pycro.maventestplace.model.SensitiveRecognizeRule;

import java.util.ArrayList;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:08
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @RequestMapping("/getSensitiveRecognizeRuleDemo")
    public SensitiveRecognizeRule getSensitiveRecognizeRuleDemo() {
        SensitiveRecognizeRule sensitiveRecognizeRule = new SensitiveRecognizeRule() {{
            setRuleName("敏感规则名称");
            setDescription("敏感规则描述");
            setTemplateId(233L);
            setSensitiveDataRange(1);
            setSensitiveDataContent("敏感数据内容");
            setSensitiveDataRequirement(2);
            setDataTypeCount(3);
            setIntMembers(new ArrayList<Integer>() {
                {
                    add(1);
                    add(2);
                    add(3);
                    add(4);
                    add(5);
                }
            });
        }};
        return sensitiveRecognizeRule;
    }
}
