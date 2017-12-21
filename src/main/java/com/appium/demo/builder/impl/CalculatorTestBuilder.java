package com.appium.demo.builder.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by lfwang on 2017/12/18.
 */
public class CalculatorTestBuilder extends BaseTestBuilder {
    
    @Override
    public DesiredCapabilities createCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("automationName", "Appium"); // appium做自动化
        cap.setCapability("deviceName", "a66fcc83"); // 设备名称(如果是真机和udid保持一致即可)
        cap.setCapability("udid", "a66fcc83"); // 设备的udid (adb devices 查看到的)
        cap.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "6.0.1"); // 安卓操作系统版本
        /*cap.setCapability("appPackage","com.android.calculator2");// 被测app的包名*/
        cap.setCapability("appPackage","com.sec.android.app.popupcalculator"); // 三星计算器
        cap.setCapability("appActivity",".Calculator"); // 被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); // 支持中文输入
        cap.setCapability("resetKeyboard", "True"); // 支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); // 不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); // 没有新命令，appium30秒退出

        return cap;
    }

    @Override
    public void testMethod(AppiumDriver driver) {
        driver.findElementByXPath("./*//*[@text='1']").click();
        driver.findElementByXPath("./*//*[@text='+']").click();
        driver.findElementByXPath("./*//*[@text='1']").click();
        driver.findElementByXPath("./*//*[@text='=']").click();
    }
}
