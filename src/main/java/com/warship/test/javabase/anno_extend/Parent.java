package com.warship.test.javabase.anno_extend;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author erp
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@GrandFather("test")
public @interface Parent {

    String value() default "def";
}
