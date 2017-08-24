package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 * 本例子用于实验：静态代码块
 * 静态代码块是在类加载的时候调用的；
 * 先执行 父类的静态代码块，再执行子类的静态代码块，再执行父类的构造函数，最后执行子类的构造函数。
 */
public class TEST_B extends TEST_A {

    public TEST_B() {
        System.out.println("TEST_B的构造函数");
    }

    // 静态代码块（static代码块）；静态代码块是在类加载的时候调用的，而且只会调用一次；
    static {
        System.out.println("static TEST_B");
    }

    public static void main(String[] args) {
        new TEST_B();
    }

}
