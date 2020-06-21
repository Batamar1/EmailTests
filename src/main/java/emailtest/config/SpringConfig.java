package emailtest.config;

import emailtest.pageobject.BasePage;
import emailtest.pageobject.HomePage;
import emailtest.pageobject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "emailtest")
public class SpringConfig {

    @Bean
    public WebDriver webDriver() {



        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();






        Parameters params = new Parameters();

        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName("application.properties"));
        org.apache.commons.configuration2.Configuration conf = null;
        try {
            conf = builder.getConfiguration();
        } catch (ConfigurationException cex) {
            // loading of the configuration file failed
        }
        DriverManagerType browserType = DriverManagerType.valueOf(conf.getString("browser.name"));
        WebDriverManager.getInstance(browserType).setup();
        WebDriver webDriver = WebDriverBrowserHelper.getWebDriver(browserType);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        PageFactory.initElements(webDriver, HomePage.class);
//        PageFactory.initElements(webDriver, LoginPage.class);
        return webDriver;
    }

}
