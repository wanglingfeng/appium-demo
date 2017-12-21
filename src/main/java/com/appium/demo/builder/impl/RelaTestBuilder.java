package com.appium.demo.builder.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.List;

/**
 * Created by lfwang on 2017/12/18.
 */
public class RelaTestBuilder extends BaseTestBuilder {
    
    @Override
    public DesiredCapabilities createCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();

        /*File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/main/java/apps/"); // app的目录
        File app = new File(appDir, "app-official-release.apk"); // app的名字，对应你apps目录下的文件*/

        cap.setCapability("automationName", "Appium"); // appium做自动化
        cap.setCapability("deviceName", "a66fcc83"); // 设备名称(如果是真机和udid保持一致即可)
        cap.setCapability("udid", "a66fcc83"); // 设备的udid (adb devices 查看到的)
        cap.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "6.0.1"); // 安卓操作系统版本
        /*cap.setCapability("app", app.getAbsolutePath());*/
        cap.setCapability("appPackage","com.thel"); // 被测app的包名
        cap.setCapability("appActivity",".modules.welcome.WelcomeActivity"); // 被测app的入口Activity名称
        cap.setCapability("unicodeKeyboard", "True"); // 支持中文输入
        cap.setCapability("resetKeyboard", "True"); // 支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); // 不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); // 没有新命令，appium30秒退出

        return cap;
    }

    @Override
    public void testMethod(AppiumDriver driver) {
        // 利用Xpath的方法寻找text值为注册的控件并点击
        driver.findElementByXPath(".//*[@text='注册']").click();

        // 通过uiautomatorviewer找到app上对应控件的id
        driver.findElementById("com.thel:id/rel_country_code").click(); // 选择国家和地区代码
        driver.findElementById("com.thel:id/txt_write").click(); // 手动填写国家和地区代码
        driver.findElementById("com.thel:id/et_code_input").sendKeys("99"); // 手动输入
        driver.findElementByXPath(".//*[@text='确认']").click(); // 点击确认
        driver.findElementById("com.thel:id/et_phone_num").sendKeys("19999999995"); // 输入手机号
        driver.findElementById("com.thel:id/et_code_input").sendKeys("9999"); // 输入验证码
        driver.findElementByXPath(".//*[@text='注册']").click(); // 注册
    }
}
