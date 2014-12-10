import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Selenium {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "file:///home/valeriy/calculator.html/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSumm() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button1")).click();
    driver.findElement(By.id("buttonP")).click();
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("buttonR")).click();
    assertEquals("3", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testMinus() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button7")).click();
    driver.findElement(By.id("buttonM")).click();
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("buttonR")).click();
    assertEquals("5", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton1() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button1")).click();
    assertEquals("1", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton0() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button0")).click();
    assertEquals("0", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton2() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button2")).click();
    assertEquals("2", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton3() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button3")).click();
    assertEquals("3", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton4() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button4")).click();
    assertEquals("4", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton5() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button5")).click();
    assertEquals("5", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton6() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button6")).click();
    assertEquals("6", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton7() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button7")).click();
    assertEquals("7", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton8() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button8")).click();
    assertEquals("8", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testbutton9() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button9")).click();
    assertEquals("9", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

@Test
  public void testumn() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button7")).click();
    driver.findElement(By.id("buttonMd")).click();
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("buttonR")).click();
    assertEquals("14", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

  @Test
  public void testDel() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button8")).click();
    driver.findElement(By.id("buttonD")).click();
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("buttonR")).click();
    assertEquals("4", driver.findElement(By.id("resultField")).getAttribute("value"));
  }
  
  @Test
  public void testDel0() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button7")).click();
    driver.findElement(By.id("buttonD")).click();
    driver.findElement(By.id("button2")).click();
    driver.findElement(By.id("buttonR")).click();
    assertEquals("3,5", driver.findElement(By.id("resultField")).getAttribute("value"));
  }

    @Test
  public void testMC() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("button8")).click();
    assertEquals("8", driver.findElement(By.id("resultField")).getAttribute("value"));
    driver.findElement(By.id("buttonC")).click();
    assertEquals("0", driver.findElement(By.id("resultField")).getAttribute("value"));
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
