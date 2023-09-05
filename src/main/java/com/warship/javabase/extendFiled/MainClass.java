package com.warship.test.javabase.extendFiled;

public class MainClass {
    public static void main(String[] args) {
        //当父类和子类有同名字段的时候，到底调用哪个值，取决于 对象定义类型。是子类还是父类。
        SuperClass c = new SonClass();
        System.out.println(c.field);
        SonClass cc = new SonClass();
        //如果 SonClass 实现了   SuperInter 接口，则无法调用field字段，因为，父类和接口同时有个同名字段
//        System.out.println(cc.field);
    }
}
