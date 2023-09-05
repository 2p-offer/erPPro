package com.warship.test.javabase.classhotfix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TargetController {

    @GetMapping("/print")
    @ResponseBody
    public String print() {
        return getResult();
    }

    public String getResult() {
        return "test-METHOD";
    }

}
