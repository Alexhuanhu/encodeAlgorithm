package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class Person {

    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person: " + str);
    }
}
