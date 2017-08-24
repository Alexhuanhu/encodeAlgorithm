package com.util.constructorModuleAndStaticModuleCarryOutOrder;

/**
 * Created by Alexhu on 2017/7/24.
 */
public class TEST_A {

        public TEST_A() {
            System.out.println("TEST_A的构造函数");
        }

        static {
            System.out.println("static TEST_A");
        }

}
