package com.warship.test.javabase.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author erp
 */
public class As {

    List<A> aList = new ArrayList<>();

    public void addAlist(A a) {
        aList.add(a);
    }


    @Override
    public String toString() {
        return "As{" +
                "aList=" + aList +
                '}';
    }

    public List<A> getaList() {
        return aList;
    }

    public void setaList(List<A> aList) {
        this.aList = aList;
    }
}
