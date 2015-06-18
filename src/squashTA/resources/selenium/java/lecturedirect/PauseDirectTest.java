import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import org.openqa.selenium.support.ui.Select;

public class PauseDirectTest{
	
	private FirefoxBinary binary = new FirefoxBinary(new File("C:/Mozilla Firefox/firefox.exe"));
	private FirefoxProfile profile = new FirefoxProfile();
	private WebDriver driver;
	private String baseUrl;
	private JavascriptExecutor jse;
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@Before
	  public void setUp() throws Exception {
		driver = new FirefoxDriver(binary,profile);
	    baseUrl = "http://www.rfi.fr/";
	 // Maximize the browser's window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	  }
	 @Test
	  public void testPauseDirect() throws Exception {
		 
		    try { 

		    	 driver.get(baseUrl);
		    	//verifier la présense du bouton play
		    	 if(driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div/a")).isDisplayed()){     
		    	     
		    		 //click sur le bouton play
		    		 driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div/a")).click();
		    		 Thread.sleep(60000);
		    		 //vérifation changement de div
		    		 
		    		 //WebElement verif = driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div"));
		    		 String verif=driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div")).getAttribute("class");
		    		 
		    		 
		    		 if (verif.equals("pl-pause playing")) {
		    			 
		    			//click sur le bouton pause
			    		 driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div/a")).click();
			    		 Thread.sleep(10000);
			    		 verif=driver.findElement(By.xpath("/html/body/header/div[1]/div[2]/div[1]/div[3]/div/div[1]/div")).getAttribute("class");
			    		 if (verif.equals("pl-pause")) {
			    			 
			    			 System.out.println(verif);
			    			 
			    		 }
			    		 else
			    		 {
			    			 String verificationErrorString = verificationErrors.toString(); 
							 fail(verificationErrorString); 
			    		 }
		    			 
		    		 }
		    		 else
		    		 {
		    			 String verificationErrorString = verificationErrors.toString(); 
						 fail(verificationErrorString); 
		    		 }
		    	 }
		    		 
		    	
		    	 
		    	 
		      } catch (NoSuchElementException e) { 

		    	  String verificationErrorString = verificationErrors.toString(); 
				  fail(verificationErrorString); 

		      } 
		 
		  Thread.sleep(900);	    
	  }
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	
}