package com.warship.test.javabase.classhotfix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HotFixController {

    @Autowired
    JarByteHotFix jarByteHotFix;

    @RequestMapping("/hotfix/do")
    @ResponseBody
    public String hotfix() throws Exception {
        return jarByteHotFix.hotfixClass("com.warship.test.javabase.classhotfix.TargetController", "/Users/erp/tmp/TargetController.class");
    }

}
