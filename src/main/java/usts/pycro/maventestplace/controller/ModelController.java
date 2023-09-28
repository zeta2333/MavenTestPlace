package usts.pycro.maventestplace.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import usts.pycro.maventestplace.model.SensitiveRecognizeRule;

/**
 * @author Pycro
 * @version 1.0
 * 2023-09-27 14:08
 */
@RestController
@RequestMapping("/model")
public class ModelController {

    @PostMapping("/getSensitiveRecognizeRuleDemo")
    public SensitiveRecognizeRule getSensitiveRecognizeRuleDemo() {
        return new SensitiveRecognizeRule();
    }
}
