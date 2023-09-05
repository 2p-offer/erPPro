package com.warship.test.javabase.anno_extend;

/**
 * @author erp
 */
public class AnnoExtendMain {
    public static void main(String[] args) {
        AnnoExtendTest test = new AnnoExtendTest();
        String parentValue = test.getClass().getAnnotation(Parent.class).value();
        System.out.println(parentValue);
        final String value =
                test.getClass().getAnnotation(GrandFather.class).value();
        System.out.println(value);
    }
}
