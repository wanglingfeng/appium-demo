package com.appium.demo.builder.impl;

import com.appium.demo.builder.TestBuilder;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by lfwang on 2017/12/18.
 */
public abstract class BaseTestBuilder implements TestBuilder {

    public AppiumDriver driver;
    
    public void build() {
        try {
            DesiredCapabilities cap = createCapabilities();
            // 把以上配置传到appium服务端并连接手机
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // 隐式等待
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    
    public void test() {
        testMethod(driver);
    }
    
    public abstract DesiredCapabilities createCapabilities();

    public abstract void testMethod(AppiumDriver driver);
}
