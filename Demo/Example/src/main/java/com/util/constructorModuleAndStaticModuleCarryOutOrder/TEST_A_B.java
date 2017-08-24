package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 * 本例子用于实验: 构造代码块（前面没有任何声明的，直接在类里面定义的代码块）
 * 构造代码块在创建对象的时候被调用，并且每次创建对象都会被调用一次；
 * 构造代码块执行的顺序在该类的构造函数之前。
 * 正确的执行顺序是：父类静态代码块→子类静态代码块→父类构造代码块→父类构造函数→子类构造代码块→子类构造函数。
 *
 */

public class TEST_A_B extends TEST_A_A {

    public TEST_A_B() {
        System.out.println("TEST_A_B的构造函数");
    }

    // 构造代码块
    {System.out.println("TEST_A_B");}

    static {
        System.out.println("static TEST_A_B");
    }

    public static void main(String[] args) {
        new TEST_A_B();
    }
}
