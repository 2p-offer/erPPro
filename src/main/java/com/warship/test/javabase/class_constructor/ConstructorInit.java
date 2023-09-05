package com.warship.test.javabase.class_constructor;

/**
 * @author erp
 */
public class ConstructorInit {


    private String abd;
    private static ConstructorInit INSTANT;

    public ConstructorInit() {
        abd = "123l";
        INSTANT = this;
    }

    public static ConstructorInit getInstance(){
        return INSTANT;
    }

    public String getAbd() {
        return abd;
    }

    public void setAbd(String abd) {
        this.abd = abd;
    }
}
