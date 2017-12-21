package com.appium.demo;

import com.appium.demo.builder.TestBuilder;
import com.appium.demo.builder.impl.CalculatorTestBuilder;
import com.appium.demo.builder.impl.ContactManagerTestBuilder;
import com.appium.demo.builder.impl.RelaTestBuilder;

/**
 * Created by lfwang on 2017/12/15.
 */
public class AppiumTests {
    
    public static void main(String... args) {
        /*TestBuilder builder = new CalculatorTestBuilder();*/
        /*TestBuilder builder = new ContactManagerTestBuilder();*/
        TestBuilder builder = new RelaTestBuilder();

        builder.build();
        builder.test();
    }
}
