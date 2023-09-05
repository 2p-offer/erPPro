package com.warship.test.javabase.staticblock;

/**
 * @author erp
 */
public class InitClass {
    static {
        System.out.println("init class static block");
    }

    public InitClass() {
        System.out.println("init class constructor");
    }

    {
        System.out.println("init lcass block");
    }

    public static int a = 1;
}
