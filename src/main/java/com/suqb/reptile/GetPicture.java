package com.suqb.reptile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author suqb 2023/4/18
 */
public class GetPicture {
    public static WebDriver driver = null;
    public static List<String> imgList = new ArrayList<String>();

    static {
        System.setProperty("webdriver.chrome.driver", "C:\\env\\reptile\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void getImg() {
        driver.get("http://www.gaoimg.com/");
        sleep(3);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(2);
//        List<WebElement> img = driver.findElements(By.cssSelector("body > div.tuijiantupian > div.flex-images > div > a > img"));
        List<WebElement> img = driver.findElements(By.tagName("img"));
        for (WebElement element : img) {
            String src = element.getAttribute("src");
            if (src != null) {
                imgList.add(src);
            }
        }
    }

    public static void saveImg() {
        try {
            String path = "C:\\images\\";
            URL url = null;
            for (String src : imgList) {
                if (src.contains("data")) {
                    continue;
                }
                url = new URL(src);
                DataInputStream dis = new DataInputStream(url.openStream());
                String filename = path + UUID.randomUUID().toString().replace("-", "") + ".jpg";
                FileOutputStream fos = new FileOutputStream(new File(filename));
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = dis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                dis.close();
                fos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try{
            getImg();
            for (String s : imgList) {
                System.out.println(s);
            }
            saveImg();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
