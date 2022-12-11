package prjg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Nclass {
	
	By UN_FIELD = By.xpath("//*[@id=\"username\"]");
	By PW_FIELD = By.xpath("//*[@id=\"password\"]");
	By LOGINBTN_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
	By DB_TEXT = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
	By Costumer = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
	By ADD_costumer = By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a");
	By DropDown = By.xpath("//*[@id=\"cid\"]");
	By FULLNAME = By.xpath("//*[@id=\"account\"]");
	By ADDCONTACT = By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5");
	By HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"); 
	
	WebDriver driver ;
	
	String url ="";	
	String browser= "";
	@BeforeMethod
	public void init ( ) {
		
		String path = "C:\\Users\\simou\\eclipse-workspace\\prjg\\src\\main\\java\\pkg\\config.properties";
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@BeforeClass
	public void readconfig () throws IOException {
		String path = "C:\\Users\\simou\\eclipse-workspace\\prjg\\src\\main\\java\\pkg\\config.properties";
//		File f = new File(path);
//		FileReader fr = new FileReader(f);
//		BufferedReader  br = new BufferedReader(fr);
		
		
		try {
			InputStream input = new FileInputStream(path);
			Properties prop = new Properties ();
			prop.load(input);
			browser = prop.getProperty("browser");
			url = prop.getProperty("url");
			System.out.println();
		}catch(IOException e) {
			
		}
		}
	@Test(priority = 1)
		public void logintest () throws Exception {
		int k = random(999);
//		Random rnd = new Random();
//		
//		int gennum = rnd.nextInt(999);

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo@techfios.com" );
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
		driver.findElement(FULLNAME).sendKeys("myawtmnya");
		Select sad = new Select(driver.findElement(By.xpath("//*[@id=\"cid\"]")));
		sad.selectByVisibleText("Amazon");
		driver.findElement(By.xpath("//*[@id=\"cid\"]"));
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("1203 Sotogrande"+ k);
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("7777777777"+ k);
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Euless"+ k);
		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Texas"+ k);
		driver.findElement(By.xpath("//*[@id=\"zip\"]")).sendKeys("76040"+ k);
//		Select country = new Select (driver.findElement(By.xpath("//*[@id=\"country\"]")));
//		country.selectByValue("Algeria");
		
		SelectFromDropDown(driver.findElement(By.xpath("//*[@id=\"country\"]")),"Algeria");
		
		Select tags = new Select (driver.findElement(By.xpath("//*[@id=\"tags\"]")));
		tags.selectByVisibleText("Nicho");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"rform\"]/div[2]/div/div/div/a")).click();
		
		
		
		
	}
	

		private  int random(int i) {
			Random rnd = new Random();
			
			int gennum = rnd.nextInt(i);
		return gennum;
	}
		private void SelectFromDropDown(WebElement dropelement, String selectVisible) {
		// TODO Auto-generated method stub
			
			Select country = new Select (dropelement);
			country.selectByValue(selectVisible);
	}
		
		
		//@Test(priority = 2)
		public void addcustomer ( ) {
			
			driver.findElement(By.xpath("//input[@name='username']")).sendKeys("demo@techfios.com");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc123");
			driver.findElement(By.xpath("//button[@name='login']")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]")).click();
			driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a")).click();
			Select sad = new Select(driver.findElement(By.xpath("//*[@id=\"cid\"]")));
			driver.findElement(By.xpath("//*[@id=\"cid\"]"));
			driver.findElement(FULLNAME).sendKeys("Techfiosovic");
			sad.selectByVisibleText("Amazon");
			
			
		}
		
}
