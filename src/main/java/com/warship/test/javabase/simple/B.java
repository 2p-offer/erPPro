package com.warship.test.javabase.simple;

/**
 * @author erp
 */
public class B {
    As alist = new As();

    public void addList(A a) {
        alist.addAlist(a);
    }

    @Override
    public String toString() {
        return "B{" +
                "alist=" + alist +
                '}';
    }

    public As getAlist() {
        return alist;
    }

    public void setAlist(As alist) {
        this.alist = alist;
    }


}
