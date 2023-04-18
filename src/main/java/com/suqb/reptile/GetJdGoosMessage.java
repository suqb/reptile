package com.suqb.reptile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @author suqb 2023/4/18
 */
public class GetJdGoosMessage {

    public static void main(String[] args) throws InterruptedException {

        // 加载驱动到jvm
        System.setProperty("webdriver.chrome.driver", "C:\\env\\reptile\\chromedriver_win32\\chromedriver.exe");
        // 初始化驱动
        ChromeDriver driver = new ChromeDriver();
        // 设置爬取网站
        driver.get("https://www.jd.com");
        // 获取经典查询条件输出框
        WebElement input = driver.findElement(By.id("key"));
        // 输入关键字
        input.sendKeys("电脑");
        // 获取点击按钮
        WebElement btn = driver.findElement(By.className("button"));
        // 点击搜索
        btn.click();
        // 睡会觉
        Thread.sleep(3000);
        // 将滚动条滚到下面
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        // 再睡会觉
        Thread.sleep(3000);
        // *[id="J_goodsList"]/ul/li[3]
        // 查询页面所有商品
        List<WebElement> goodsElement = driver.findElements(By.xpath("//*[@id=\"J_goodsList\"]/ul/li"));
        for (WebElement goods : goodsElement) {
            String price = goods.findElement(By.className("p-price")).getText();
            String name = goods.findElement(By.className("p-name")).getText();
            System.out.println(name + price);
            System.out.println("-----------------------------------------------------------------");
        }
    }
}
