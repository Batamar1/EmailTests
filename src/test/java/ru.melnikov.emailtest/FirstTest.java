package ru.melnikov.emailtest;

import emailtest.applogic.ApplicationManager;
import emailtest.config.SpringConfig;
import emailtest.model.Email;
import emailtest.model.User;
import emailtest.pageobject.HomePage;
import emailtest.pageobject.LoginPage;
import emailtest.pageobject.PageManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class, loader = AnnotationConfigContextLoader.class)
public class FirstTest {

    @Autowired
    private ApplicationManager applicationManager;

    @Before
    public void setUp(){
        //WebDriverManager.chromiumdriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("enable-automation");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-infobars");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--disable-browser-side-navigation");
//        options.addArguments("--disable-gpu");
      //  this.driver = new ChromeDriver();
    }


    @Test
    public void sendMessage() throws InterruptedException {
//
        applicationManager.inFormLogin();
        User user = new User();
        user.setLogin("m3lnikov.artem");
        user.setPassword("435275tema");
        applicationManager.loginAs(user);
        Email email = new Email();
        email.setReceivers(Arrays.asList("metema7@gmail.com","metema97@gmail.com"));
        email.setSubject("test");
        email.setText("test");
        applicationManager.writeEmail(email);

    }

}
