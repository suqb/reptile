package com.suqb.reptile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author lrkj
 * create time: 2023/4/24
 */
public class GetTaobaoGoodsMessage {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\environment\\reptile\\chromedriver_win32\\chromedriver.exe");

        ChromeDriver driver = new ChromeDriver();

        driver.get("https://taobao.com");

        WebElement input = driver.findElement(By.tagName("input"));

        input.click();

        input.sendKeys("电脑");

        WebElement btn = driver.findElement(By.tagName("button"));

        btn.click();

        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        WebElement imagesBox = driver.findElement(By.className("J_ItemPic"));

        String text = imagesBox.getText();

        System.out.println(text);
    }
}
