package usts.pycro.maventestplace.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usts.pycro.maventestplace.entity.SensitiveRecognizeRule;
import usts.pycro.maventestplace.entity.SensitiveRecognizeRuleVo;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:08
 */
@RestController
@RequestMapping("/model")
public class EntityController {

    @RequestMapping("/getSensitiveRecognizeRuleDemo")
    public ResponseEntity<?> getSensitiveRecognizeRuleDemo() {
        SensitiveRecognizeRule sensitiveRecognizeRule = new SensitiveRecognizeRule() {{
            setCreateTime(new Date());
            setUpdateTime(new Date());
            setRuleName("敏感规则名称");
            setDescription("敏感规则描述");
            setTemplateId(233L);
            setSensitiveDataRange(1);
            setSensitiveDataContent("[1,2,3]");
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
        SensitiveRecognizeRuleVo sensitiveRecognizeRuleVo = new SensitiveRecognizeRuleVo();
        BeanUtils.copyProperties(sensitiveRecognizeRule, sensitiveRecognizeRuleVo);
        sensitiveRecognizeRuleVo.setSensitiveDataContent(JSON.parseArray(
                sensitiveRecognizeRule.getSensitiveDataContent(),
                Integer.class
        ));
        ResponseEntity<SensitiveRecognizeRuleVo> responseEntity = ResponseEntity.ok(sensitiveRecognizeRuleVo);
        System.out.println(responseEntity);
        return responseEntity;
    }
}
