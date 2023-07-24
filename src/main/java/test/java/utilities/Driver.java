package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private Driver(){
 //TO BLOCK CREATING OBJECT FROM DRIVER CLASS WE NEED TO TURN ACCESS MODIFIER OF CONSTRUCTOR INTO PRIVATE
 //DEFAULT  CONSTRUCTOR ACCESS MODIFIER. THIS YONTEME ***SINGLETON PATTERN*** DENIR.
    }
  //POM:Page Object Model  : it is a test style that provides less codes typing and easy maintenance.
//    POM used by testNG and cucumbar framework

//   TUM CLASS LARDA AYNI OBJECT KULLANMAK ICIN OLUSTURULAN CLASS A SINGLETON

    static WebDriver driver;


    public static WebDriver getDriver (){

        if(driver==null){//driver a value atanmamissa.IF CLOSE  IS AIMED AT OPENING IN A PAGE ALL URL,NOT  SEPARATE
                                                                    //BROWSERS

           /*
.properties dosyasına key olarak browser ve değerini aşağıda oluşturduğumuz switch case lerden birini seçeriz
                ve seçtiğimiz driver çalışır
 */

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

   return driver;
    }
    public static void closeDriver(){

        if(driver!=null){//driver a value atanmissa.
            driver.close();
            driver=null;//driveri kapattiktan sonra bosalt
             }
    }
    public static void quitDriver(){


        if(driver!=null){//driver a value atanmissa.
            driver.quit();
            driver=null;//driver i kapattiktan sonra bosalt
        }
    }
}
