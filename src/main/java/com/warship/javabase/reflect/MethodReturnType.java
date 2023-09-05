package com.warship.test.javabase.reflect;

import java.lang.reflect.Method;

/**
 * @author erp
 */
public class MethodReturnType {


    public static void main(String[] args) throws NoSuchMethodException {
        MethodReturnType methodReturnType = new MethodReturnType();
        final Method returnVoid = methodReturnType.getClass().getMethod("returnVoid");
        final Class<?> returnType = returnVoid.getReturnType();
        System.out.println("returnVoid:" + returnType);
        final Method returnVoidClass = methodReturnType.getClass().getMethod("returnVoidClass");
        final Class<?> returnType1 = returnVoidClass.getReturnType();
        System.out.println("returnVoidClass:" + returnType1);
        final Method returnString = methodReturnType.getClass().getMethod("returnString");
        System.out.println("returnString:" + returnString.getReturnType());
        System.out.println(Void.TYPE.equals(returnType));
        System.out.println(Void.TYPE.equals(returnType1));

    }

    public void returnVoid() {

    }

    public Void returnVoidClass() {
        return null;
    }

    public String returnString() {
        return null;
    }
}
