package com.warship.test.javabase.simple;

/**
 * @author erp
 */
public class A {
    B belond;

    public void setMyBelond(B b) {
        this.belond = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "belond=" + belond +
                '}';
    }

    public B getBelond() {
        return belond;
    }

    public void setBelond(B belond) {
        this.belond = belond;
    }
}
