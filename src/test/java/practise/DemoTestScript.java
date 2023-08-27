package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoTestScript {

	public static void main(String[] args) {
	//step 1:launch the broswer
     WebDriver driver =new FirefoxDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("http://localhost:8080");
    
    //step 2:Login to application
    driver.findElement(By.name("user_name")).sendKeys("admin");
    driver.findElement(By.name("user_password")).sendKeys("manager");
    driver.findElement(By.name("submitButton")).click();
	
	//step 3:navigate to contacts link
    driver.findElement(By.linkText("Contacts")).click();
    
    //step 4: click on create contact look up image
    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    
    //step 5:create contact with mandatory fields
    driver.findElement(By.name("lastname")).sendKeys("vijuu");
    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
    
    //step 6:verification for contact                                            
   String ContactHeader= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
    if(ContactHeader.contains("vijuuu"))
    {
    System.out.println(ContactHeader+"---pass---");	
    }
    else
    {
    System.out.print("---fail---");
    }
    
    //step 7:logout of application
     WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
     
     //mouse hover
     Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	
	//sign out
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Sign out successfull");
}
}
