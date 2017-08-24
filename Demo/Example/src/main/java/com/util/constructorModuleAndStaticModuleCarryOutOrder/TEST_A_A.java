package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class TEST_A_A {
    public TEST_A_A() {
        System.out.println("TEST_A_A的构造函数");
    }

    {System.out.println("TEST_A_A");}

    static {
        System.out.println("static TEST_A_A");
    }
}
