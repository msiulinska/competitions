package competitions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Competitions {

    private WebDriver driver;

    public Competitions() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.firefox.bin", "C:\\Programy\\Mozilla Firefox 64\\firefox.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Magda&Monia\\Desktop\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://lamp.ii.us.edu.pl/~mtdyd/zawody/");
    }

    @Test
    public void emptyForm() {
        driver.findElement(By.id("inputEmail3")).clear();
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("15-05-2018");
        driver.findElement(By.cssSelector(".btn")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("First name must be filled out", alertText);

        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).clear();
        driver.findElement(By.id("dataU")).sendKeys("10-10-2008");
        driver.findElement(By.cssSelector(".btn")).click();
        Alert alert1 = driver.switchTo().alert();
        String alertText1 = alert1.getText();
        alert1.accept();
        Assert.assertEquals("Nazwisko musi byc wypelnione", alertText1);

        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).clear();
        driver.findElement(By.cssSelector(".btn")).click();
        Alert alert2 = driver.switchTo().alert();
        String alertText2 = alert2.getText();
        alert2.accept();
        Assert.assertEquals("Data urodzenia nie moze byc pusta", alertText2);
    }

    @Test
    public void noMedicalCertificate() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-04-1951");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Blad danych", alertText);
    }

    @Test
    public void noPermission() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2006");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Blad danych", alertText);
    }

    @Test
    public void adult() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2000");
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Dorosly", alertText);
    }

    @Test
    public void junior() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2001");
        driver.findElement(By.id("rodzice")).click();
        driver.findElement(By.id("lekarz")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Junior", alertText);
    }

    @Test
    public void youngling() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2005");
        driver.findElement(By.id("rodzice")).click();
        driver.findElement(By.id("lekarz")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Mlodzik", alertText);
    }

    @Test
    public void gnome() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2007");
        driver.findElement(By.id("rodzice")).click();
        driver.findElement(By.id("lekarz")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Skrzat", alertText);
    }

    @Test
    public void tooYoung() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-2018");
        driver.findElement(By.id("rodzice")).click();
        driver.findElement(By.id("lekarz")).click();
        driver.findElement(By.cssSelector(".btn")).click();
        driver.switchTo().alert().accept();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        Assert.assertEquals("Brak kwalifikacji", alertText);
    }

    @Test
    public void separators() {
        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05-05-1988");
        driver.findElement(By.cssSelector(".btn")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        driver.switchTo().alert().accept();
        Assert.assertFalse(alertText.startsWith("Roznica: NaN"));

        driver.findElement(By.id("inputEmail3")).sendKeys("Magda");
        driver.findElement(By.id("inputPassword3")).sendKeys("Siulinska");
        driver.findElement(By.id("dataU")).sendKeys("05:05:1988");
        driver.findElement(By.cssSelector(".btn")).click();
        Alert alert2 = driver.switchTo().alert();
        String alertText2 = alert2.getText();
        alert2.accept();
        driver.switchTo().alert().accept();
        Assert.assertFalse(alertText2.startsWith("Roznica: NaN"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
