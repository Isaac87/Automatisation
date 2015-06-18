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

public class AfficheBarreServiceTest{
	private FirefoxBinary binary = new FirefoxBinary(new File("C:/Mozilla Firefox/firefox.exe"));
	private FirefoxProfile profile = new FirefoxProfile();
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	 @Before
	  public void setUp() throws Exception {
		  driver = new FirefoxDriver(binary,profile);
	      baseUrl = "http://www.rfi.fr/";
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	 @Test
	  public void testAfficheBarreService() throws Exception {
	    driver.get(baseUrl);
	    //localiser le header
	    WebElement header = driver.findElement(By.xpath("/html/body/header/div[1]/div[1]"));
	    String headertop = header.getCssValue("top");
	    System.out.println("top: "   +headertop );
	    if (headertop.equals("-27px")) {
	    	System.out.println("OK");
			}
		 else{
			 //si logo n'existe pas forcer la faillure du build
			 String verificationErrorString = verificationErrors.toString(); 
			 fail(verificationErrorString); 
			 
		 }
	   
	  }
	 @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
	 private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }
	 private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }
	 private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }
}