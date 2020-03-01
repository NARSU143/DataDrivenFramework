package com.abc.magentotest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Magentotest {
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("G:\\Programs\\Programming class\\DatadrivernFramework\\src\\com\\abc\\utilities\\datadriven.properties");
		
		Properties p = new Properties();
		p.load(fis);
		String urldata = p.getProperty("url");
		String emaildata = p.getProperty("email");
		String passdata = p.getProperty("pass");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(urldata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emaildata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passdata);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
