package emailtest.config;

import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverBrowserHelper {
    public static WebDriver getWebDriver(DriverManagerType driverManagerType){
        switch(driverManagerType) {
            case CHROME:
                return new ChromeDriver();
//            case CHROMIUM:
//                return "Chromium";
//            case FIREFOX:
//                return "Firefox";
//            case OPERA:
//                return "Opera";
            case EDGE:
                return new EdgeDriver();
//            case PHANTOMJS:
//                return "PhantomJS";
            case IEXPLORER:
                return new InternetExplorerDriver();
//            case SAFARI:
//                return "Safari";
//            case SELENIUM_SERVER_STANDALONE:
//                return "Selenium Server Standalone";
            default:
                throw new WebDriverManagerException("Invalid driver manager type: ");
        }
    }
}
