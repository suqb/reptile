package com.suqb.reptile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author suqb 2023/4/18
 * selenium基本用法
 */
public class SeleniumBaseUse {

    public static void main(String[] args) {
        //参数配置
        System.setProperty("webdriver.chrome.driver", "C:\\env\\reptile\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        // 获取class
        List<WebElement> elements = driver.findElements(By.className("hotsearch-item"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        // 获取id
//        WebElement kw = driver.findElement(By.id("kw"));
//        System.out.println(kw.getAttribute("name"));

        // 获取name
//        WebElement ele = driver.findElement(By.name("tn"));
//        System.out.println(ele.getAttribute("value"));

        // 获取tag
//        List<WebElement> input = driver.findElements(By.tagName("input"));
//        for (WebElement element : input) {
//            System.out.println(element.getAttribute("value"));
//            System.out.println(element);
//        }

        // 获取link
//        List<WebElement> map = driver.findElements(By.linkText("地图"));
//        for (WebElement element : map) {
//            System.out.println(element.getText());
//        }

        // a标签文本内容模糊匹配
//        List<WebElement> like = driver.findElements(By.partialLinkText("万商"));
//        for (WebElement element : like) {
//            System.out.println(element.getText());
//        }

        // css选择器
//        List<WebElement> elements = driver.findElements(By.cssSelector(":root"));
//        for (WebElement element : elements) {
//            System.out.println(element.getText());
//        }

        // xpath选择器
//        WebElement driverElement = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
//        System.out.println(driverElement.getAttribute("class"));

        // 再文本框中输入内容
//        WebElement driverElement = driver.findElement(By.id("kw"));
//        driverElement.sendKeys("java");
//        WebElement driverElement1 = driver.findElement(By.id("su"));
//        driverElement1.click();

        // 获取单个元素
//        String attribute = driver.findElement(By.name("ie")).getAttribute("value");
//        System.out.println(attribute);

        // 获取多个元素
//        List<WebElement> life = driver.findElements(By.partialLinkText("命"));
//        for (WebElement element : life) {
//            System.out.println(element.getText());
//        }

    }

}