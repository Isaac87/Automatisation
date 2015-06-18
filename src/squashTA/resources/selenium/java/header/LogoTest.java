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

public class LogoTest{
	
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
		  //jse = (JavascriptExecutor)driver;
	    baseUrl = "http://www.rfi.fr/";
	 // Maximize the browser's window
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 @Test
	  public void testLogo() throws Exception {
		 
		    try { 

		    	 driver.get(baseUrl);
				 WebElement img = driver.findElement(By.xpath("/html/body/header/div[1]/h1/a"));
				 String imgpath = img.getCssValue("background-image");
				 System.out.println("image : "+imgpath);
				 System.out.println(imgpath);
				 System.out.println(imgpath.indexOf("logo_rfi_v2.png"));
				 if (imgpath.indexOf("logo_rfi_v2.png") != -1) {
					  // it contains world
					 
					}
				 else{
					 //si logo n'existe pas forcer la faillure du build
					 String verificationErrorString = verificationErrors.toString(); 
					 fail(verificationErrorString); 
					 
				 }

		      } catch (NoSuchElementException e) { 

		        

		      } 
		 
		  Thread.sleep(100);	    
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