package com.warship.test.javabase.anno_extend;

import java.lang.annotation.*;

/**
 * @author erp
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GrandFather {
    String value();
}
