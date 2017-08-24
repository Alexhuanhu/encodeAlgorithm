package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class Test {

    Person person = new Person("Test");

    static {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
    }
}
