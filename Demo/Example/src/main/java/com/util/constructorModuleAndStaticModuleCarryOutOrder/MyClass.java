package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 * 本例子用于实验：子类和父类的 静态代码块、成员变量、构造函数的执行顺序
 * 正确执行顺序是： 父类静态代码块→子类静态代码块→父类成员变量→子类成员变量→父类构造函数→子类构造函数。
 */
public class MyClass extends Test {

    Person person = new Person("MyClass");

    static {
        System.out.println("myclass static");
    }

    public MyClass() {
        System.out.println("myclass constructor");
    }
}
