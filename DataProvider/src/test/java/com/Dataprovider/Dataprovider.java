package com.Dataprovider;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dataprovider {
	

	@Test(dataProvider="testdata")
	public void login(String username, String password)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://whiteboxqa.com/login.php");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login")).click(); 
		 driver.close();
		
	}
	
	
	@DataProvider(name="testdata")
	public Object[][] testDataExample() throws IOException{
	ReadExcelFile configuration = new ReadExcelFile("/Users/lakshmi/eclipse-workspace/DataProvider/src/test/resources/testData/login.xlsx");
	int rows = configuration.getRowCount(0);
	Object[][]signin_credentials = new Object[rows][2];

	for(int i=0;i<rows;i++)
	{
	signin_credentials[i][0] = configuration.getData(0, i, 0);
	signin_credentials[i][1] = configuration.getData(0, i, 1);
	}
	return signin_credentials;
	}
	}




