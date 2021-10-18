import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class EmailTesting {
	WebDriver driver;
	private String bodyText = "Sample Email Message";
	private String recipient = "tahabikanerwala@mail.com";
	private String subject = "Sample Subject Line";

	@BeforeSuite
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "S:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void openSite() {
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
	}

	@Test(priority = 2)
	public void logIn() {
		WebElement signinButton = driver.findElement(By.linkText("Sign in"));
		signinButton.click();
		driver.findElement(By.id("identifierId")).sendKeys("dummymail.586458@gmail.com");
		driver.findElement(By.cssSelector("#identifierNext > div > button > span")).click();
		driver.findElement(By.xpath("//input[@name=\'password\']")).sendKeys("dummymail@6");
		driver.findElement(By.xpath("//*[@id=\'passwordNext\']/div/button/span")).click();

	}

	@Test(priority = 3) // Test Case 1
	public void composeClick() {
		// Clicking on Compose button
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		driver.findElement(By.xpath("//img[@class='Ha']")).click();

	}

	@Test(priority = 4) // Test Case 2
	public void sendMail() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText);
		driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 5) // Test Case 3
	public void sendWithCC() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
		// Element to click CC
		driver.findElement(By.xpath("//span[@class='aB gQ pE']")).click();
		// Element for Adding CC recipient
		driver.findElement(By.xpath("//textarea[@name='cc']")).sendKeys(recipient);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText);
		driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click();
		Thread.sleep(4000);
	}

	@Test(priority = 6) // Test Case 4
	public void sendWithAttachmentFromDrive() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
		driver.findElement(By.className("aoT")).sendKeys(subject);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText);
		// Element to click on Google Drive icon
		driver.findElement(By.xpath("//div[@class='aA7 aaA aMZ']")).click();
		WebElement myframe = driver.findElement(By.xpath("//iframe[@class='KA-JQ']"));
		driver.switchTo().frame(myframe);
		driver.findElement(By.xpath("//div[@class='ge-Fi-hc ge-Df-ke']")).click();
		// Element to click on MyDrive
		driver.findElement(By.xpath("//div[@class='ge-Di-Zb-Pj']")).click();
		// Element to click on attachment
//		Actions action = new Actions(driver);
//		WebElement elementLocator = driver.findElement(By.xpath("//div[@class='Od-nh-Gf-Q-Kc']"));
//		action.doubleClick(elementLocator);
		driver.findElement(By.xpath("//div[@class='Od-nh-Gf-Q-Kc']")).click();
		Thread.sleep(2000);
		// Element to click on Insert button
		driver.findElement(By.xpath("//div[@class='a-b-c d-u d-u-F ge-tb-jf-enabled']")).click();
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).click();
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3']")).click();
		Thread.sleep(4000);

	}

	
	  @Test(priority=7) //Test Case 5 
	  public void sendWithEmoji() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
	  driver.findElement(By.className("aoT")).sendKeys(subject);
	  driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText); 
	  //Element to click on emoji icon
	  driver.findElement(By.xpath("//div[@class='QT aaA aMZ']")).click(); 
	  //ELement to switch to emoji tab
	  driver.findElement(By.xpath("//button[@title='Show face emoticons']")).click(); 
	  //Selecting My Fav Emoji
	  driver.findElement(By.xpath("//button[@aria-label='face with tears of joy']")).click();
	  driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click(); 
	  Thread.sleep(4000); }
	
	 
	  @Test(priority = 8) //Test Case 6 
	  public void sendWithoutRecipient() throws InterruptedException { 
	  driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	  //Finding Element for Subject Line
	  driver.findElement(By.className("aoT")).click();
	  driver.findElement(By.className("aoT")).sendKeys(subject); 
	  //Element for Body Text
	  driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText); 
	  //Element for Send Button
	  driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click(); 
	  //Element for Ok button on Error Message
	  driver.findElement(By.xpath("//button[@name=\'ok\']")).click();
	  driver.findElement(By.xpath("//img[@class='Ha']")).click();
	  Thread.sleep(4000); }
	  
	  @Test(priority=9) //Test Case 7 
	  public void sendWithoutSubject() throws InterruptedException {
	  
	  driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
	  driver.findElement(By.className("aoT")).clear();
	  driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText);
	  driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click(); 
	  Thread.sleep(4000); }
	  
	  @Test(priority=10) //Test Case 8 
	  public void sendWithoutBody() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	  //Element for Recipient
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
	  driver.findElement(By.className("aoT")).clear();
	  driver.findElement(By.className("aoT")).sendKeys(subject);
	  driver.findElement(By.xpath("//div[@class=\'T-I J-J5-Ji aoO v7 T-I-atl L3\']")).click(); 
	  Thread.sleep(4000); }
	  
	  
	  @Test(priority=11) //Test Case 9 
	  public void discardDraft() throws InterruptedException {
	  driver.findElement(By.xpath("//div[@class='T-I T-I-KE L3']")).click();
	  driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys(recipient);
	  driver.findElement(By.className("aoT")).sendKeys(subject);
	  driver.findElement(By.xpath("//div[@class='Am Al editable LW-avf tS-tW']")).sendKeys(bodyText);
	   driver.findElement(By.xpath("//div[@class='oh J-Z-I J-J5-Ji T-I-ax7']")).click(); 
	   Thread.sleep(4000);
	 
	  }
	 
}
