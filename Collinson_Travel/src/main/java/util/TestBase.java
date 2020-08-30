package util;

import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
               try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("C:\\Users" +
                    "\\sivanarayana.g\\Collinson_Travel\\src\\main\\java\\config\\config.properties");

            prop.load(fileInputStream);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
    public static void initialization(){
        String browserName =prop.getProperty("browser");
        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\sivanarayana.g\\Collinson_Travel\\Drivers\\chromedriver.exe");
            driver = new ChromeDriver();

        }
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, SECONDS );
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, SECONDS);


    }
    public static void windowshandles(){
        Set<String> allwindowhandles = driver.getWindowHandles();
        Iterator<String> itr = allwindowhandles.iterator();
        int size = allwindowhandles.size();
        String child = null;

        for (int i = 0; i < size; i++) {
            child = itr.next();

        }
        driver.switchTo().window(child);
    }
    public static void scroledown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }
    public static void takeSnapShot() throws AWTException, IOException {
        Robot r = new Robot();
        String path = "C:\\Users\\sivanarayana.g\\Collinson_Travel\\target\\images\\Shot.jpg";
        Rectangle capture =
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage Image = r.createScreenCapture(capture);
        ImageIO.write(Image, "jpg", new File(path));

    }
    public static void implicitwait() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

}