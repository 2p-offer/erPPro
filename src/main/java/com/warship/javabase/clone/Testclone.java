package com.warship.test.javabase.clone;

/**
 * @author erp
 */

public class Testclone {
    String name;
    String desc;

    public static void main(String[] args) throws CloneNotSupportedException {
        Testclone test = new Testclone();
        test.setName("name");
        test.setDesc("desc");
        System.out.println(test);
        Testclone clone = (Testclone) test.clone();

        System.out.println(clone);
        test.setDesc("desc1");
        System.out.println(clone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Testclone{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
