import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "file:///home/valeriy/Desktop/calcGo.html";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

 
    @Test
  public void testMCAdd() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("txtN1")).clear();
    driver.findElement(By.id("txtN1")).sendKeys("10");
    driver.findElement(By.id("txtOp")).clear();
    driver.findElement(By.id("txtOp")).sendKeys("+");
    driver.findElement(By.id("txtN2")).clear();
    driver.findElement(By.id("txtN2")).sendKeys("6");
    driver.findElement(By.id("btnGo")).click();
    assertEquals("16", driver.findElement(By.id("txtRes")).getAttribute("value"));
  }
  
    @Test
  public void testMCminus() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("txtN1")).clear();
    driver.findElement(By.id("txtN1")).sendKeys("10");
    driver.findElement(By.id("txtOp")).clear();
    driver.findElement(By.id("txtOp")).sendKeys("-");
    driver.findElement(By.id("txtN2")).clear();
    driver.findElement(By.id("txtN2")).sendKeys("6");
    driver.findElement(By.id("btnGo")).click();
    assertEquals("4", driver.findElement(By.id("txtRes")).getAttribute("value"));
  }
    
    @Test
  public void testMCUmn() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("txtN1")).clear();
    driver.findElement(By.id("txtN1")).sendKeys("10");
    driver.findElement(By.id("txtOp")).clear();
    driver.findElement(By.id("txtOp")).sendKeys("*");
    driver.findElement(By.id("txtN2")).clear();
    driver.findElement(By.id("txtN2")).sendKeys("6");
    driver.findElement(By.id("btnGo")).click();
    assertEquals("60", driver.findElement(By.id("txtRes")).getAttribute("value"));
  }
  
    @Test
  public void testMCDel() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("txtN1")).clear();
    driver.findElement(By.id("txtN1")).sendKeys("10");
    driver.findElement(By.id("txtOp")).clear();
    driver.findElement(By.id("txtOp")).sendKeys("/");
    driver.findElement(By.id("txtN2")).clear();
    driver.findElement(By.id("txtN2")).sendKeys("5");
    driver.findElement(By.id("btnGo")).click();
    assertEquals("2", driver.findElement(By.id("txtRes")).getAttribute("value"));
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
