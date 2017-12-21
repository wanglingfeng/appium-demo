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
public class ContactManagerTestBuilder extends BaseTestBuilder {
    
    @Override
    public DesiredCapabilities createCapabilities() {
        DesiredCapabilities cap = new DesiredCapabilities();

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "/src/main/java/apps/"); // app的目录
        File app = new File(appDir, "ContactManager.apk"); // app的名字，对应你apps目录下的文件

        cap.setCapability("automationName", "Appium"); // appium做自动化
        cap.setCapability("deviceName", "a66fcc83"); // 设备名称(如果是真机和udid保持一致即可)
        cap.setCapability("udid", "a66fcc83"); // 设备的udid (adb devices 查看到的)
        cap.setCapability("platformName", "Android"); // 安卓自动化还是IOS自动化
        cap.setCapability("platformVersion", "6.0.1"); // 安卓操作系统版本
        cap.setCapability("app", app.getAbsolutePath());
        cap.setCapability("appPackage", "com.example.android.contactmanager"); // 设置app的包名
        cap.setCapability("appActivity", ".ContactManager"); // 设置app的启动activity
        cap.setCapability("unicodeKeyboard", "True"); // 支持中文输入
        cap.setCapability("resetKeyboard", "True"); // 支持中文输入，必须两条都配置
        cap.setCapability("noSign", "True"); // 不重新签名apk
        cap.setCapability("newCommandTimeout", "30"); // 没有新命令，appium30秒退出

        return cap;
    }

    @Override
    public void testMethod(AppiumDriver driver) {
        // 利用Xpath的方法寻找text值为Add Contact的控件
        WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
        // 点击这个控件
        el.click();
        // 利用类名获取界面上所有的EditText
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        // 第一个EditText输入内容Some Name
        textFieldsList.get(0).sendKeys("Some Name");
        // 第三个EditText输入内容Some Name
        textFieldsList.get(2).sendKeys("Some@example.com");
        // 在坐(100,500)滑动到(100,100) 时间为2毫秒
        driver.swipe(100, 500, 100, 100, 2);
        // 用xpath的方式寻找到text值为Save的控件，然后点击
        /*driver.findElementByXPath("./*//*[@text='Save']").click();*/
    }
}
